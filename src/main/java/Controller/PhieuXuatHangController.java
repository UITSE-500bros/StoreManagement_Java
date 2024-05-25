package Controller;

import Models.ctxh;
import Models.mathang;
import Models.phieunhaphang;
import Models.phieuxuathang;
import Repository.MatHangRepository;
import Repository.PhieuXuatHangRepository;
import Repository.DaiLyRepository;

import java.io.IOException;
import java.util.List;

public class PhieuXuatHangController {
    static PhieuXuatHangRepository phieuXuatHangRepository;
    static MatHangRepository matHangRepository;
    private DaiLyRepository dailyRepository;

    public PhieuXuatHangController() {
        phieuXuatHangRepository = new PhieuXuatHangRepository();
        matHangRepository = new MatHangRepository();
        dailyRepository = new DaiLyRepository();
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

    public  Boolean checkSLT(int soluong, String tenmh) throws IOException{

        MatHangController matHangController = new MatHangController();
        int slton = matHangController.getSLT(tenmh);
        if(slton < soluong){
            return false;
        }
        return true;
    }
    
    public  Boolean checkTienNo(int tienConLai,int madaily) throws IOException{
        int tienno = dailyRepository.getSoNoDuocNoThem(madaily);
        if(tienno < tienConLai){
            return false;
        }
        return true;
    }
}
