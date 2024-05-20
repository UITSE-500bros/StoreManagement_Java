package Repository;

import Models.ctnh;
import Models.phieunhaphang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

public class PhieuNhapHangRepository extends Connection {
    public PhieuNhapHangRepository() {
        super();
    }

    private int mapnhap;

    public int createPhieuNhapHang(phieunhaphang newPhieuNhapHang) throws IOException {
        super.openPostConnection("phieunhaphang/createpnh");
        response = "";
        writeObject(gson.toJson(newPhieuNhapHang));
        if (response.contains("201")) { // 201 is the HTTP status code for "Created"
            BufferedReader in = new BufferedReader(new InputStreamReader(getCon().getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            closeConnection();
            mapnhap = Integer.parseInt(content.toString());
            return Integer.parseInt(content.toString()); // Convert the response body to int
        } else {
            closeConnection();
            throw new IOException("Failed to create phieunhaphang. HTTP response code: " + response);
        }
    }

    private String createCTNH(List<ctnh> ctnh) {
        super.openPostConnection("ctnh/createctnh");
        response = "";
        writeObject(gson.toJson(ctnh));
        closeConnection();
        if (response.contains("201")) { // 201 is the HTTP status code for "Created"
            return "Created successfully!";
        } else {
            return "Failed to create ctnh. HTTP response code: " + response;
        }


    }


}
