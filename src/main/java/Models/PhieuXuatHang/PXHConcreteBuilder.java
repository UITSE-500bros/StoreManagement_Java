package Models.PhieuXuatHang;

public class PXHConcreteBuilder implements PXHBuilder{
    private int maPhieuXuat;
    private String ngayXuat;
    private int maDaiLy;
    private int tongTien;
    private int soTienTra;
    private int conLai;

    @Override
    public PXHBuilder setMaPhieuXuat(int maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
        return this;
    }

    @Override
    public PXHBuilder setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
        return this;
    }

    @Override
    public PXHBuilder setMaDaiLy(int maDaiLy) {
        this.maDaiLy = maDaiLy;
        return this;
    }

    @Override
    public PXHBuilder setTongTien(int tongTien) {
        this.tongTien = tongTien;
        return this;
    }

    @Override
    public PXHBuilder setSoTienTra(int soTienTra) {
        this.soTienTra = soTienTra;
        return this;
    }

    @Override
    public PXHBuilder setConLai(int conLai) {
        this.conLai = conLai;
        return this;
    }

    @Override
    public PhieuXuatHang build() {
        return new PhieuXuatHang(maPhieuXuat, ngayXuat, maDaiLy, tongTien, soTienTra, conLai);
    }

}
