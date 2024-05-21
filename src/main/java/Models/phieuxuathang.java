package Models;


public class phieuxuathang {

    private int mapxuat;

    private String ngayXuat;
    private daily maDaiLy;
    private int tongTien;
    private int soTienTra;
    private int conLai;

    public phieuxuathang() {
        
    }

    public phieuxuathang(int mapxuat) {
        this.mapxuat = mapxuat;
    }

    public phieuxuathang(String ngayXuat, daily maDaiLy, int tongTien, int soTienTra, int conLai) {
        this.ngayXuat = ngayXuat;
        this.maDaiLy = maDaiLy;
        this.tongTien = tongTien;
        this.soTienTra = soTienTra;
        this.conLai = conLai;
    }

    public int getMapxuat() {
        return mapxuat;
    }

    public void setMapxuat(int mapxuat) {
        this.mapxuat = mapxuat;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public daily getMaDaiLy() {
        return maDaiLy;
    }

    public void setMaDaiLy(daily maDaiLy) {
        this.maDaiLy = maDaiLy;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getSoTienTra() {
        return soTienTra;
    }

    public void setSoTienTra(int soTienTra) {
        this.soTienTra = soTienTra;
    }

    public int getConLai() {
        return conLai;
    }

    public void setConLai(int conLai) {
        this.conLai = conLai;
    }
}
