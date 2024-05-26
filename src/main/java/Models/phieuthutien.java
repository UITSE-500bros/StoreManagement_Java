package Models;

import java.util.Date;

public class phieuthutien {

    private int maphieuthu;
    private Date ngaythutien;
    private int tienthu;
    private daily madaily;

    public phieuthutien() {
    }

    public phieuthutien(int tienthu, daily madaily) {
        this.tienthu = tienthu;
        this.madaily = madaily;
    }

    public phieuthutien(int maphieuthu, Date ngaythutien, int tienthu, daily madaily) {
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

    public Date getNgaythutien() {
        return ngaythutien;
    }

    public void setNgaythutien(Date ngaythutien) {
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
