package Models;



public class daily {

    private int madaily;
    private String tendaily;
    private String diachi;
    private String sdt;
    private String email;
    private int maloaidl;
    private int maquan;
    private String ngaytn;
    private int tienno;
    private int person_id;


    public daily() {
    }

    public daily(int madaily, String tendaily, String diachi, String sdt, String email, int maloaidl, int maquan, String ngaytn, int tienno, int user_id) {
        this.madaily = madaily;
        this.tendaily = tendaily;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.maloaidl = maloaidl;
        this.maquan = maquan;
        this.ngaytn = ngaytn;
        this.tienno = tienno;
        this.person_id = user_id;
    }

    public int getMadaily() {
        return madaily;
    }

    public String getTendaily() {
        return tendaily;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public int getMaquan() {
        return maquan;
    }
    public int getTienno() {
        return tienno;
    }

    public int getMaloaidl() {
        return maloaidl;
    }

    public String getNgaytn() {
        return ngaytn;
    }

    public int getUser_id() {
        return person_id;
    }
}
