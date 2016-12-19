import java.sql.*;
import java.util.ArrayList;

public class SQLSelect {

    public static ResultSet selectQuery(String query){
        ResultSet rs = null;

        try{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:movid.db");
            Statement stmt = c.createStatement();
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    return rs;
    }

    public static ArrayList<Movie> getMovies(String query){
        ArrayList<Movie> movies = new ArrayList<>();
        ResultSet rs = selectQuery(query);
        Movie m;
        try {
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

    public static ArrayList<Cast> getCasts(String query){
        ArrayList<Cast> casts = new ArrayList<>();
        ResultSet rs = selectQuery(query);
        Cast cast;
        try {
            while (rs.next()) {
                Long castid = rs.getLong("CAST_ID");
                String name = rs.getString("CAST_NAME");
                String character = rs.getString("CHARACTER");
                int movieID = rs.getInt("MOVIE_ID");
                cast = new Cast(name, character, movieID,castid);
                casts.add(cast);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return casts;
    }



    /**
     * selecciona les dades de películes de la BBDD
     * @param
     * @return

    public static ArrayList<Movie> SelectMovies() {

        Connection c = null;
        Statement stmt;
        Movie m;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movid.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM MOVIE;");

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

    /**
     * obté les dades del Casting de la BBDD
     * @param
     * @return

    public static ArrayList<Cast> SelectCast(){
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
                rs = stmt.executeQuery("SELECT * FROM CAST;");

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
    }*/
}
