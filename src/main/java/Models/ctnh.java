package Models;

import java.io.Serializable;

public class ctnh {

    private phieunhaphang mapnhap;


    private mathang mamh;

    private int slnhap;


    private int dongianhap;

    private int thanhtien;

    private int dvt;

    public ctnh() {
    }
    public ctnh(phieunhaphang mapnhap) {
        this.mapnhap = mapnhap;
    }

    public ctnh(mathang mamh, int slnhap) {
        this.mamh = mamh;
        this.slnhap = slnhap;
    }

    public phieunhaphang getMapnhap() {
        return mapnhap;
    }

    public void setMapnhap(phieunhaphang mapnhap) {
        this.mapnhap = mapnhap;
    }

    public mathang getMamh() {
        return mamh;
    }

    public void setMamh(mathang mamh) {
        this.mamh = mamh;
    }

    public int getSlnhap() {
        return slnhap;
    }

    public void setSlnhap(int slnhap) {
        this.slnhap = slnhap;
    }

    public int getDongianhap() {
        return this.mamh.getDongianhap();
    }
    public void setDongianhap(int dongianhap) {
        this.dongianhap = dongianhap;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getDvt() {
        return dvt;
    }

    public void setDvt(int dvt) {
        this.dvt = dvt;
    }

}