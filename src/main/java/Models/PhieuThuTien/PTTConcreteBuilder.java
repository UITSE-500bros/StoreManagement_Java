package Models.PhieuThuTien;

public class PTTConcreteBuilder implements PTTBuilder{
    private int maPhieuThu;
    private String ngayThuTien;
    private int soTienThu;
    private int maDaiLy;
    @Override
    public PTTBuilder setMaPhieuThu(int maPhieuThu) {
        this.maPhieuThu = maPhieuThu;
        return this;
    }
    @Override
    public PTTBuilder setNgayThuTien(String ngayThuTien) {
        this.ngayThuTien = ngayThuTien;
        return this;
    }
    @Override
    public PTTBuilder setSoTienThu(int soTienThu) {
        this.soTienThu = soTienThu;
        return this;
    }
    @Override
    public PTTBuilder setMaDaiLy(int maDaiLy) {
        this.maDaiLy = maDaiLy;
        return this;
    }
    @Override
    public PhieuThuTien build() {
        return new PhieuThuTien(maPhieuThu, ngayThuTien, soTienThu, maDaiLy);
    }
}
