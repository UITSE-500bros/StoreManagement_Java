package Controller;

import Models.quan;
import Repository.Connection;
import Repository.QuanRepository;

import java.io.IOException;
import java.util.List;

public class QuanController {
    private final QuanRepository connection ;
    public QuanController() {
        connection= new QuanRepository();
    }

    public String addQuan(quan quan) {
        return connection.insertQuan(quan);
    }

    public List<quan> showQuan() throws IOException {
        connection.openGetConnection("quan/allQuan");
        return connection.getAllQuan();
    }
}
