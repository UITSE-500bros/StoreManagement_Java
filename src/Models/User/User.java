package Models.User;

public class User {
    private String userName;
    private String userFamilyName;
    private String password;
    private String email;

    public User(){

    }

    public User(String userFamilyName,String userName, String password, String email) {
        this.userFamilyName = userFamilyName;
        this.userName = userName;
        this.password = password;
        this.email = email;

    }

    public String getUserFamilyName() {
        return userFamilyName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


}
