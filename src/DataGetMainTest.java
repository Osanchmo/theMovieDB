import java.util.ArrayList;

public class DataGetMainTest {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Cast> casts = new ArrayList<>();

        DataGet.getMovieData(movies);
        DataGet.getCastData(casts);

        for (Movie m : movies){
            System.out.println(m.getId());
            System.out.println(m.getTitle());
            System.out.println(m.getReleaseDate());
        }

        for (Cast c: casts) {
            System.out.println(c.getMovie_id());
            System.out.println(c.getCharacter() + "<--->" + c.getName());
        }
    }


}
