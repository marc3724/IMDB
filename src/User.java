import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    String nconst;
    String primaryName ;
    int birthYear ;
    int deathYear ;
    professions[] primaryProfession ;
    ArrayList knownForTitles;


    public User(String nconst, String primaryName, int birthYear, int deathYear, professions[] primaryProfession, ArrayList knownForTitles) {
        this.nconst = nconst;
        this.primaryName = primaryName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.primaryProfession = primaryProfession;
        this.knownForTitles = knownForTitles;
    }


    public User (){
    }


}
