package Models;


public class phieuxuathang {

    private int mapxuat;

    private String ngaylp;
    private daily madaily;
    private int tongtien;
    private int sotientra;
    private int conlai;

    public phieuxuathang() {
        
    }

    public phieuxuathang(int mapxuat) {
        this.mapxuat = mapxuat;
    }

    public phieuxuathang(String ngaylp, daily madaily, int tongtien, int sotientra, int conlai) {
        this.ngaylp = ngaylp;
        this.madaily = madaily;
        this.tongtien = tongtien;
        this.sotientra = sotientra;
        this.conlai = conlai;
    }
}
