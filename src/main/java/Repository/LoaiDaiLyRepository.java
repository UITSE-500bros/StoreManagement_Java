package Repository;

import Models.loaidaily;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.List;

public class LoaiDaiLyRepository extends Connection{
    public LoaiDaiLyRepository() {
        super();
    }

    public String insertLoaiDaiLy(loaidaily loaiDaiLy) {
        gson = new Gson();
        String json = gson.toJson(loaiDaiLy);

        openPostConnection("https://still-cliffs-55450-6c9d6b2dff57.herokuapp.com/loaidaily/addLoaiDaiLy");
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

    public List<loaidaily> getALlLoaiDaiLy() throws IOException {
        // Read from the input stream before disconnecting
        Gson gson = new Gson();
        List<loaidaily> loaidailies = gson.fromJson(getCon().getInputStream().toString(), List.class);
        getCon().disconnect();
        return loaidailies;
    }
}
