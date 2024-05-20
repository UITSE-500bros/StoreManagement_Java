package Repository;

import Models.daily;
import Models.loaidaily;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class LoaiDaiLyRepository extends Connection{
    public LoaiDaiLyRepository() {
        super();
    }

    public String insertLoaiDaiLy(loaidaily loaiDaiLy) {
        gson = new Gson();
        String json = gson.toJson(loaiDaiLy);

        openPostConnection("loaidaily/addLoaiDaiLy");
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
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type listType = new TypeToken<List<loaidaily>>(){}.getType();
        List<loaidaily> loaidailies = gson.fromJson(reader, listType);
        con.disconnect();
        return loaidailies;
    }
}
