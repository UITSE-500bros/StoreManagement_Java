package Controller;

import Models.phieuthutien;
import Repository.PhieuThuTienRepository;

public class PhieuThuTienController {
    final PhieuThuTienRepository phieuThuTienRepository;
    public PhieuThuTienController() {
        this.phieuThuTienRepository = new PhieuThuTienRepository();
    }
    public String createPhieuThuTien(phieuthutien phieuThuTien) {
        return phieuThuTienRepository.insertPhieuThuTien(phieuThuTien);
    }
}
