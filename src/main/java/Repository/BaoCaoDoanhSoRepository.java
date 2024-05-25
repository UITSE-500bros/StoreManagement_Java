package Repository;

import Models.ctbcds;
import Models.quan;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class BaoCaoDoanhSoRepository extends Connection
{
    public BaoCaoDoanhSoRepository() {
        super();
    }

    public List<ctbcds> getBaoCaoDoanhSo(int thang, int nam) throws IOException {
        super.openGetConnection("baocaodoanhso/bcdsbythangandnam?thang=" + thang + "&nam=" + nam);
        gson =new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(con.getInputStream()));
        Type listType = new TypeToken<List<ctbcds>>(){}.getType();
        List<ctbcds> ctbcdsList = gson.fromJson(reader, listType);
        con.disconnect();
        return ctbcdsList;
    }
}
