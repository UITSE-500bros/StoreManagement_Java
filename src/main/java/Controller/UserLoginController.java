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
        String url = "user/getLoginUser?personemail=" + encodedEmail + "&personpassword=" + encodedPassword;
        connection.openGetConnection(url);
        int status = connection.con.getResponseCode();
        connection.closeConnection();
        if(status == 200) {
            isLoginSuccess = true;
        }
    }
    public boolean isLoginSuccess() {
        return isLoginSuccess;
    }

}
