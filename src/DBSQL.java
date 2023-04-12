import java.sql.*;

public class DBSQL {

    private static Connection connection;
//"trustServerCertificate=true;" ;

    public Connection connectToDatabase(){
        String url = "jdbc:sqlserver://localhost:1434;databaseName=IncrediblyMediocreDramaBox;trustServerCertificate=true;";
        String username = "sa";
        String password = "1234";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void searchMovie (){
        String searchMovieTitleSQL = "{call search_Movie_Title(?)}";
        try {
            CallableStatement searchMovieTitleStatement = connection.prepareCall(searchMovieTitleSQL);

            String movieTitle = "The Matrix";
            searchMovieTitleStatement.setString(1, movieTitle);
            ResultSet movieResults = searchMovieTitleStatement.executeQuery();
            while (movieResults.next()) {
                System.out.println(movieResults.getString("title"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchPerson (String name){
        String searchPersonSQL = "{call Search_Person(?)}";
        try {
            CallableStatement searchPersonStatement = connection.prepareCall(searchPersonSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void test() {

        int id = 14;
        String Name = "Marcus";
        int Age = 24;
        String Country = "DK";

        String sql = "INSERT INTO Exercise1.dbo.CUSTOMERS (Name, Age, Country) " +
                "values ('" +Name+"' , '" +Age+"' ,'" +Country+"' )";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            connection.close();
            System.out.println("no fail");

        } catch (SQLException e) {
            System.out.println("statement failed");
            e.printStackTrace();
        }
    }

}
