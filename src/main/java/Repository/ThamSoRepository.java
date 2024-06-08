package Repository;

import Models.dvt;
import Models.thamso;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class ThamSoRepository extends Connection{
    public ThamSoRepository() {
        super();
    }
    public thamso getThamSo(String tenthamso) throws IOException {
        super.openGetConnection("thamso/getThamSoValue" + "?tenthamso=" + tenthamso);
        gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type listType = new TypeToken<thamso>(){}.getType();
        thamso thamsoList = gson.fromJson(reader, listType);
        super.closeConnection();
        return thamsoList;
    }

    public String insertThamSo(thamso thamso){
        Gson gson = new Gson();
        String json = gson.toJson(thamso);
        super.openPostConnection("thamso/addThamSo");
        response = "";
        super.writeObject(json);
        super.closeConnection();
        return response;
    }

    public String updateThamSo(thamso thamso) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(thamso);
        response = "";
        super.openPostConnection("thamso/updateThamSo");
        super.writeObject(json);
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type bool = new TypeToken<Boolean>(){}.getType();
        boolean result = gson.fromJson(reader, bool);
        super.closeConnection();
        if(result){
            return "200";
        } else {
            return "400";
        }

    }
}
