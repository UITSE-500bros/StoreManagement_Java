package Repository;

import Models.phieuthutien;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class PhieuThuTienRepository extends Connection{
    public PhieuThuTienRepository() {
        super();
    }
    public String insertPhieuThuTien(phieuthutien phieuThuTien) {
        gson = new Gson();
        String json = gson.toJson(phieuThuTien);
        openPostConnection("phieuthutien/addPhieuThuTien");
        response = "";
        writeObject(json);
        closeConnection();
        return response;
    }

}
