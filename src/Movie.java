public class Movie implements Comparable<Movie>, MeasureTime
{
    private String title;
    private String director;
    private int runtime;
    private GENRE genre;

    public Movie() {
        title = "";
        director = "";
        runtime = 0;
        genre = GENRE.ACTION;

    }

    public Movie(String title, String director,
                 int runtime, GENRE genre)
    {
        this.title = title;
        this.director = director;
        this.runtime = runtime;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public GENRE getGenre() {
        return genre;
    }

    public void setGenre(GENRE genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", runtime=" + runtime +
                ", genre=" + genre +
                '}';
    }

    @Override
    public int compareTo(Movie m)
    {
        if(title.compareTo(m.getTitle())==0)
            return director.compareTo(m.getDirector());
        return title.compareTo(m.getTitle());
    }

    @Override
    public int measure() {
        return runtime;
    }
}
