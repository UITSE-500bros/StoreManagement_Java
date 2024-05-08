package Models.User;

public class person {
    private String userName;
    private String userFamilyName;
    private String password;
    private String phoneNumber;
    private String email;

    public person(){

    }

    public person(String userFamilyName, String userName, String password, String phoneNumber, String email) {
        this.userFamilyName = userFamilyName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
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
