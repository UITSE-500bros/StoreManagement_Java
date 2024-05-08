package Models.PhieuNhapHang;

public class PNHConcreteBuilder implements PNHBuilder{
    private int maPhieuNhap;
    private String ngayNhap;
    private int tongTien;
    @Override
    public PNHConcreteBuilder setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
        return this;
    }
    @Override
    public PNHConcreteBuilder setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
        return this;
    }

    @Override
    public PNHConcreteBuilder setTongTien(int tongTien) {
        this.tongTien = tongTien;
        return this;
    }

    @Override
    public PhieuNhapHang build() {
        return new PhieuNhapHang(maPhieuNhap, ngayNhap, tongTien);
    }
}
