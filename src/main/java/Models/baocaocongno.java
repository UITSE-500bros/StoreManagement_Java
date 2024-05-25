package Models;

public class baocaocongno {

    private baocaocongnoID baocaocongnoID;

    private int noDau;
    private int noCuoi;
    private int phatSinh;


    public baocaocongno() {

    }

    public baocaocongno(baocaocongnoID baocaocongnoID, int noDau, int noCuoi, int phatSinh) {
        this.baocaocongnoID = baocaocongnoID;
        this.noDau = noDau;
        this.noCuoi = noCuoi;
        this.phatSinh = phatSinh;
    }

    public baocaocongnoID getBaocaocongnoID() {
        return baocaocongnoID;
    }

    public void setBaocaocongnoID(baocaocongnoID baocaocongnoID) {
        this.baocaocongnoID = baocaocongnoID;
    }

    public void setNoDau(int noDau) {
        this.noDau = noDau;
    }

    public void setNoCuoi(int noCuoi) {
        this.noCuoi = noCuoi;
    }

    public void setPhatSinh(int phatSinh) {
        this.phatSinh = phatSinh;
    }

    public int getNoCuoi() {
        return noCuoi;
    }

    public int getNoDau() {
        return noDau;
    }

    public int getPhatSinh() {
        return phatSinh;
    }


}
