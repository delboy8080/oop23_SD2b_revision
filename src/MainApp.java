import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainApp {
    public static void main(String[] args) {
        MainApp app = new MainApp();
        //app.start();
        app.measureTime();
    }

    public void display(ArrayList<Movie> movies) {
        System.out.printf("%-20s %-20s %-15s %-5s\n", "Title", "Director",
                "Genre", "Runtime");
        for (Movie s : movies) {
            String title = s.getTitle().length() > 20 ? s.getTitle().substring(0, 17) + "..." :
                    s.getTitle();
            String director = s.getDirector().length() > 20 ? s.getDirector()
                    .substring(0, 17) + "..." :
                    s.getDirector();
            System.out.printf("%-20s %-20s %-15s %-5d\n", title, director,
                    s.getGenre(), s.getRuntime());
        }

    }

    public void start() {
        Movie m1 = new Movie("Iron Man", "Joh Favreau", 124, GENRE.ACTION);
        Movie m2 = new Movie("Indiana Jones " +
                "and the raiders of the lost ark", "Steven Spielberg",
                115, GENRE.ADVENTURE);

        ArrayList<Movie> movies = new ArrayList();
        movies.add(m1);
        movies.add(m2);
        movies.add(new Movie("The Marvels", "Nico De Costa", 100, GENRE.COMEDY));
        movies.add(new Movie("Spirited Away", "Shawn Levy", 95, GENRE.COMEDY));
        movies.add(new Movie("The Firm", "John Grisham", 100, GENRE.DRAMA));
        movies.add(new Movie("E. T. the extra terrestrial", "Steven Spielberg", 150, GENRE.DRAMA));
        movies.add(new Movie("Iron Man", "Steven Spielberg", 180, GENRE.COMEDY));

        System.out.println("************ Natural Ordering *******************");
        Collections.sort(movies); // defined in Movie
        display(movies);

        System.out.println("************ Using Comparator *******************");

        RuntimeComparator comp = new RuntimeComparator();// defined in comparator Class
        Collections.sort(movies, comp);
        display(movies);

        System.out.println("************ Using Annoymous Inner Class *******************");
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return m1.getGenre().compareTo(m2.getGenre());
            }
        });
        display(movies);
        System.out.println("************ Using Lambda Expression 1 *******************");
        Collections.sort(movies, (Movie mov1, Movie mov2) ->
        {
            return mov1.getDirector().compareTo(mov2.getDirector());
        });
        display(movies);

        System.out.println("************ Using Lambda Expression 2 *******************");
        Collections.sort(movies, (mov1, mov2) ->
        {
            return mov2.getTitle().compareTo(mov1.getTitle());
        });
        display(movies);

        // Collections.sort(movies);
        Movie key = new Movie();
        key.setTitle("Iron Man");
        // key.setDirector("Shawn Levy");
        int index = Collections.binarySearch(movies, key, (mov1, mov2) ->
        {
            return mov2.getTitle().compareTo(mov1.getTitle());
        });
        System.out.println("Key found at position " + index);
        if (index >= 0) {
            System.out.println(movies.get(index));
        }

    }

    public void measureTime() {
            Movie m2 = new Movie("Indiana Jones " +
            "and the raiders of the lost ark", "Steven Spielberg",
            115, GENRE.ADVENTURE);
        ArrayList<MeasureTime> activities = new ArrayList<>();
        activities.add(new Book("The Firm", "John Grisham"
                , 300, 2));

        activities.add(m2);
        int total=0;
        for(MeasureTime m : activities)
        {
            total+= m.measure();
        }
        System.out.println(total);
    }
}