package Repository;

import Models.daily;
import Models.quan;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.List;

public class QuanRepository extends Connection {
    public QuanRepository() {
        super();
    }

    public String insertQuan(quan quan){
        gson = new Gson();
        String json = gson.toJson(quan);
        openPostConnection("quan/addQuan");
        response = "";
        writeObject(json);
        closeConnection();
        return response;
    }
    public List<quan> getAllQuan() throws IOException {
        Gson gson = new Gson();

        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type listType = new TypeToken<List<quan>>(){}.getType();
        List<quan> quans = gson.fromJson(reader, listType);
        con.disconnect();
        return quans;
    }
}
