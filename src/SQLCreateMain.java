import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class SQLCreateMain {

    public static void main(String[] args) {
        createDB();
    }

    private static void createDB(){
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            //ruta BD
            c = DriverManager.getConnection("jdbc:postgresql://172.31.73.180:5432/moviedb","postgres","root");
            System.out.println("Conexión con BBDD establecida");
            //tipus de bd


            //Creació de taules
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS MOVIE " +
                    "(MOVIE_ID        INT          NOT NULL," +
                    " TITLE           TEXT         NOT NULL, " +
                    " REL_DATE        TEXT          NOT NULL," +
                    " PRIMARY KEY (MOVIE_ID))";
            //sql = "DROP TABLE MOVIE CASCADE";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE IF NOT EXISTS CASTI " +
                    "(CAST_ID          INTEGER        PRIMARY KEY," +
                    " CAST_NAME       TEXT          NOT NULL, " +
                    " CHARACTER       TEXT          NOT NULL," +
                    " MOVIE_ID        INT          NOT NULL," +
                    " FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE(MOVIE_ID))";
            //sql = "DROP TABLE CASTI CASCADE";
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
