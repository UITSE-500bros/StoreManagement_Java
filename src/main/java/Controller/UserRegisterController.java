package Controller;

import Models.User.person;
import Models.User.PersonBulder;
import Models.User.PersonConcreteBuilder;
import UI.register;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class UserRegisterController {

    public register register;
    private Connection connection;

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


        if (!Objects.equals(connection.insertUser(person), "BAD_REQUEST")) {
            System.out.println("User created successfully");
        } else {
            System.out.println("User creation failed");
        }


    }



}
