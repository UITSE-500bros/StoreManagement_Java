package Repository;

import Models.mathang;
import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;

public class MatHangRepository extends Connection{

    public MatHangRepository() {
        super();
    }

    public String insertMatHang(mathang mathang){
        gson = new Gson();
        String json = gson.toJson(mathang);

        openPostConnection("matHang/addMatHang");
        response = "";
        writeObject(json);
        closeConnection();
        return response;
    }



}
