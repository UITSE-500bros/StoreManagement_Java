package Controller;

import Repository.Connection;
import UI.login;
import java.io.*;


public class UserLoginController {
	private final Connection connection;
    public UserLoginController() throws IOException {
		connection = new Connection();
    }

    public String getUserByEmail(String email,String pass) throws IOException {
        return connection.loginUser(email,pass);
    }
}
