package Controller;

import Models.thamso;
import Repository.ThamSoRepository;

import java.io.IOException;

public class ThamSoController {
    private final ThamSoRepository thamSoRepository;

    public ThamSoController() {
        this.thamSoRepository = new ThamSoRepository();
    }

    public int updateSoDaiLyToiDa(int newMaximum) throws IOException {
        thamso thamso = new thamso("Số đại lý tối đa trong một quận", newMaximum);
        if (thamSoRepository.updateThamSo(thamso).contains("200")) {
            return 1;
        } else {
            return -1;
        }
    }

    public int updateTyLeDonGiaXuat(int percentage) throws IOException {
        thamso thamso = new thamso("Tỷ lệ đơn giá xuất", percentage);
        if (thamSoRepository.updateThamSo(thamso).contains("200")) {
            return 1;
        } else {
            return -1;
        }

    }

    public int getTLDGX() throws IOException {
        thamso thamso = thamSoRepository.getThamSo("Tỷ lệ đơn giá xuất");
        if (thamso != null) {
            return thamso.getGiatri();
        } else {
            return -1;
        }
    }
}
