package Controller;

import Models.dvt;
import Repository.DVTRepository;

import java.io.IOException;
import java.util.List;

public class DVTController {
    final DVTRepository dvtRepository;
    public DVTController() {
        dvtRepository = new DVTRepository();
    }
    public List<dvt> showDVT() throws IOException {
        return dvtRepository.getAll();
    }


}
