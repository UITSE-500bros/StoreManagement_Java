package Repository;

import Models.quan;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
        List<quan> quans = gson.fromJson(getCon().getInputStream().toString(), List.class);
        getCon().disconnect();
        return quans;
    }
}
