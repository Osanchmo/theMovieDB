import java.util.ArrayList;
import java.util.Scanner;


public class MenuMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            Boolean bol = true;

            do {
                System.out.println("Escull una opció:");

                System.out.println("*************************************************");
                System.out.println("\tescriu 1 o 2 per escollir mode\t");
                System.out.println("\tmode 1 Movies\t");
                System.out.println("\tmode 2 Casting\t");
                System.out.println("\texit per sortir\t");
                System.out.println("*************************************************");

                String sw = in.next();
                switch (sw) {
                    case "1":
                        firstMode();
                        break;
                    case "2":
                        secondMode();
                        break;
                    case "exit":
                        bol = false;
                        break;
                    default:
                        System.out.println("el valor introduit no es valid");
                        break;
                }
            }while(bol);
    }

    /**
     * inicia el primer mode
     */
    private static void firstMode(){
        Scanner in = new Scanner(System.in);
        System.out.println("iniciant mode 1 Movies \n Mostrant pel·lícules: ");
        String SQL = "SELECT * FROM MOVIE;";
        ArrayList<Movie> movies = SQLSelect.getMovies(SQL);

        for (Movie m: movies) {
            System.out.println("identificador: " + m.getId() + "\n  Titol: " + m.getTitle());
        }

        System.out.print("Escull una película per veure el actors que han treballat en aquesta: ");

        int sel = in.nextInt();
        SQL = "SELECT * FROM CASTI WHERE MOVIE_ID = " + sel + ";";
        ArrayList<Cast> casts = SQLSelect.getCasts(SQL);

        System.out.println("PLANTILLA");

        for (Cast c: casts) {
            System.out.println( "\t" + c.getCharacter() + "\t<----->\t" + c.getName());

        }
    }

    private static void secondMode(){

        Scanner in = new Scanner(System.in);
        System.out.println("iniciant mode 2 Casting \n Mostrant casting: ");
        String SQL = "SELECT * FROM CASTI;";

        ArrayList<Cast> casts = SQLSelect.getCasts(SQL);

        for (Cast cast: casts) {
            System.out.println("\t" + cast.id + ": " + cast.getCharacter() + "\t<----->\t" + cast.getName());
        }

        System.out.print("Escull un actor y mostrare en quines pel·lícules surt: ");

        int sel = in.nextInt();
            SQL = "SELECT * FROM MOVIE AS A JOIN CASTI AS B ON (A.MOVIE_ID = B.MOVIE_ID) WHERE B.CAST_ID = " + sel + ";";
        ArrayList<Movie> movies = SQLSelect.getMovies(SQL);

        System.out.println("PEL·LÍCULES");
        for (Movie m: movies) {
            System.out.println(m.getTitle());
            System.out.println("\t" + m.getReleaseDate());
        }
    }
}
