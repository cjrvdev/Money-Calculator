package interoperability;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONHttpGet {

    URL url;
    HttpURLConnection conn;
    BufferedReader rd;
    String line;
    String result = "";

    public String getJsonFromUrl(String sourceUrl) {
        try{
            url = new URL(sourceUrl);
         conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         while ((line = rd.readLine()) != null) {
            result += line;
         }
         rd.close();
        }catch(IOException e){
            return "";
        }
        return result;
    }

}
