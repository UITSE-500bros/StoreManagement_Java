package Controller;

import Models.UserInstance;
import Models.person;
import Repository.Connection;
import UI.register;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UserRegisterController {

    public register register;
    private final Connection connection;

    public UserRegisterController(register register) {

        this.register = register;
        connection = new Connection();
    }


    public boolean registerUser() throws MalformedURLException {
    	boolean check = false;
    	
        if (!register.getTextField_password().equals(register.getTextField_rePassWord())) {
            System.out.println("Password is not the same");
            return false;
        }


        person person = new person();
        person.setPersonname(register.getTextField_name());
        person.setPersonlastname(register.getTextField_lastName());
        person.setPersonemail(register.getTextField_email());
        person.setPersonpassword(register.getTextField_password());
        person.setPersonsdt(register.getTextField_phoneNumber());


        String response = connection.insertUser(person);
        if (response.contains("201")){
            check = true;
            try {
                getUserByEmail(register.getTextField_email(),register.getTextField_password());

            
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return check;

    }

    private void getUserByEmail(String email,String pass) throws IOException {
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

    }

}
