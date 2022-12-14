package lessonsJCore.JCore.dz.lesson7.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import lessonsJCore.JCore.dz.lesson7.project.enums.Periods;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AccuWeatherProvider extends WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
            // TODO: Сделать в рамках д/з вывод более приятным для пользователя.
            class WeatherMain {
                static Properties prop = new Properties();

                public static void main(String[] args) throws IOException {
                    loadProperties();
                    OkHttpClient client = new OkHttpClient();

                    // Сегментированное построение URL
                    HttpUrl url = new HttpUrl.Builder()
                            .scheme("http")
                            .host(prop.getProperty("BASE_HOST"))
                            .addPathSegment(prop.getProperty("FORECAST"))
                            .addPathSegment(prop.getProperty("API_VERSION"))
                            .addPathSegment(prop.getProperty("FORECAST_TYPE"))
                            .addPathSegment(prop.getProperty("FORECAST_PERIOD"))
                            .addPathSegment(prop.getProperty("SAINT_PETERSBURG_KEY"))
                            .addQueryParameter("apikey", prop.getProperty("API_KEY"))
                            .addQueryParameter("language", "ru-ru")
                            .addQueryParameter("metric", "true")
                            .build();

                    System.out.println(url.toString());

                    // При необходимости указать заголовки
                    Request requesthttp = new Request.Builder()
                            .addHeader("accept", "application/json")
                            .url(url)
                            .build();

                    String jsonResponse = client.newCall(requesthttp).execute().body().string();
                    System.out.println(jsonResponse);

                }
                private static void loadProperties () throws IOException {
                    try (FileInputStream configFile = new FileInputStream("src/lessonsJCore/JCore/dz/lesson6/lesson6.properties")) {
                        prop.load(configFile);


                    }
                }
            }

                   } else if(periods.equals(Periods.FIVE_DAYS)){

        }
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }
}





