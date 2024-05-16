package Controller;

import Models.daily;
import Models.loaidaily;
import Models.quan;
import Repository.Connection;
import Repository.DaiLyRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class DaiLyController {
    private final DaiLyRepository connection;

    public DaiLyController() {

        connection = new DaiLyRepository();
    }

    public List<daily> showDaiLy() throws IOException {
        connection.setUrl(new URL("http://localhost:8080/daily/getAllDaiLy"));
        connection.openGetConnection();
        connection.getCon().setRequestProperty("Content-Type", "application/json");
        connection.getCon().setRequestProperty("Accept", "application/json");
        connection.getCon().setRequestMethod("GET");
        connection.getCon().setDoOutput(true);
        connection.getCon().setDoInput(true);
        connection.getCon().connect();

        // Read from the input stream before disconnecting
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(connection.getCon().getInputStream()));
        Type listType = new TypeToken<List<daily>>(){}.getType();
        List<daily> dailies = gson.fromJson(reader, listType);
        connection.getCon().disconnect();
        return dailies;
    }

    public String addNewDaiLy(daily daily, quan quan, loaidaily loaidaily){
        connection.insertDaiLy(daily);
        return "DaiLy added successfully";
    }
}
