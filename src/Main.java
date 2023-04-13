import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    menu();
    }

    public static void menu (){
        int valg=1;
        Scanner input = new Scanner(System.in);
        DBSQL db = new DBSQL();

        while(valg!=0) {
            System.out.println("1. search for a movie\n" +
                    "2. search for a person \n" +
                    "3. add a movie to the database\n" +
                    "4. add a person to the database\n" +
                    /*
                    System.out.println("5. Udskriv alle oplysninger om alle studerende ");
                    System.out.println("6. Udskriv alle oplysninger om en studerende ");
                    System.out.println("7. Søg alle der har et givet fag ");
                    System.out.println("8. Opdater studerendes klasse ");
                    System.out.println("9. Slet studerende ");
                    */
                    "0. exit program");


            valg=input.nextInt();
            switch(valg){
                case 1://need data in database to work
                    System.out.println("write the name of the movie your looking for");
                    db.searchMovie (input.next());

                    break;
                case 2://need data in database to work
                    System.out.println("write the name of the person your looking for");
                    db.searchPerson(input.next());
                    break;


                case 3://add a movie
                    createMovie(db);
                    break;


                case 4://add a person
                    createPerson(db);
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }

    public static void createMovie(DBSQL db) {
        Movie movie = new Movie();
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter MovieID: ");
        movie.setTconst(scanner.nextLine());

        System.out.print("Enter title type: ");
        movie.setTitletype(scanner.nextLine());

        System.out.print("Enter primary title: ");
        movie.setPrimarytitle(scanner.nextLine());

        System.out.print("Enter original title: ");
        movie.setOriginaltitle(scanner.nextLine());

        System.out.print("Enter adult (true/false): ");
        movie.setIsadult(Boolean.valueOf(scanner.nextLine()));

        System.out.print("Enter start year: ");
        movie.setStartyear(Integer.valueOf(scanner.nextLine()));

        System.out.print("Enter end year: ");
        movie.setEndyear(Integer.valueOf(scanner.nextLine()));

        System.out.print("Enter runtime minutes: ");
        movie.setRuntimeminutes(Integer.valueOf(scanner.nextLine()));

        System.out.print("Enter genre 1: ");
        String genre1 = scanner.nextLine();

        System.out.print("Enter genre 2: ");
        String genre2 = scanner.nextLine();

        System.out.print("Enter genre 3: ");
        String genre3 = scanner.nextLine();

        movie.setGenres(new String[] { genre1, genre2, genre3 });

        try {
            db.addMovie(movie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createPerson(DBSQL db) {
        User user = new User();
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter PersonID: ");
        user.setPersonID(scanner.nextLine());

        System.out.print("Enter name: ");
        user.setPrimaryName(scanner.nextLine());

        System.out.print("Enter birth year: ");
        user.setBirthYear(scanner.nextInt());
        scanner.nextLine(); // consume the remaining newline character

        //todo fix DeathYear er Strings her men INTEGER senere
        System.out.print("Enter death year (or leave blank if not applicable): ");
        String deathYear = scanner.nextLine();
        if (!deathYear.isEmpty()) {
            user.setDeathYear(Integer.parseInt(deathYear));
        }

        System.out.print("Enter profession 1: ");
        String profession1 = scanner.nextLine();

        System.out.print("Enter profession 2: ");
        String profession2 = scanner.nextLine();

        user.setProfession(new String[] { profession1, profession2 });


        System.out.print("Enter Known for titles (tconst1) ");
        String tconst1 = scanner.nextLine();

        System.out.print("Enter Known for titles (tconst2) ");
        String tconst2 = scanner.nextLine();

        System.out.print("Enter Known for titles (tconst3) ");
        String tconst3 = scanner.nextLine();

        System.out.print("Enter Known for titles (tconst4) ");
        String tconst4 = scanner.nextLine();

        user.setKnownForTitles(new String[] { tconst1, tconst2,tconst3,tconst4 });

        db.addUser(user);
    }
}