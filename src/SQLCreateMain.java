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

            //tipus de bd
            Class.forName("org.sqlite.JDBC");
            //ruta BD
            c = DriverManager.getConnection("jdbc:sqlite:movid.db");
            System.out.println("Conexión con BBDD establecida");

            //Creació de taules
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS MOVIE " +
                    "(MOVIE_ID        INT          NOT NULL," +
                    " TITLE           TEXT         NOT NULL, " +
                    " REL_DATE        TEXT          NOT NULL," +
                    " PRIMARY KEY (MOVIE_ID))";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS CAST " +
                    "(CAST_ID         INTEGER       PRIMARY KEY," +
                    " CAST_NAME       TEXT          NOT NULL, " +
                    " CHARACTER       TEXT          NOT NULL," +
                    " MOVIE_ID        INT          NOT NULL," +
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
