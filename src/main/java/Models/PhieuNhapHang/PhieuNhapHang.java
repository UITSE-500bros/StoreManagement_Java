package Models.PhieuNhapHang;

public class PhieuNhapHang {
    private int maPhieuNhap;
    private String ngayNhap;
    private int tongTien;

    public PhieuNhapHang() {
        
    }

    public PhieuNhapHang(int maPhieuNhap, String ngayNhap, int tongTien) {
        this.maPhieuNhap = maPhieuNhap;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }
}
