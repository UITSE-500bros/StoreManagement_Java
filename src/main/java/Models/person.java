package Models;


import com.google.gson.annotations.SerializedName;

public class person {

    private int PPersonid;
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

    public person(int PPersonid, String personlastname, String personname, String personsdt, String personemail, String personpassword) {
        this.PPersonid = PPersonid;
        this.personlastname = personlastname;
        this.personname = personname;
        this.personsdt = personsdt;
        this.personemail = personemail;
        this.personpassword = personpassword;
    }

    public int getPPersonid() {
        return PPersonid;
    }

    public String getPersonlastname() {
        return personlastname;
    }

    public String getPersonname() {
        return personname;
    }

    public String getPersonsdt() {
        return personsdt;
    }

    public String getPersonemail() {
        return personemail;
    }

    public String getPersonpassword() {
        return personpassword;
    }

    public void setPersonlastname(String personlastname) {
        this.personlastname = personlastname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public void setPersonsdt(String personsdt) {
        this.personsdt = personsdt;
    }

    public void setPersonemail(String personemail) {
        this.personemail = personemail;
    }

    public void setPersonpassword(String personpassword) {
        this.personpassword = personpassword;
    }

    public void setPPersonid(int PPersonid) {
        this.PPersonid = PPersonid;
    }
}
