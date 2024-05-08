package Models.PhieuThuTien;

public class PhieuThuTien {
    private int maPhieuThu;
    private String ngayThuTien;
    private int soTienThu;
    private int maDaiLy;

    public PhieuThuTien() {
    }
    public PhieuThuTien(int maPhieuThu, String ngayThuTien, int soTienThu, int maDaiLy) {
        this.maPhieuThu = maPhieuThu;
        this.ngayThuTien = ngayThuTien;
        this.soTienThu = soTienThu;
        this.maDaiLy = maDaiLy;
    }
}
