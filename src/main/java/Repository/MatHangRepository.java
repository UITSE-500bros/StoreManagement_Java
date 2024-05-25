package Repository;

import Models.mathang;
import com.google.gson.Gson;

import java.io.*;

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

    public int getSLTonKho(String maMH) throws IOException {

        openGetConnection("matHang/getSLTonKho/" + maMH);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = in.readLine(); // Read the response
        in.close();
        return Integer.parseInt(response); // Convert the response to an integer

    }
}
