package Repository;

import Models.daily;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
public class DaiLyRepository extends Connection{

    public DaiLyRepository() {
        super();
    }

    public daily insertDaiLy(daily daily) throws IOException {
        gson = new Gson();
        String json = gson.toJson(daily);
        openPostConnection("daily/addDaiLy");
        response = "";
        writeObject(json);
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type listType = new TypeToken<daily>(){}.getType();
        daily dailies = gson.fromJson(reader, listType);
        closeConnection();
        return dailies;
    }
    public List<daily> getAllDaiLy() throws IOException {
        gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type listType = new TypeToken<List<daily>>(){}.getType();
        List<daily> dailies = gson.fromJson(reader, listType);
        con.disconnect();
        return dailies;
    }

    public int getSoNoDuocNoThem(int madaily) {
        gson = new Gson();
        openGetConnection("daily/max_debt?madaily=" + madaily);
        try {
            JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
            Type listType = new TypeToken<Integer>(){}.getType();
            int tienno = gson.fromJson(reader, listType);
            con.disconnect();
            return tienno;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
