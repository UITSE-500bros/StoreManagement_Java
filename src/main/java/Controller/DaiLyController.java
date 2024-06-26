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
import java.util.ArrayList;
import java.util.List;

public class DaiLyController {
    private final DaiLyRepository connection;
    private List<daily> dailyList;
    public DaiLyController() {
        connection = new DaiLyRepository();
        dailyList = new ArrayList<>();
    }
    public List<daily> showDaiLy() throws IOException {
        String link = "daily/getAllDaiLy";
        connection.openGetConnection(link);
        dailyList = connection.getAllDaiLy();
         return dailyList;
    }
    public daily addNewDaiLy(daily daily, quan quan, loaidaily loaidaily) throws IOException {
        return connection.insertDaiLy(daily);
    }

    public int getSoNoDuocNoThem(int madaily) {
        return connection.getSoNoDuocNoThem(madaily);
    }
}
