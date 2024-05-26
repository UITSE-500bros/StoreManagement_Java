package Controller;

import Models.thamso;
import Repository.ThamSoRepository;

import java.io.IOException;

public class ThamSoController {
    private final ThamSoRepository thamSoRepository;

    public ThamSoController(ThamSoRepository connection) {
        this.thamSoRepository = connection;
    }

    public int updateSoDaiLyToiDa(int newMaximum) {
        thamso thamso = new thamso("Số đại lý tối đa trong một quận", newMaximum);
        if (thamSoRepository.updateThamSo(thamso).contains("200")) {
            return 1;
        } else {
            return -1;
        }
    }

    public int updateTyLeDonGiaXuat(int percentage){
        thamso thamso = new thamso("Tỷ lệ đơn giá xuất", percentage);
        if (thamSoRepository.updateThamSo(thamso).contains("200")) {
            return 1;
        } else {
            return -1;
        }
    }

    public int getSoDaiLyToiDa() throws IOException {

        return thamSoRepository.getThamSoValue();
    }

}
