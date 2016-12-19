public class Cast {
    Long id;
    String name;
    String character;
    int movie_id;

    public Cast( String name, String character, int movie_id,Long id){
        this.id = id;
        this.name = name;
        this.character = character;
        this.movie_id = movie_id;
    }
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public String getCharacter() {
        return character;
    }

    public int getMovie_id() {
        return movie_id;
    }

}
