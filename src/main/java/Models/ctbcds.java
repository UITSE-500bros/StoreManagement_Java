package Models;
import java.io.Serializable;
public class ctbcds {

    private daily madaily;


    private baocaodoanhso mabaocaods;

    private int sophieuxuat;

    private int tongtrigia;

    private double tyle;

    public ctbcds() {
    }

    public ctbcds(daily madaily, baocaodoanhso mabaocaods, int sophieuxuat, int tongtrigia, double tyle) {
        this.madaily = madaily;
        this.mabaocaods = mabaocaods;
        this.sophieuxuat = sophieuxuat;
        this.tongtrigia = tongtrigia;
        this.tyle = tyle;
    }

    public daily getMadaily() {
        return madaily;
    }

    public void setMadaily(daily madaily) {
        this.madaily = madaily;
    }

    public baocaodoanhso getMabaocaods() {
        return mabaocaods;
    }

    public void setMabaocaods(baocaodoanhso mabaocaods) {
        this.mabaocaods = mabaocaods;
    }

    public int getSophieuxuat() {
        return sophieuxuat;
    }

    public void setSophieuxuat(int sophieuxuat) {
        this.sophieuxuat = sophieuxuat;
    }

    public int getTongtrigia() {
        return tongtrigia;
    }

    public void setTongtrigia(int tongtrigia) {
        this.tongtrigia = tongtrigia;
    }

    public double getTyle() {
        return tyle;
    }

    public void setTyle(double tyle) {
        this.tyle = tyle;
    }

    public static class ctbcdsId implements Serializable {
        private int madaily;
        private int mabaocaods;

        public ctbcdsId() {
        }

        public ctbcdsId(int madaily, int mabaocaods) {
            this.madaily = madaily;
            this.mabaocaods = mabaocaods;
        }

        public int getMadaily() {
            return madaily;
        }

        public void setMadaily(int madaily) {
            this.madaily = madaily;
        }

        public int getMabaocaods() {
            return mabaocaods;
        }

        public void setMabaocaods(int mabaocaods) {
            this.mabaocaods = mabaocaods;
        }
    }
}