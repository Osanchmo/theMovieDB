public class Cast {
    int id;
    String name;
    String character;
    int movie_id;

    public Cast( String name, String character, int movie_id){
        this.name = name;
        this.character = character;
        this.movie_id = movie_id;
    }
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

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
