package Controller;

import Models.UserInstance;
import Models.person;
import UI.login;
import com.google.gson.Gson;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UserLoginController {
	private final Connection connection;
    public UserLoginController(login login) throws IOException {
		connection = new Connection();
    }
    public void getUserByEmail(String email,String pass) throws IOException {
        String encodedEmail = URLEncoder.encode(email, StandardCharsets.UTF_8);
        String encodedPassword = URLEncoder.encode(pass, StandardCharsets.UTF_8);
        String url = "http://localhost:8080/user/getLoginUser?personemail=" + email + "&personpassword=" + encodedPassword;
        connection.setUrl(new URL(url));

        connection.openGetConnection();

        int status = connection.con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        // close connections
        in.close();
        connection.closeConnection();

        Gson gson = new Gson();
        person person = gson.fromJson(content.toString(), person.class);
        UserInstance.getInstance().setUser_id(person.getPPersonid());
        UserInstance.getInstance().setUser_name(person.getPersonname());
        UserInstance.getInstance().setUser_email(person.getPersonemail());
        System.out.println(UserInstance.getInstance().getUser_name() + " logged in");
    }

    
    
}
