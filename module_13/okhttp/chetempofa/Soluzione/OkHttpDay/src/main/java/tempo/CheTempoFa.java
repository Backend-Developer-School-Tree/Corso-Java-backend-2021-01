package tempo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CheTempoFa {
        OkHttpClient client = new OkHttpClient();

        String run(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

            return null;
        }

        public static void main(String[] args) throws IOException {
            Gson gson = new Gson();


            String filePath = new File("").getAbsolutePath() + System.getProperty("file.separator");
            File tokenFile = new File(filePath + "token.txt");
            String token = "";
            try (Scanner s = new Scanner(tokenFile))
            {
                while (s.hasNext())
                {
                    token = s.nextLine();
                }
            }
            CheTempoFa example = new CheTempoFa();
            String response = example.run("http://api.openweathermap.org/data/2.5/weather?q=Rome,it&appid=" + token + "&units=metric");

            if(response == null)
                return;

            System.out.println(response);
            WeatherResponse wr = gson.fromJson(response, WeatherResponse.class);

            System.out.println(wr.weather.get(0).main);

        }
    }
