package Controller;

import Models.ctxh;
import Models.phieunhaphang;
import Models.phieuxuathang;
import Repository.PhieuXuatHangRepository;

import java.io.IOException;
import java.util.List;

public class PhieuXuatHangController {
    static PhieuXuatHangRepository phieuXuatHangRepository;
    public PhieuXuatHangController() {
        phieuXuatHangRepository = new PhieuXuatHangRepository();
    }
    int mapxuat;
    public void createPhieuXuatHang(phieuxuathang phieuXuatHang) throws IOException {
        mapxuat = phieuXuatHangRepository.createPhieuXuatHang(phieuXuatHang);

    }
    public String addCTXH(List<ctxh> ctxhList) {
        for(ctxh ctxh : ctxhList) {
            ctxh.setMapxuat(new phieuxuathang(mapxuat));
        }
        return phieuXuatHangRepository.createCTXH(ctxhList);
    }
}
