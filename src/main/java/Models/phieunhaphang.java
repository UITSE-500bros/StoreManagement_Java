package Models;

public class phieunhaphang {

    private int mapnhap;
    private String ngaylp;
    private int tongtien;
    private int person_id;

    public phieunhaphang() {
        
    }

    public phieunhaphang(int maphieunhap) {
        this.mapnhap = maphieunhap;
    }
    public phieunhaphang(String ngaynhap, int tongtien) {
        this.ngaylp = ngaynhap;
        this.tongtien = tongtien;
    }
    public int getMaphieunhap() {
        return mapnhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.mapnhap = maphieunhap;
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
