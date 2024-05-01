package Models.BaoCaoDoanhSo;

public class BCDSConcreteBuilder {
    private String maBaoCaoDoanhSo;
    private String thang;
    private String nam;
    private String maDaiLy;
    private String tongDoanhSo;
    private Double tyLe;

    public BCDSConcreteBuilder setMaBaoCaoDoanhSo(String maBaoCaoDoanhSo) {
        this.maBaoCaoDoanhSo = maBaoCaoDoanhSo;
        return this;
    }

    public BCDSConcreteBuilder setThang(String thang) {
        this.thang = thang;
        return this;
    }

    public BCDSConcreteBuilder setNam(String nam) {
        this.nam = nam;
        return this;
    }

    public BCDSConcreteBuilder setMaDaiLy(String maDaiLy) {
        this.maDaiLy = maDaiLy;
        return this;
    }

    public BCDSConcreteBuilder setTongDoanhSo(String tongDoanhSo) {
        this.tongDoanhSo = tongDoanhSo;
        return this;
    }

    public BCDSConcreteBuilder setTyLe(Double tyLe) {
        this.tyLe = tyLe;
        return this;
    }

    public BaoCaoDoanhSo build() {
        return new BaoCaoDoanhSo(maBaoCaoDoanhSo, thang, nam, maDaiLy, tongDoanhSo, tyLe);
    }
}
