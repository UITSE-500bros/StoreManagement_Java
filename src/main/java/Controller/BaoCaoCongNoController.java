package Controller;

import Models.baocaocongno;
import Models.ctbcds;
import Repository.BaoCaoCongNoRepository;
import Repository.BaoCaoDoanhSoRepository;

import java.io.IOException;
import java.util.List;

public class BaoCaoCongNoController {
    private static BaoCaoCongNoRepository baocaoCongNoRepository;

    public BaoCaoCongNoController() {
        baocaoCongNoRepository = new BaoCaoCongNoRepository();
    }

    public List<baocaocongno> getBaoCaoCongNo(int thang, int nam) throws IOException {
        return baocaoCongNoRepository.getBaoCaoCongNo(thang, nam);
    }
}
