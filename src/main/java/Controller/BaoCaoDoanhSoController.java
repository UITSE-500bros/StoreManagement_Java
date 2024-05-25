package Controller;

import Models.ctbcds;
import Repository.BaoCaoDoanhSoRepository;

import java.io.IOException;
import java.util.List;

public class BaoCaoDoanhSoController {
    private static BaoCaoDoanhSoRepository baoCaoDoanhSoRepository;

    public BaoCaoDoanhSoController() {
        baoCaoDoanhSoRepository = new BaoCaoDoanhSoRepository();
    }

    public List<ctbcds> getBaoCaoDoanhSo(int thang, int nam) throws IOException {
        return baoCaoDoanhSoRepository.getBaoCaoDoanhSo(thang, nam);
    }
}
