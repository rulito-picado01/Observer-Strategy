package observerFacundo.punto1;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Clima implements WhatherChanelService{

    private String apiKey;

    public Clima(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String temperatura() {
        String temp = "N/A";
        try {
            String endpoint = "https://api.openweathermap.org/data/2.5/weather?q=Viedma,Argentina&units=metric&appid=" + apiKey;
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder respuesta = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                respuesta.append(inputLine);
            }



            JSONObject jsonObject = new JSONObject(respuesta.toString());
            JSONObject main = jsonObject.getJSONObject("main");
            temp = main.get("temp") + " °C";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
}