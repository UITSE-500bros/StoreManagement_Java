package Controller;

import Models.phieuthutien;
import Repository.PhieuThuTienRepository;

public class PhieuThuTienController {
    final PhieuThuTienRepository phieuThuTienRepository;

    public PhieuThuTienController() {
        this.phieuThuTienRepository = new PhieuThuTienRepository();
    }

    public void createPhieuThuTien(phieuthutien phieuThuTien) {
        phieuThuTienRepository.insertPhieuThuTien(phieuThuTien);
    }

}
