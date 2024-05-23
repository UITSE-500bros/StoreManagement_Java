package Repository;

import Models.loaidaily;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class LoaiDaiLyRepository extends Connection{
    public LoaiDaiLyRepository() {
        super();
    }

    public String insertLoaiDaiLy(loaidaily loaiDaiLy) {
        gson = new Gson();
        String json = gson.toJson(loaiDaiLy);
        openPostConnection("loaidaily/addLoaiDaiLy");
        response = "";
        writeObject(json);
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
