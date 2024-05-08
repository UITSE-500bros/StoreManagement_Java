package Controller;

import Models.User.person;
import Models.User.PersonBulder;
import Models.User.PersonConcreteBuilder;
import UI.register;

public class UserRegisterController {

    public person person;
    public register register;

    public UserRegisterController(person person, register register) {
        this.person = person;
        this.register = register;
    }

    public void registerUser() {
        if (!register.getTextField_password().equals(register.getTextField_rePassWord())) {
            System.out.println("Password is not the same");
            return;
        }
        PersonBulder userFromView = new PersonConcreteBuilder()
                .setUserName(register.getTextField_name())
                .setUserFamilyName(register.getTextField_lastName())
                .setEmail(register.getTextField_email())
                .setPhoneNumber(register.getTextField_phoneNumber())
                .setPassword(register.getTextField_password());

        person person = userFromView.build();
    }

    public void register(person person) {
        this.person = person;
    }
}
