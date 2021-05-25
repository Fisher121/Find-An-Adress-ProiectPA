package Client.api;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ClientCommunicationHandler {
    static private String host = "http://localhost:8010";

    public static JSONObject getAdress(String city, String state, String country) {
        if (city == null) city = "city";
        if (state == null) state = "state";
        if (country == null) country = "country";

        String tempurl = host + "/api/adress/correct/" + country + "/" + state + "/" + city;
        tempurl = tempurl.replaceAll("\\s","~");
        return getRequest(tempurl);
    }

    public static JSONObject getRequest(String URL){
        JSONObject response = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            response = new JSONObject(readFromConnection(connection));
        }catch (Exception e){
            response = new JSONObject();
            response.append("Error!","Error on the client side ! Contact the admin!");
            response.append("Error!!",e.getCause());
            e.printStackTrace();
        } finally {
            connection.disconnect();
            return response;
        }
    }
    public static String readFromConnection(HttpURLConnection connection) throws IOException {
        StringBuilder content;
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        content = new StringBuilder();
        while ((line = input.readLine()) != null) {
            content.append(line);
        }
        return content.toString();
    }
    public static String createJson(JSONObject jsonObject){
        StringBuilder tempString = new StringBuilder();
        tempString.append("{");
        int count = 0;
        for(String key : jsonObject.keySet()){
            if(count!=0)
                tempString.append(",");

            tempString.append("\"");
            tempString.append(key);
            tempString.append("\"");
            tempString.append(":");
            String temp = jsonObject.get(key).toString();
            temp = temp.substring(1);
            temp = temp.substring(0,temp.length()-2);
            tempString.append(temp);
            tempString.append("\"");
            count++;
        }
        tempString.delete(tempString.length()-1,tempString.length()-1);
        tempString.append("}");
        return tempString.toString();
    }
}
