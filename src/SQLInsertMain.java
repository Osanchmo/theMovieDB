import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLInsertMain {
    public static void main(String[] args) {

        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Cast> casts = new ArrayList<>();
        DataGet.getMovieData(movies);
        DataGet.getCastData(casts);

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movid.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            String sql = "";
            stmt = c.createStatement();

            for (Movie m: movies) {
                sql = "INSERT OR IGNORE INTO MOVIE (MOVIE_ID,TITLE,REL_DATE) " + "VALUES (?,?,?);";
                PreparedStatement prep = c.prepareStatement(sql); {
                    prep.setInt(1, m.getId());
                    prep.setString(2, m.getTitle());
                    prep.setString(3,m.getReleaseDate());
                    prep.executeUpdate();
                }
            }

            for (Cast cast : casts) {
                sql = "INSERT OR IGNORE INTO CAST (CAST_NAME,CHARACTER,MOVIE_ID) " + "VALUES (?,?,?);";
                PreparedStatement prep = c.prepareStatement(sql); {
                    prep.setString(1, cast.getName());
                    prep.setString(2,cast.getCharacter());
                    prep.setInt(3,cast.getMovie_id());
                    prep.executeUpdate();
                }

            }

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Records created successfully");
    }
}


