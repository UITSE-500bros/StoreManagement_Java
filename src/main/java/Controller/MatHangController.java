package Controller;

import Models.mathang;
import Repository.Connection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class MatHangController {
    private final Connection connection;
    private final String url = "http://localhost:8080/mathang/getAllMatHang";

    public MatHangController() {
        this.connection = new Connection();
    }

    public List<mathang> showMatHang() throws IOException {

        connection.setUrl(new URL(url));
        connection.openGetConnection();
        connection.getCon().setRequestProperty("Content-Type", "application/json");
        connection.getCon().setRequestProperty("Accept", "application/json");

        connection.getCon().connect();


        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(connection.getCon().getInputStream()));
        Type listType = new TypeToken<List<mathang>>(){}.getType();
        List<mathang> mathang = gson.fromJson(reader, listType);
        connection.getCon().disconnect();
        return mathang;
    }

    public String addNewMatHang(){
        mathang mathang = new mathang();
//        mathang.setMathangname("test");
//        mathang.setMathanggia(1000);
//        mathang.setMathangsoluong(10);
//        mathang.setMathangmota("test");

        //connection.insertMatHang(mathang);
        return "MatHang added successfully";
    }

}
