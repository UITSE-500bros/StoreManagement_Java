package Repository;

import Models.baocaocongno;
import Models.quan;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class BaoCaoCongNoRepository extends Connection{
    public BaoCaoCongNoRepository() {
        super();
    }

    public List<baocaocongno> getBaoCaoCongNo(int thang, int nam) throws IOException {
        super.openGetConnection("baocaocongno/getCongNo?thang=" + thang + "&nam=" + nam);
        gson = new Gson();

        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type listType = new TypeToken<List<baocaocongno>>(){}.getType();
        List<baocaocongno> bccnList = gson.fromJson(reader, listType);
        con.disconnect();
        return bccnList;
    }
}
