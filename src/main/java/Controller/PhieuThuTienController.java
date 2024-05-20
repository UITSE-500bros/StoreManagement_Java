package Controller;

import Models.phieuthutien;
import Repository.PhieuThuTienRepository;

public class PhieuThuTienController {
    final PhieuThuTienRepository phieuThuTienRepository;

    public PhieuThuTienController(PhieuThuTienRepository phieuThuTienRepository) {
        this.phieuThuTienRepository = phieuThuTienRepository;
    }

    public void createPhieuThuTien(phieuthutien phieuThuTien) {
        phieuThuTienRepository.insertPhieuThuTien(phieuThuTien);
    }
}
