package Models.User;

public interface UserBulder {
    UserBulder setUserName(String userName);
    UserBulder setUserFamilyName(String userFamilyName);
    UserBulder setPassword(String password);
    UserBulder setEmail(String email);
    User build();
}
