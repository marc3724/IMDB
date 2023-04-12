public class Movie {
    String tconst;
    String PrimaryTitle;
    String OriginalTitle;
    int StartYear;
    int EndYear;

    public Movie(){
    }

    public Movie(String tconst, String primaryTitle, String originalTitle, int startYear, int endYear) {
        this.tconst = tconst;
        PrimaryTitle = primaryTitle;
        OriginalTitle = originalTitle;
        StartYear = startYear;
        EndYear = endYear;
    }
}

