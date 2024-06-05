package Repository;

import Models.*;
import com.google.gson.Gson;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {
    private URL url;
    public HttpsURLConnection con;

    protected static Gson gson ;
    protected static String response;

    public Connection() {
        gson = new Gson();
    }

    public void openGetConnection(String link) {
        try {
            URL url = new URL("https://still-cliffs-55450-6c9d6b2dff57.herokuapp.com/" +link);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.connect();
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
            URL url = new URL("https://still-cliffs-55450-6c9d6b2dff57.herokuapp.com/" +link);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void writeObject(String json){
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
    }

    public String loginUser(String email, String pass){
        int responseCode = 0;
        try {
            URL url = new URL("https://still-cliffs-55450-6c9d6b2dff57.herokuapp.com/" + "user/getLoginUser?personemail="+email+"&personpassword="+pass);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.connect();
            responseCode = con.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(responseCode == 200){
            return "Đăng nhập thành công";
        } else {
            return "Đăng nhập thất bại";
        }

    }

}
