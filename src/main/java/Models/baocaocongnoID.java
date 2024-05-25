package Models;


import java.io.Serializable;

public class baocaocongnoID implements Serializable {

    private int thang;

    private int nam;

    private daily madaily;


    public baocaocongnoID() {
    }

    public baocaocongnoID(int thang, int nam, daily madaily) {
        this.thang = thang;
        this.nam = nam;
        this.madaily = madaily;
    }

    public int getThang() {
        return thang;
    }

    public int getNam() {
        return nam;
    }

    public daily getMadaily() {
        return madaily;
    }
}
