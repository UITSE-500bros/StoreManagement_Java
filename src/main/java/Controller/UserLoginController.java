package Controller;

import Models.User.person;

import UI.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

import java.io.InputStreamReader;

public class UserLoginController {
    public person person;
    public login login;


    public UserLoginController(login login) throws IOException {

    }


    public void getUserByEmail(String email) throws IOException {
		
		try {
			String encodedEmail = URLEncoder.encode(email, StandardCharsets.UTF_8.toString());
	        URI uri1 = new URI("http://localhost:8080/user/allUser?personemail=" + encodedEmail);
			URL url = uri1.toURL();
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	         con.setRequestMethod("GET");
	         con.setRequestProperty("Content-Type", "application/json");
	         con.setConnectTimeout(5000);
	         con.setReadTimeout(5000);

	         int status = con.getResponseCode();

	         BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         String inputLine;
	         StringBuffer content = new StringBuffer();
	         while ((inputLine = in.readLine()) != null) {
	         content.append(inputLine);
	         }

	         // close connections
	         in.close();
	         con.disconnect();

	         System.out.println("Response content: " + content.toString());


		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

    }



}
