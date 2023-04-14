import java.util.Arrays;
import java.util.List;

public class Person {
    String PersonID;
    String primaryName ;
    int birthYear ;
    Integer deathYear ;
    String[] primaryProfession ;
    String[] knownForTitles;

    private static final List<String> VALID_PROFFESIONS = Arrays.asList(
            "director",
            "soundtrack",
            "actor",
            "miscellaneous",
            "actress",
            "music_department",
            "writer",
            "producer",
            "stunts",
            "make_up_department",
            "composer",
            "editor",
            "cinematographer",
            "costume_department",
            "animation_department",
            "",
            "special_effects"
    );



    public Person(String nconst, String primaryName, int birthYear, Integer deathYear, String[] primaryProfession, String[] knownForTitles) {
        this.PersonID = nconst;
        this.primaryName = primaryName;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.primaryProfession = primaryProfession;
        this.knownForTitles = knownForTitles;
    }


    public Person(){

    }


    public void setProfession(String[] primaryProfession) {
        for (String profession : primaryProfession) {
            if (!VALID_PROFFESIONS.contains(profession)) {
                throw new IllegalArgumentException("Invalid genre: " + profession);
            }
        }
        this.primaryProfession = primaryProfession;
    }


    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        this.PersonID = personID;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public String[] getPrimaryProfession() {
        return primaryProfession;
    }

    public void setPrimaryProfession(String[] primaryProfession) {
        this.primaryProfession = primaryProfession;
    }

    public String[] getKnownForTitles() {
        return knownForTitles;
    }

    public void setKnownForTitles(String[] knownForTitles) {
        this.knownForTitles = knownForTitles;
    }
}
