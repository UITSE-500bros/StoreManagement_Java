package Controller;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

public class Connection {
    private URL url;
    public HttpsURLConnection con;

    public void openGetConnection(){
        try {
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
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

    public HttpsURLConnection getCon() {
        return con;
    }

    public void setCon(HttpsURLConnection con) {
        this.con = con;
    }


    public void closeConnection(){
        con.disconnect();
    }

    public void openPostConnection() {
        try {
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
