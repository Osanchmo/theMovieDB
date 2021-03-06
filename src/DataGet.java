import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DataGet {

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    /**
     * obté les dades del casting de la API
     * @param casts
     * @return
     */
    public static ArrayList<Cast> getCastData(ArrayList<Cast> casts) {
        String s = "";
        String api_key = "64f50fb33fb55357474e1c096fcda697";
        Cast c;

        for (int i = 0; i < 5; i++) {

            int cast = 605 + i;

            String film = String.valueOf(cast);

            String peticio = "https://api.themoviedb.org/3/movie/"+film+"/credits?api_key="+api_key;

            try {
                s = getHTML(peticio);

                Object temp = JSONValue.parse(s);
                JSONObject data=(JSONObject)temp;
                JSONArray array = (JSONArray)data.get("cast");

                for (int x = 0; x < array.size(); x++) {
                    JSONObject jo= (JSONObject)array.get(x);
                    c = new Cast((String)jo.get("name"), (String)jo.get("character"), cast,(Long)jo.get("cast_id"));
                    casts.add(c);
                }

            } catch (Exception e) {
                System.out.println("La peli "+ e +" no existeix");
            }
        }
        return casts;
    }

    /**
     * obté les dades de les pelicules de la API
     * @param movies
     * @return
     */
    public static ArrayList<Movie> getMovieData(ArrayList<Movie> movies) {

        String s = "";
        String api_key = "64f50fb33fb55357474e1c096fcda697";
        Movie m;
        for (int i = 0; i < 5; i++) {

            int peli = 605 + i;
            String film = String.valueOf(peli);
            String peticio = "https://api.themoviedb.org/3/movie/"+film+"?api_key="+api_key;

            try {
                s = getHTML(peticio);

                Object temp = JSONValue.parse(s);
                JSONObject data = (JSONObject)temp;

                m = new Movie(peli,(String)data.get("original_title"), (String)data.get("release_date"));
                movies.add(m);

            } catch (Exception e) {
                System.out.println("La peli "+film+" no existeix");
            }
        }
        return movies;
    }
}

