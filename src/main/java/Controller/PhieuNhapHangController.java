package Controller;

import Models.ctnh;
import Models.phieunhaphang;
import Repository.PhieuNhapHangRepository;

import java.io.IOException;
import java.util.List;

public class PhieuNhapHangController {
    static PhieuNhapHangRepository phieuNhapHangRepository;
    public PhieuNhapHangController() {
        phieuNhapHangRepository = new PhieuNhapHangRepository();
    }
    int mapnhap;
    public int createPhieuNhapHang(phieunhaphang phieuNhapHang) throws IOException {
        mapnhap = phieuNhapHangRepository.createPhieuNhapHang(phieuNhapHang);
        return mapnhap;
    }

    public String addCTNH(List<ctnh> ctnhList) {
        for(ctnh ctnh : ctnhList) {
            ctnh.setMapnhap(new phieunhaphang(mapnhap));
        }
        return phieuNhapHangRepository.createCTNH(ctnhList);
    }
}
