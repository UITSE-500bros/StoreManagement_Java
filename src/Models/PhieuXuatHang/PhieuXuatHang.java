package Models.PhieuXuatHang;

public class PhieuXuatHang {
    private int maPhieuXuat;
    private String ngayXuat;
    private int maDaiLy;
    private int tongTien;
    private int soTienTra;
    private int conLai;

    public PhieuXuatHang() {
        
    }
    public PhieuXuatHang(int maPhieuXuat, String ngayXuat, int maDaiLy, int tongTien, int soTienTra, int conLai) {
        this.maPhieuXuat = maPhieuXuat;
        this.ngayXuat = ngayXuat;
        this.maDaiLy = maDaiLy;
        this.tongTien = tongTien;
        this.soTienTra = soTienTra;
        this.conLai = conLai;
    }
}
