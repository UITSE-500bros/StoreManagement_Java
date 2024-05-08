package Models.User;

public interface PersonBulder {
    PersonBulder setUserName(String userName);
    PersonBulder setUserFamilyName(String userFamilyName);
    PersonBulder setPassword(String password);
    PersonBulder setEmail(String email);
    PersonBulder setPhoneNumber(String phoneNumber);
    person build();
}
