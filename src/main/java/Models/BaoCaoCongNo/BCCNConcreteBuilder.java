package Models.BaoCaoCongNo;

public class BCCNConcreteBuilder {
    private String maBaoCaoCongNo;
    private String thang;
    private String nam;
    private String maDaiLy;
    private String noDau;
    private String noCuoi;
    private String phatSinh;

    public BCCNConcreteBuilder setMaBaoCaoCongNo(String maBaoCaoCongNo) {
        this.maBaoCaoCongNo = maBaoCaoCongNo;
        return this;
    }

    public BCCNConcreteBuilder setThang(String thang) {
        this.thang = thang;
        return this;
    }

    public BCCNConcreteBuilder setNam(String nam) {
        this.nam = nam;
        return this;
    }

    public BCCNConcreteBuilder setMaDaiLy(String maDaiLy) {
        this.maDaiLy = maDaiLy;
        return this;
    }

    public BCCNConcreteBuilder setNoDau(String noDau) {
        this.noDau = noDau;
        return this;
    }

    public BCCNConcreteBuilder setNoCuoi(String noCuoi) {
        this.noCuoi = noCuoi;
        return this;
    }

    public BCCNConcreteBuilder setPhatSinh(String phatSinh) {
        this.phatSinh = phatSinh;
        return this;
    }

    public BaoCaoCongNo build() {
        return new BaoCaoCongNo(maBaoCaoCongNo, thang, nam, maDaiLy, noDau, noCuoi, phatSinh);
    }
}
