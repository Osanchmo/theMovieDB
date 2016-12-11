import java.sql.*;
import java.util.ArrayList;

public class SQLSelect {


    public static ArrayList<Movie> SelectMovies(int opt) {
        ArrayList<Movie> movies = new ArrayList<>();
        Connection c = null;
        Statement stmt;
        Movie m;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movid.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs;
            if (opt == -1) {
            rs = stmt.executeQuery("SELECT * FROM MOVIE;");
            }else rs = stmt.executeQuery("SELECT * FROM MOVIE WHERE MOVIE_ID = " + opt + ";");

            while (rs.next()) {
                int id = rs.getInt("MOVIE_ID");
                String name = rs.getString("TITLE");
                String date = rs.getString("REL_DATE");
                m = new Movie(id, name, date);
                movies.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }


    public static ArrayList<Cast> SelectCast(int opt){
        ArrayList<Cast> casts = new ArrayList<>();
        Connection c = null;
        Statement stmt;
        Cast cast;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movid.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs;
            if (opt == -1) {
                rs = stmt.executeQuery("SELECT * FROM CAST;");
            } else rs = stmt.executeQuery("SELECT * FROM CAST WHERE CAST_ID =" +opt + " ;");

            while (rs.next()) {
                int id = rs.getInt("CAST_ID");
                String name = rs.getString("CAST_NAME");
                String character = rs.getString("CHARACTER");
                int movieID = rs.getInt("MOVIE_ID");
                cast = new Cast(name, character, movieID);
                cast.setId(id);
                casts.add(cast);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return casts;
    }
}
