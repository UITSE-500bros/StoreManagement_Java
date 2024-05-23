package Models;


import java.sql.Date;

public class phieuxuathang {

    private int mapxuat;

    private Date ngaylp;
    private daily madaily;
    private int tongtien;
    private int sotientra;
    private int conlai;

    public phieuxuathang() {
        
    }

    public phieuxuathang(int mapxuat) {
        this.mapxuat = mapxuat;
    }

    public phieuxuathang(Date ngaylp, daily madaily, int tongtien, int sotientra, int conlai) {
        this.ngaylp = ngaylp;
        this.madaily = madaily;
        this.tongtien = tongtien;
        this.sotientra = sotientra;
        this.conlai = conlai;
    }

    public int getMapxuat() {
        return mapxuat;
    }

    public void setMapxuat(int mapxuat) {
        this.mapxuat = mapxuat;
    }

    public Date getNgaylp() {
        return ngaylp;
    }

    public void setNgaylp(Date ngaylp) {
        this.ngaylp = ngaylp;
    }

    public daily getMadaily() {
        return madaily;
    }

    public void setMadaily(daily madaily) {
        this.madaily = madaily;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getSotientra() {
        return sotientra;
    }

    public void setSotientra(int sotientra) {
        this.sotientra = sotientra;
    }

    public int getConlai() {
        return conlai;
    }

    public void setConlai(int conlai) {
        this.conlai = conlai;
    }
}
