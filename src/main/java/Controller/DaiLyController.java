package Controller;

import Models.daily;
import Models.loaidaily;
import Models.person;
import Models.quan;
import UI.MainFrame;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class DaiLyController {
    private final MainFrame mainFrame;
    private final Connection connection;

    public DaiLyController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        connection = new Connection();
    }

    public List<daily> showDaiLy(int personid) throws IOException {
        connection.setUrl(new URL("http://localhost:8080/daily/getAllDaiLyByPersonId?person_id=" + personid));
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

    public String addNewDaiLy(daily daily, quan quan, loaidaily loaidaily, person person){
        connection.insertDaiLy(daily);
        return "DaiLy added successfully";
    }
}
