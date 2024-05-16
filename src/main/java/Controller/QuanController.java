package Controller;

import Models.quan;
import Repository.Connection;

public class QuanController {
    private final Connection connection ;
    public QuanController() {
        connection= new Connection();
    }
    public void addQuan() {
        quan quan = new quan();
        //quan.setTenQuan("Quan 1");

        //connection.addQuan(quan);

    }
}
