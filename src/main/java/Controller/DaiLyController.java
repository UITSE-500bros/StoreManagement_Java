package Controller;


import Models.daily;
import UI.MainFrame;

import UI.*;

import java.io.IOException;


public class DaiLyController {
    private daily daiLy;
    private MainFrame mainFrame;
    private login login;
    private Connection connection;

    public DaiLyController(login login) {
        this.login = login;

        connection = new Connection();
    }

    public void showDaiLy(int personid) throws IOException {
//        //String encodedEmail = URLEncoder.encode(String, StandardCharsets.UTF_8);
//        connection.setUrl(new URL("http://localhost:8080/daily/getAllDaiLyByPersonId?person_id=" + personid));
//        connection.openGetConnection();
//
//        //int status = connection.con.getResponseCode();
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(connection.con.getInputStream()));
//        String inputLine;
//        StringBuilder content = new StringBuilder();
//        while ((inputLine = in.readLine()) != null) {
//            content.append(inputLine);
//        }
//        // close connections
//        in.close();
//        connection.closeConnection();
//
//        // convert json to object
//        Gson gson = new Gson();
//        Type listType = new TypeToken<List<DaiLy>>(){}.getType();
//        List<DaiLy> dailyList = gson.fromJson(content.toString(), listType);
//        for (DaiLy daily : dailyList){
//            System.out.println(daily.toString());
//        }

    }
}
