package Models.PhieuXuatHang;

public interface PXHBuilder {
    public PXHBuilder setMaPhieuXuat(int maPhieuXuat);
    public PXHBuilder setNgayXuat(String ngayXuat);
    public PXHBuilder setMaDaiLy(int maDaiLy);
    public PXHBuilder setTongTien(int tongTien);
    public PXHBuilder setSoTienTra(int soTienTra);
    public PXHBuilder setConLai(int conLai);
    public PhieuXuatHang build();
}
