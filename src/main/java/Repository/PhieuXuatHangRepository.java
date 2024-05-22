package Repository;

import Models.ctxh;
import Models.phieunhaphang;
import Models.phieuxuathang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PhieuXuatHangRepository extends Connection
{
    public PhieuXuatHangRepository() {
        super();
    }

    private int mapxuat;
    public int createPhieuXuatHang(phieuxuathang phieuXuatHang) throws IOException {
        openPostConnection("phieuxuathang/createpxh");
        String json = gson.toJson(phieuXuatHang);
        response ="";
        writeObject(json);
        if (response.contains("201")) {
            BufferedReader in = new BufferedReader(new InputStreamReader(getCon().getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            closeConnection();
            mapxuat = Integer.parseInt(content.toString());
            return Integer.parseInt(content.toString()); // Convert the response body to int
        } else {
            closeConnection();
            throw new IOException("Failed to create phieuxuathang. HTTP response code: " + response);
        }
    }

    public String createCTXH(List<ctxh> ctxhList) {
        super.openPostConnection("ctxh/createctxh");
        response = "";
        writeObject(gson.toJson(ctxhList));
        closeConnection();
        if (response.contains("201")) { // 201 is the HTTP status code for "Created"
            return "Created successfully!";
        } else {
            return "Failed to create ctxh. HTTP response code: " + response;
        }
    }
}
