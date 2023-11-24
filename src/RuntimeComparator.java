import java.util.Comparator;

public class RuntimeComparator implements Comparator<Movie>
{
    @Override
    public int compare(Movie m1, Movie m2)
    {
        int runtimeMovie1 = m1.getRuntime();
        int runtimeMovie2 = m2.getRuntime();
        if(runtimeMovie1 < runtimeMovie2)
        {
            return -1;
        }
        else if(runtimeMovie1 > runtimeMovie2)
        {
            return 1;
        }
        return 0;
    }
}
