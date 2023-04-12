import java.sql.*;

public class DBSQL {

    private static Connection connection;

    public static void main(String[] args) {
        connectToDatabase();
    }

    public static Connection connectToDatabase(){
        String url = "jdbc:sqlserver://localhost:1434;" +
                "trustServerCertificate=true;" ;
        String user = "sa";
        String password = "1234";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void test() {
        connectToDatabase();

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
