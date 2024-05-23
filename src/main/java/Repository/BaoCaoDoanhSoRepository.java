package Repository;

public class BaoCaoDoanhSoRepository extends Connection
{
    public BaoCaoDoanhSoRepository() {
        super();
    }

    public void getBaoCaoDoanhSo(int thang, int nam) {
        super.openGetConnection("baocaodoanhso/bcdsbythangandnam?thang=" + thang + "&nam=" + nam);

    }
}
