package Controller;

import Models.mathang;
import Repository.Connection;
import Repository.MatHangRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class MatHangController {
    private final MatHangRepository connection;
    private final String link = "mathang/all";
    private static List<mathang> mathangList;

    public MatHangController() {
        this.connection = new MatHangRepository();
    }

    public List<mathang> showMatHang() throws IOException {
        connection.openGetConnection(link);
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(connection.getCon().getInputStream()));
        Type listType = new TypeToken<List<mathang>>(){}.getType();
        List<mathang> mathang = gson.fromJson(reader, listType);
        mathangList = mathang;
        connection.getCon().disconnect();
        return mathang;
    }

    public String addNewMatHang(mathang mathang){
        return connection.insertMatHang(mathang);
    }

    public static List<mathang> getMathangList() {
        return mathangList;
    }

    public int getSLT(String tenmh) {
        for (mathang mathang : mathangList) {
            if (mathang.getTenmh().equals(tenmh)) {
                return mathang.getSoLuong();
            }
        }
        return 0;
    }
}
