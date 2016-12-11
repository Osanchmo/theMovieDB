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
        System.out.println("iniciant mode 1 Movies");
        ArrayList<Movie> movies = SQLSelect.SelectMovies(-1);

        for (Movie m: movies) {
            System.out.println("identificador: " + m.getId() + "\n  Titol: " + m.getTitle());
        }

        System.out.print("Escull una película: ");
        int sel = in.nextInt();

        movies.clear();
        movies = SQLSelect.SelectMovies(sel);
        Movie m = movies.get(0);
            System.out.println("\n" + m.getTitle());
            System.out.println(m.getReleaseDate());


    }

    /**
     * inicia el segon mode
     */
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

    }
}
