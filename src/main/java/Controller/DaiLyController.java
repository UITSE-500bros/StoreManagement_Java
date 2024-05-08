package Controller;

import Models.DaiLyModel.DaiLy;
import UI.MainFrame;
import com.google.gson.Gson;
import UI.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class DaiLyController {
    private DaiLy daiLy;
    private MainFrame mainFrame;
    private login login;
    private Connection connection;

    public DaiLyController(login login) {
        this.login = login;

        connection = new Connection();
    }

    public void showDaiLy(int personid) throws IOException {
        //String encodedEmail = URLEncoder.encode(String, StandardCharsets.UTF_8);
        connection.setUrl(new URL("http://localhost:8080/daily/getAllDaiLyByPersonId?person_id=" + personid));
        connection.openGetConnection();

        //int status = connection.con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        // close connections
        in.close();
        connection.closeConnection();

        // convert json to object
        Gson gson = new Gson();
        Type listType = new TypeToken<List<DaiLy>>(){}.getType();
        List<DaiLy> dailyList = gson.fromJson(content.toString(), listType);
        for (DaiLy daily : dailyList){
            System.out.println(daily.toString());
        }

    }
}
