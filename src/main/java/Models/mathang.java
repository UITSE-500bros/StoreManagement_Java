package Models;

public class mathang {

    private int mamh;

    private String tenmh;

    private dvt dvt;


    private int dongianhap;

    private double dongiaxuat;

    private int slton;
    public mathang(int mamh) {
        this.mamh = mamh;
    }

    public mathang(int mamh, String tenmh, dvt madvt, int dongianhap, double dongiaxuat, int slton) {
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.dvt = madvt;
        this.dongianhap = dongianhap;
        this.dongiaxuat = dongiaxuat;
        this.slton = slton;
    }

    public mathang() {
    }

    public mathang(String tenmh, dvt madvt, int dongianhap, double dongiaxuat, int slton) {

        this.tenmh = tenmh;
        this.dvt = madvt;
        this.dongianhap = dongianhap;
        this.dongiaxuat = dongiaxuat;
        this.slton = slton;
    }

    public String getTenmh() {
        return tenmh;
    }

    public int getMamh() {
        return mamh;
    }

    public int getDongianhap() {
        return dongianhap;
    }

	public int getSoLuong() {
		return slton;
	}

	public dvt getDvt() {
		return dvt;
	}

    public int getDongiaxuat() {
        return (int) dongiaxuat;
    }


}