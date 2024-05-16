package Repository;

import Models.*;
import com.google.gson.Gson;
import com.sun.net.httpserver.Request;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;

import java.net.HttpURLConnection;

import java.net.URL;

public class Connection {
    private URL url;
    public HttpsURLConnection con;

    protected static Gson gson ;

    public Connection() {
        gson = new Gson();
    }

    public void openGetConnection() {
    try {

        URL url = new URL("https://still-cliffs-55450-6c9d6b2dff57.herokuapp.com/daily/getAllDaiLy");

        con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public HttpURLConnection getCon() {
        return con;
    }

    public void setCon(HttpsURLConnection con) {
        this.con = con;
    }


    public void closeConnection(){
        con.disconnect();
    }

    public void openPostConnection(String link) {
        try {
            URL url = new URL(link);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String insertUser(person person) {
        gson = new Gson();
        String json = gson.toJson(person);

        openPostConnection("http://localhost:8080/user/createPerson");

        String response = "";
        try {
            // Send post request
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(json);
            osw.flush();
            osw.close();
            os.close();

            // Get the response code
            response = String.valueOf(con.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeConnection();
        return response;
    }

    //loaidaily
    /*public String addLoaiDaiLy(loaidaily loaidaily){
        openPostConnection("http://localhost:8080/loaidaily/createLoaiDaiLy");
        String response = "";
        try {
            // Send post request
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.close();

            // Get the response code
            response = String.valueOf(con.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeConnection();

        return response;
    }*/

    public String insertPhieuThuTien(phieuthutien phieuthutien){
        gson = new Gson();

        String json = gson.toJson(phieuthutien);

        //openPostConnection("http://localhost:8080/daily/createDaiLy");

        String response = "";
        try {
            // Send post request
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(json);
            osw.flush();
            osw.close();
            os.close();

            // Get the response code
            response = String.valueOf(con.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeConnection();

        return "";
    }

    public String insertPhieuXuatHang(phieuxuathang phieuxuathang){
        gson = new Gson();

        String json = gson.toJson(phieuxuathang);

        //openPostConnection("http://localhost:8080/daily/createDaiLy");

        String response = "";
        try {
            // Send post request
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(json);
            osw.flush();
            osw.close();
            os.close();

            // Get the response code
            response = String.valueOf(con.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeConnection();

        return "";
    }

    public String insertPhieuNhapHang(phieunhaphang phieunhaphang){
        gson = new Gson();

        String json = gson.toJson(phieunhaphang);

        //openPostConnection("http://localhost:8080/daily/createDaiLy");

        String response = "";
        try {
            // Send post request
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(json);
            osw.flush();
            osw.close();
            os.close();

            // Get the response code
            response = String.valueOf(con.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeConnection();

        return "";
    }

    public String insertBaoCaoCongNo(baocaocongno baocaocongno){
        gson = new Gson();

        String json = gson.toJson(baocaocongno);

        //openPostConnection("http://localhost:8080/daily/createDaiLy");

        String response = "";
        try {
            // Send post request
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(json);
            osw.flush();
            osw.close();
            os.close();

            // Get the response code
            response = String.valueOf(con.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeConnection();

        return "";
    }

    public String insertBaoCaoDoanhSo(baocaodoanhso baocaodoanhso){
        gson = new Gson();

        String json = gson.toJson(baocaodoanhso);

        //openPostConnection("http://localhost:8080/daily/createDaiLy");

        String response = "";
        try {
            // Send post request
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(json);
            osw.flush();
            osw.close();
            os.close();

            // Get the response code
            response = String.valueOf(con.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeConnection();

        return "";
    }
}
