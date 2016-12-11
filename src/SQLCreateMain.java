import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLCreateMain {

    public static void main(String[] args) {
        createDB();
    }

    private static void createDB(){
        Connection c = null;
        Statement stmt = null;
        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:movid.db");
            System.out.println("Conexión con BBDD establecida");

            stmt = c.createStatement();
            String sql = "CREATE TABLE MOVIE " +
                    "(MOVIE_ID        INT          NOT NULL," +
                    " TITLE           TEXT         NOT NULL, " +
                    " REL_DATE        INT          NOT NULL," +
                    " PRIMARY KEY (MOVIE_ID))";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE CAST " +
                    "(CAST_ID         INT           NOT NULL," +
                    " CAST_NAME       TEXT          NOT NULL, " +
                    " CHARACTER       TEXT          NOT NULL," +
                    " MOVIE_ID        INT          NOT NULL," +
                    " PRIMARY KEY (CAST_ID)," +
                    " FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(MOVIE_ID))";
            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Se han creado las tablas correctamente");
    }
}
