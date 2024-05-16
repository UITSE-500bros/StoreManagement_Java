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

        openPostConnection("http://localhost:8080/matHang/addMatHang");

        String response = "";
        try {
            // Send post request
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(json);
            osw.flush();
            osw.close();
            os.close();

            // Get the response code
            response = String.valueOf(con.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeConnection();

        return response;
    }
}
