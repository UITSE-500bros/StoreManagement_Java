package Repository;

import Models.daily;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.List;
import java.io.*;
public class DaiLyRepository extends Connection{

    public DaiLyRepository() {
        super();
    }

    public String insertDaiLy(daily daily) {
        gson = new Gson();
        String json = gson.toJson(daily);
        openPostConnection("daily/addDaiLy");
        response = "";
        writeObject(json);
        closeConnection();
        return response;
    }
    public List<daily> getAllDaiLy() throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type listType = new TypeToken<List<daily>>(){}.getType();
        List<daily> dailies = gson.fromJson(reader, listType);
        con.disconnect();
        return dailies;
    }
    
    public int getSoNoDuocNoThem(int madaily) throws IOException {

        openGetConnection("daily/getSoNoDuocNoThem/" + madaily);
        response = "";
        if (response.contains("201")) {
            BufferedReader in = new BufferedReader(new InputStreamReader(getCon().getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            closeConnection();
            return Integer.parseInt(content.toString()); // Convert the response body to int
        } else {
            closeConnection();

            throw new IOException("Failed to create phieuxuathang. HTTP response code: " + response);
        }

    }
}
