package Models;

public class baocaodoanhso {
    private int mabaocaods;
    private int thang;
    private int nam;
    private int tongdoanhthu;


    public baocaodoanhso() {

    }

    public baocaodoanhso(int maBaoCaoDoanhSo, int thang, int nam, int tongDoanhSo) {
        this.mabaocaods = maBaoCaoDoanhSo;
        this.thang = thang;
        this.nam = nam;
        this.tongdoanhthu = tongDoanhSo;
    }
    public int getMabaocaods() {
            return mabaocaods;
        }

    public void setMabaocaods(int mabaocaods) {
        this.mabaocaods = mabaocaods;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getTongdoanhthu() {
        return tongdoanhthu;
    }

    public void setTongdoanhthu(int tongdoanhthu) {
        this.tongdoanhthu = tongdoanhthu;
    }
}
