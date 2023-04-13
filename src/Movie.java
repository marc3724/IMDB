import java.util.Arrays;
import java.util.List;

public class Movie {
    private String MovieID;
    private String titletype;
    private String primarytitle;
    private String originaltitle;
    private boolean isadult;
    private int startyear;
    private int endyear;
    private int runtimeminutes;
    private String[] genres;

    // List of valid genres
    private static final List<String> VALID_GENRES = Arrays.asList(
            "Action",
            "Adventure",
            "Animation",
            "Biography",
            "Comedy",
            "Crime",
            "Documentary",
            "Drama",
            "Family",
            "Fantasy",
            "Film-Noir",
            "History",
            "Horror",
            "Music",
            "Musical",
            "Mystery",
            "Romance",
            "Sci-Fi",
            "Short",
            "Sport",
            "Thriller",
            "War",
            "Western"
    );

    public Movie(String MovieID, String titletype, String primarytitle, String originaltitle, boolean isadult, int startyear, int endyear, int runtimeminutes, String[] genres) {
        this.MovieID = MovieID;
        this.titletype = titletype;
        this.primarytitle = primarytitle;
        this.originaltitle = originaltitle;
        this.isadult = isadult;
        this.startyear = startyear;
        this.endyear = endyear;
        this.runtimeminutes = runtimeminutes;
        setGenres(genres);
    }

    public Movie() {

    }

    public void setGenres(String[] genres) {
        for (String genre : genres) {
            if (!VALID_GENRES.contains(genre)) {
                throw new IllegalArgumentException("Invalid genre: " + genre);
            }
        }
        this.genres = genres;
    }

    public String getMovieIDt() {
        return MovieID;
    }
    public void setTconst(String MovieID) {
        this.MovieID = MovieID;
    }


    public String getTitletype() {
        return titletype;
    }
    public void setTitletype(String titletype) {
        this.titletype = titletype;
    }


    public String getPrimarytitle() {
        return primarytitle;
    }
    public void setPrimarytitle(String primarytitle) {
        this.primarytitle = primarytitle;
    }


    public String getOriginaltitle() {
        return originaltitle;
    }
    public void setOriginaltitle(String originaltitle) {
        this.originaltitle = originaltitle;
    }


    public boolean isIsadult() {
        return isadult;
    }
    public void setIsadult(boolean isadult) {
        this.isadult = isadult;
    }


    public int getStartyear() {
        return startyear;
    }
    public void setStartyear(int startyear) {
        this.startyear = startyear;
    }


    public int getEndyear() {
        return endyear;
    }
    public void setEndyear(int endyear) {
        this.endyear = endyear;
    }


    public int getRuntimeminutes() {
        return runtimeminutes;
    }
    public void setRuntimeminutes(int runtimeminutes) {
        this.runtimeminutes = runtimeminutes;
    }

    public String[] getGenres() {
        return genres;
    }
}