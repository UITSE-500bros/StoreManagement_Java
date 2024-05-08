package Models.PhieuThuTien;

public interface PTTBuilder {
    PTTBuilder setMaPhieuThu(int maPhieuThu);
    PTTBuilder setNgayThuTien(String ngayThuTien);
    PTTBuilder setSoTienThu(int soTienThu);
    PTTBuilder setMaDaiLy(int maDaiLy);
    PhieuThuTien build();
}
