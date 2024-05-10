package Models;

public class phieuthutien {

    private int maphieuthu;
    private String ngaythutien;
    private int tienthu;
    private int madaily;

    public phieuthutien() {
    }

    public phieuthutien(int maphieuthu, String ngaythutien, int tienthu, int madaily) {
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

    public int getMadaily() {
        return madaily;
    }

    public void setMadaily(int madaily) {
        this.madaily = madaily;
    }
}
