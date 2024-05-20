package Models;

public class phieuthutien {

    private int maphieuthu;
    private String ngaythutien;
    private int tienthu;
    private daily madaily;

    public phieuthutien() {
    }

    public phieuthutien(int maphieuthu, String ngaythutien, int tienthu, daily madaily) {
        this.maphieuthu = maphieuthu;
        this.ngaythutien = ngaythutien;
        this.tienthu = tienthu;
        this.madaily = madaily;
    }

    public int getMaphieuthu() {
        return maphieuthu;
    }

    public void setMaphieuthu(int maphieuthu) {
        this.maphieuthu = maphieuthu;
    }

    public String getNgaythutien() {
        return ngaythutien;
    }

    public void setNgaythutien(String ngaythutien) {
        this.ngaythutien = ngaythutien;
    }

    public int getTienthu() {
        return tienthu;
    }

    public void setTienthu(int tienthu) {
        this.tienthu = tienthu;
    }

    public daily getMadaily() {
        return madaily;
    }

    public void setMadaily(daily madaily) {
        this.madaily = madaily;
    }
}
