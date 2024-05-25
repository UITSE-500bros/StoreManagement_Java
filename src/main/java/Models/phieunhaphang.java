package Models;

import java.sql.Date;

public class phieunhaphang {

    private int mapnhap;
    private Date ngaylp;
    private int tongtien;
    private int person_id;

    public phieunhaphang() {
        
    }

    public phieunhaphang(int maphieunhap) {
        this.mapnhap = maphieunhap;
    }
    public phieunhaphang(Date ngaynhap, int tongtien) {
        this.ngaylp = ngaynhap;
        this.tongtien = tongtien;
    }
    public int getMaphieunhap() {
        return mapnhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.mapnhap = maphieunhap;
    }

    public Date getNgaylp() {
        return ngaylp;
    }

    public void setNgaylp(Date ngaylp) {
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
