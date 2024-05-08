package Models.BaoCaoCongNo;

public class BaoCaoCongNo {
    private String maBaoCaoCongNo;
    private String thang;
    private String nam;
    private String maDaiLy;
    private String noDau;
    private String noCuoi;
    private String phatSinh;


    public BaoCaoCongNo() {

    }

    public BaoCaoCongNo(String maBaoCaoCongNo, String thang, String nam, String maDaiLy, String noDau, String noCuoi, String phatSinh) {
        this.maBaoCaoCongNo = maBaoCaoCongNo;
        this.thang = thang;
        this.nam = nam;
        this.maDaiLy = maDaiLy;
        this.noDau = noDau;
        this.noCuoi = noCuoi;
        this.phatSinh = phatSinh;

    }

    public String getMaBaoCaoCongNo() {
        return maBaoCaoCongNo;
    }

    public String getThang() {
        return thang;
    }

    public String getNam() {
        return nam;
    }

    public String getMaDaiLy() {
        return maDaiLy;
    }

    public String getNoDau() {
        return noDau;
    }

    public String getNoCuoi() {
        return noCuoi;
    }

    public String getPhatSinh() {
        return phatSinh;
    }


}
