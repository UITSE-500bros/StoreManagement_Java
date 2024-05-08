package Models.User;

public class PersonConcreteBuilder implements PersonBulder {
    private String userName;
    private String userFamilyName;
    private String password;
    private String email;
    private String phoneNumber;

    public PersonConcreteBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }


    public PersonConcreteBuilder setUserFamilyName(String userFamilyName) {
        this.userFamilyName = userFamilyName;
        return this;
    }

    public PersonConcreteBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public PersonConcreteBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public PersonBulder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public person build() {
        return new person(userFamilyName, userName, password, email, phoneNumber);
    }
}
