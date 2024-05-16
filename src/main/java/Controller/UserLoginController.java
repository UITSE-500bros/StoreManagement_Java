package Controller;

import Repository.Connection;
import UI.login;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UserLoginController {
	private final Connection connection;
    public UserLoginController(login login) throws IOException {
		connection = new Connection();
    }


    private boolean isLoginSuccess = false;
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

        if(status == 200) {
            isLoginSuccess = true;
        }

    }

    public boolean isLoginSuccess() {
        return isLoginSuccess;
    }

}
