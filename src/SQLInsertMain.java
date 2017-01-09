import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class SQLInsertMain {
    public static void main(String[] args) {

        //incialitzem l'obtenció de dades
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Cast> casts = new ArrayList<>();
        DataGet.getMovieData(movies);
        DataGet.getCastData(casts);

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            //ruta BD
            c = DriverManager.getConnection("jdbc:postgresql://172.31.73.180:5432/moviedb","postgres","root");
            System.out.println("Conexión con BBDD establecida");

            String sql = "";
            stmt = c.createStatement();

            //Afegil les dades obtesses de la API a la BD
            for (Movie m: movies) {
                sql = "INSERT INTO MOVIE (MOVIE_ID,TITLE,REL_DATE) " + "VALUES (?,?,?) ON CONFLICT DO NOTHING;";
                PreparedStatement prep = c.prepareStatement(sql); {
                    prep.setInt(1, m.getId());
                    prep.setString(2, m.getTitle());
                    prep.setString(3,m.getReleaseDate());
                    prep.executeUpdate();
                }
            }

            for (Cast cast : casts) {
                sql = "INSERT INTO CASTI (CAST_ID,CAST_NAME,CHARACTER,MOVIE_ID) " + "VALUES (?,?,?,?) ON CONFLICT DO NOTHING;";
                PreparedStatement prep = c.prepareStatement(sql); {
                    prep.setLong(1, cast.getId());
                    prep.setString(2, cast.getName());
                    prep.setString(3, cast.getCharacter());
                    prep.setInt(4, cast.getMovie_id());
                    prep.executeUpdate();
                }

            }

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }
}


