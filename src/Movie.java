public class Movie {
    int id;
    String title;
    String releaseDate;

    public Movie(int id, String title, String releaseDate){
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

}
