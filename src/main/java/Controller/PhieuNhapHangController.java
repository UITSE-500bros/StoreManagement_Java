package Controller;

import Models.phieunhaphang;
import Repository.PhieuNhapHangRepository;

import java.io.IOException;

public class PhieuNhapHangController {
    static PhieuNhapHangRepository phieuNhapHangRepository;
    public PhieuNhapHangController() {
        phieuNhapHangRepository = new PhieuNhapHangRepository();
    }

    public void createPhieuNhapHang(phieunhaphang phieuNhapHang) throws IOException {
        phieuNhapHangRepository.createPhieuNhapHang(phieuNhapHang);
    }
}
