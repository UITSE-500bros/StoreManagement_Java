package Controller;

import Models.User.person;

import UI.login;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import com.google.gson.Gson;
import javax.net.ssl.HttpsURLConnection;

public class UserLoginController {
	private final Connection connection;
    public UserLoginController(login login) throws IOException {
		connection = new Connection();
    }
    public void getUserByEmail(String email,String pass) throws IOException {
        String encodedEmail = URLEncoder.encode(email, StandardCharsets.UTF_8);
        String encodedPassword = URLEncoder.encode(pass, StandardCharsets.UTF_8);
        String url = "http://localhost:8080/user/getLoginUser?email=" + email + "&password=" + encodedPassword;
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

        // convert json to object

		System.out.println(content);

    }

    
    
}
