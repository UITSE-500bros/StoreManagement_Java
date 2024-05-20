package Models;


import java.io.Serializable;

public class ctxh {

    private phieuxuathang mapxuat;

    private mathang mamh;

    private int slxuat;

    private int dongiaxuat;

    private int thanhtien;


    public ctxh() {
    }

    public ctxh(phieuxuathang mapxuat, mathang mamh, int slxuat, int dongiaxuat, int thanhtien) {
        this.mapxuat = mapxuat;
        this.mamh = mamh;
        this.slxuat = slxuat;
        this.dongiaxuat = dongiaxuat;
        this.thanhtien = thanhtien;
    }

    public phieuxuathang getMapxuat() {
        return mapxuat;
    }

    public void setMapxuat(phieuxuathang mapxuat) {
        this.mapxuat = mapxuat;
    }

    public mathang getMamh() {
        return mamh;
    }

    public void setMamh(mathang mamh) {
        this.mamh = mamh;
    }

    public int getSlxuat() {
        return slxuat;
    }

    public void setSlxuat(int slxuat) {
        this.slxuat = slxuat;
    }

    public int getDongiaxuat() {
        return dongiaxuat;
    }

    public void setDongiaxuat(int dongiaxuat) {
        this.dongiaxuat = dongiaxuat;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public static class CtxhId implements Serializable {
        private int mapxuat;
        private int mamh;

        public CtxhId() {
        }

        public int getMapxuat() {
            return mapxuat;
        }

        public void setMapxuat(int mapxuat) {
            this.mapxuat = mapxuat;
        }

        public int getMamh() {
            return mamh;
        }

        public void setMamh(int mamh) {
            this.mamh = mamh;
        }
    }
}