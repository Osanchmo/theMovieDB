import java.util.ArrayList;
import java.util.Scanner;


public class MenuMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

            System.out.println("escriu 1 o 2 per escollir mode");
            System.out.println("mode 1 Movies");
            System.out.println("mode 2 Casting");
            String sw = in.nextLine();

            switch(sw){
                case "1":
                        firstMode();

                    break;
                case "2":
                        secondMode();
                    break;
                default:
                    System.out.println("el valor introduit no es valid");
                    break;
            }
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
        SQL = "SELECT * FROM CAST WHERE MOVIE_ID = " + sel + ";";
        ArrayList<Cast> casts = SQLSelect.getCasts(SQL);

        System.out.println("PLANTILLA");

        for (Cast c: casts) {
            System.out.println( c.getCharacter() + "\t<----->\t" + c.getName());

        }
    }

    private static void secondMode(){

        Scanner in = new Scanner(System.in);
        System.out.println("iniciant mode 2 Casting \n Mostrant casting: ");
        String SQL = "SELECT * FROM CAST;";

        ArrayList<Cast> casts = SQLSelect.getCasts(SQL);

        for (Cast cast: casts) {
            System.out.println(cast.id + ": " + cast.getCharacter() + "\t<----->\t" + cast.getName());
        }

        System.out.print("Escull un actor y mostrare en quines pel·lícules surt: ");

        int sel = in.nextInt();
            SQL = "SELECT * FROM MOVIE AS A JOIN CAST AS B ON (A.MOVIE_ID = B.MOVIE_ID) WHERE";
        ArrayList<Cast> c = SQLSelect.getCasts(SQL);

        System.out.println("PEL·LÍCULES");
    }

    /**
     * inicia el segon mode

    private static void secondMode(){
        Scanner in = new Scanner(System.in);
        System.out.println("iniciant mode 2 Casting");
        ArrayList<Cast> casts = SQLSelect.SelectCast(-1);

        for (Cast m: casts) {
            System.out.println("identificador: " + m.getId() + "\n  nom: " + m.getName());
        }

        System.out.print("Escull un actor: ");
        int sel = in.nextInt();

        casts.clear();
        casts = SQLSelect.SelectCast(sel);
        Cast m = casts.get(0);
        System.out.println("\n" + m.getName() + " <-Interpreta a-> " + m.getCharacter());

    }*/
}
