import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    menu();

    }

    public static void menu (){
        int valg=1;
        Scanner input = new Scanner(System.in);
        DBSQL db = new DBSQL();
        db.connectToDatabase();

        while(valg!=0) {
            System.out.println("1. search for a movie");
            System.out.println("2. search for a person ");
            /*
            System.out.println("3. Tildel studerende nyt fag ");
            System.out.println("4. Udskriv stamdata em en studerende ");
            System.out.println("5. Udskriv alle oplysninger om alle studerende ");
            System.out.println("6. Udskriv alle oplysninger om en studerende ");
            System.out.println("7. Søg alle der har et givet fag ");
            System.out.println("8. Opdater studerendes klasse ");
            System.out.println("9. Slet studerende ");
            System.out.println("0. Stop programmet");
            */
            valg=input.nextInt();
            switch(valg){
                case 1://need data in database to work
                    System.out.println("write the name of the movie your looking for");
                    db.searchMovie();

                    break;
                case 2://need data in database to work
                    System.out.println("write the name of the person your looking for");
                    db.searchPerson(input.next());
            }
        }


    }
}
