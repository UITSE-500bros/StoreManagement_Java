package Models;

public class mathang {

    private int mamh;

    private String tenmh;

    private dvt madvt;


    private int dongianhap;

    private double dongiaxuat;

    private int slton;

    public mathang() {
    }

    public mathang(String tenmh, dvt madvt, int dongianhap, double dongiaxuat, int slton) {

        this.tenmh = tenmh;
        this.madvt = madvt;
        this.dongianhap = dongianhap;
        this.dongiaxuat = dongiaxuat;
        this.slton = slton;
    }

    public String getTenmh() {
        return tenmh;
    }

    public int getDongianhap() {
        return dongianhap;
    }
}