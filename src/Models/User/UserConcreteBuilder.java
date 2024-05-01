package Models.User;

public class UserConcreteBuilder {
    private String userName;
    private String userFamilyName;
    private String password;
    private String email;

    public UserConcreteBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserConcreteBuilder setUserFamilyName(String userFamilyName) {
        this.userFamilyName = userFamilyName;
        return this;
    }

    public UserConcreteBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserConcreteBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public User build() {
        return new User(userFamilyName, userName, password, email);
    }
}
