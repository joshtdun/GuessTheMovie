
public class MovieTitles {
    public static String randomMovie() {
//list of movies for the game to choose from
        String[] moviesList = {
                "The Godfather",
                "The Dark Knight",
                "Lord of the Rings",
                "Pulp Fiction",
                "Fight CLub",
                "Good Will Hunting",
                "Inception",
                "The Matrix",
                "Goodfellas",
                "The Silence of the Lambs",
                "Saving Private Ryan",
                "The Green Mile",
                "The Prestige",
                "Back to the Future",
                "The Lion King",
                "Django Unchained",
                "Braveheart",
                "Reservoir Dogs",
                "2001 A Space Odyssey",
                "Toy Story",
                "To Kill a Mockingbird",
                "Inglourioous Basterds",
                "Monty Python and the Holy Grail",
                "The Wolf of Wall Street",
                "Gran Torino",
                "Jurassic Park"
        };
        //generating random int to use to pick movie from array
        double r = Math.random();
        //movie list only has 26 entries
        double useThis = r * 26;
        //casting to an int
        int ranInt = (int) useThis;
        String movie = moviesList[ranInt];
        return movie;
    }
}
