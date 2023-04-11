import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSQL {

    private static Connection connection;

    public static void main(String[] args) {
        connectToDatabase();
    }

    public static Connection connectToDatabase(){
        String url = "jdbc:sqlserver://localhost:1434";
        String user = "sa";
        String password = "1234";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("maybe connect");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /*public void indsæt(){

        String sql = "INSERT INTO EXercise1.dbo.Customers"
    }*/
}
