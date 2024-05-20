package Repository;

import Models.daily;
import Models.dvt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class DVTRepository extends Connection{
    public DVTRepository() {
        super();
    }

    public List<dvt> getAll() throws IOException {
        super.openGetConnection("dvt/getALLDVT");
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type listType = new TypeToken<List<dvt>>(){}.getType();
        List<dvt> dvtList = gson.fromJson(reader, listType);
        super.closeConnection();
        return dvtList;
    }

    public void createDVT(dvt dvt){
        Gson gson = new Gson();
        String json = gson.toJson(dvt);
        super.openPostConnection("dvt/addDVT");
        super.writeObject(json);
        super.closeConnection();
    }
}

