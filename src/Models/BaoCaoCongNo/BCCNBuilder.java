package Models.BaoCaoCongNo;

public interface BCCNBuilder {
    BCCNBuilder setMaBaoCaoCongNo(String maBaoCaoCongNo);
    BCCNBuilder setThang(String thang);
    BCCNBuilder setNam(String nam);
    BCCNBuilder setMaDaiLy(String maDaiLy);
    BCCNBuilder setNoDau(String noDau);
    BCCNBuilder setNoCuoi(String noCuoi);
    BCCNBuilder setPhatSinh(String phatSinh);
    BaoCaoCongNo build();
}
