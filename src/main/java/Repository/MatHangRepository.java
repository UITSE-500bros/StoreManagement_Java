package Repository;

import Models.mathang;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

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
