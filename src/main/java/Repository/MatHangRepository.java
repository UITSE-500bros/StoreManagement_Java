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
        int sl = 0;
        openGetConnection("matHang/getSLTonKho/" + maMH);
        response = "";
        if (response.contains("201")) {
            BufferedReader in = new BufferedReader(new InputStreamReader(getCon().getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            closeConnection();
            return Integer.parseInt(content.toString()); // Convert the response body to int
        } else {
            closeConnection();
            throw new IOException("Failed to create phieuxuathang. HTTP response code: " + response);
        }
    }
}
