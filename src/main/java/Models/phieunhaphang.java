package Models;

public class phieunhaphang {

    private int maphieunhap;
    private String ngaylp;
    private int tongtien;
    private int person_id;

    public phieunhaphang() {
        
    }

    public phieunhaphang(String ngaynhap, int tongtien, int person_id) {
        this.ngaylp = ngaynhap;
        this.tongtien = tongtien;
        this.person_id = person_id;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public String getNgaylp() {
        return ngaylp;
    }

    public void setNgaylp(String ngaylp) {
        this.ngaylp = ngaylp;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }
}
