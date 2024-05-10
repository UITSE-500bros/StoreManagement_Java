package Models.User;

public class person {


    private String personlastname;
    private String personname;
    private String personsdt;
    private String personemail;
    private String personpassword;

    public person(){

    }

    public person(String personlastname, String personname, String personsdt, String personemail, String personpassword) {
        this.personlastname = personlastname;
        this.personname = personname;
        this.personsdt = personsdt;
        this.personemail = personemail;
        this.personpassword = personpassword;
    }

    public String getPersonlastname() {
        return personlastname;
    }

    public void setPersonlastname(String personlastname) {
        this.personlastname = personlastname;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getPersonsdt() {
        return personsdt;
    }

    public void setPersonsdt(String personsdt) {
        this.personsdt = personsdt;
    }

    public String getPersonemail() {
        return personemail;
    }

    public void setPersonemail(String personemail) {
        this.personemail = personemail;
    }

    public String getPersonpassword() {
        return personpassword;
    }

    public void setPersonpassword(String personpassword) {
        this.personpassword = personpassword;
    }
}
