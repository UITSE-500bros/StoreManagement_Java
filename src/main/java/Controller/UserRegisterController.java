package Controller;

import Models.UserInstance;
import Models.person;
import UI.register;
import java.net.MalformedURLException;
import java.util.Objects;

public class UserRegisterController {

    public register register;
    private final Connection connection;

    public UserRegisterController(register register) {

        this.register = register;
        connection = new Connection();
    }


    public void registerUser() throws MalformedURLException {
        if (!register.getTextField_password().equals(register.getTextField_rePassWord())) {
            System.out.println("Password is not the same");
            return;
        }


        person person = new person();
        person.setPersonname(register.getTextField_name());
        person.setPersonlastname(register.getTextField_lastName());
        person.setPersonemail(register.getTextField_email());
        person.setPersonpassword(register.getTextField_password());
        person.setPersonsdt(register.getTextField_phoneNumber());


        String response = connection.insertUser(person);
        System.out.println(response);
//        if (!response.equals("Create failed") && !response.equals("Email already exists")) {
//            if (!response.isEmpty()) {
//                int id = Integer.parseInt(response);
//                UserInstance.getInstance().setUser_id(id);
//                UserInstance.getInstance().setUser_name(person.getPersonname());
//                UserInstance.getInstance().setUser_email(person.getPersonemail());
//                System.out.println("User registered with id: " + id);
//            } else {
//                System.out.println(response);
//                System.out.println("User registered successfully, but no user ID was returned by the server.");
//            }
//        } else {
//            System.out.println("Error: " + response);
//        }
    }

}
