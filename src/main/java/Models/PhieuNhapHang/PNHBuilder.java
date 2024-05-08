package Models.PhieuNhapHang;

public interface PNHBuilder {
    public PNHBuilder setMaPhieuNhap(int maPhieuNhap);
    public PNHBuilder setNgayNhap(String ngayNhap);
    public PNHBuilder setTongTien(int tongTien);
    public PhieuNhapHang build();
}
