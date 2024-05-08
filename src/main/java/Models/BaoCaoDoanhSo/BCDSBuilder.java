package Models.BaoCaoDoanhSo;

public interface BCDSBuilder {
    BCDSBuilder setMaBaoCaoDoanhSo(String maBaoCaoDoanhSo);
    BCDSBuilder setThang(String thang);
    BCDSBuilder setNam(String nam);
    BCDSBuilder setMaDaiLy(String maDaiLy);
    BCDSBuilder setTongDoanhSo(String tongDoanhSo);
    BCDSBuilder setTyLe(String tyLe);
    BaoCaoDoanhSo build();
}
