package Repository;

import Models.phieuthutien;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class PhieuThuTienRepository extends Connection{
    public PhieuThuTienRepository() {
        super();
    }

    public String insertPhieuThuTien(phieuthutien phieuThuTien) {
        gson = new Gson();
        String json = gson.toJson(phieuThuTien);

        openPostConnection("https://still-cliffs-55450-6c9d6b2dff57.herokuapp.com/phieuthutien/addPhieuThuTien");

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
