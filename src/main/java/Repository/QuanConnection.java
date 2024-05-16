package Repository;

import Models.quan;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class QuanConnection extends Connection {
    public QuanConnection() {
        super();
    }

    public String insertQuan(quan quan){
        gson = new Gson();
        String json = gson.toJson(quan);
        openPostConnection("http://localhost:8080/quan/addQuan");

        try {
            // Send post request
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(json);
            osw.flush();
            osw.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeConnection();
        return "Quan added successfully";
    }
}
