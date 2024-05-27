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
    public List<thamso> getThamSo(thamso thamso) throws IOException {
        super.openGetConnection("thamso/getThamSo");
        gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type listType = new TypeToken<List<thamso>>(){}.getType();
        List<thamso> thamsoList = gson.fromJson(reader, listType);
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

    public String updateThamSo(thamso thamso){
        Gson gson = new Gson();
        String json = gson.toJson(thamso);
        super.openPostConnection("thamso/updateThamSo");
        response = "";
        super.writeObject(json);
        super.closeConnection();
        return response;
    }

    public int getThamSoValue() throws IOException {
        super.openGetConnection("thamso/getThamSoValue?tenthamso=Số đại lý tối đa trong một quận");
        gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        int value = gson.fromJson(reader, int.class);
        super.closeConnection();
        return value;
    }

    public int getThamSoValue2() throws IOException {
        super.openGetConnection("thamso/getThamSoValue?tenthamso=Tỷ lệ đơn giá xuất");
        gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        int value = gson.fromJson(reader, int.class);
        super.closeConnection();
        return value;
    }
}
