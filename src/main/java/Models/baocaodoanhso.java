package Models;

public class baocaodoanhso {
    private String maBaoCaoDoanhSo;
    private String thang;
    private String nam;
    private String maDaiLy;
    private String tongDoanhSo;
    private Double tyLe;

    public baocaodoanhso() {

    }

    public baocaodoanhso(String maBaoCaoDoanhSo, String thang, String nam, String maDaiLy, String tongDoanhSo, Double tyLe) {
        this.maBaoCaoDoanhSo = maBaoCaoDoanhSo;
        this.thang = thang;
        this.nam = nam;
        this.maDaiLy = maDaiLy;
        this.tongDoanhSo = tongDoanhSo;
        this.tyLe = tyLe;

    }

    public String getMaBaoCaoDoanhSo() {
        return maBaoCaoDoanhSo;
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

    public String getTongDoanhSo() {
        return tongDoanhSo;
    }

    public Double getTyLe() {
        return tyLe;
    }
}
