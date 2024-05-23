package Controller;

import Models.loaidaily;
import Repository.LoaiDaiLyRepository;

import java.io.IOException;
import java.util.List;

public class LoaiDaiLyController {
    private final LoaiDaiLyRepository connection;

    public LoaiDaiLyController() {
        this.connection = new LoaiDaiLyRepository();
    }
    public List<loaidaily> showLoaiDaiLy() throws IOException {
        String link = "loaidaily/loaidaily";
        connection.openGetConnection(link);
        return connection.getALlLoaiDaiLy();
    }

    public String addNewLoaiDaiLy(loaidaily loaidaily){
        return connection.insertLoaiDaiLy(loaidaily);
    }
}
