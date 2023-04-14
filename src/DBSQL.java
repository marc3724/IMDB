import java.sql.*;

public class DBSQL {

    private static Connection connection;


    public static Connection connectToDatabase(){
        String url = "jdbc:sqlserver://localhost:1234;databaseName=IMDB;encrypt=true;trustServerCertificate=true;";
        String username = "sa";
        String password = "1234";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //search functions

    public void searchMovie(String movieTitle) {
        connectToDatabase();
        String searchMovieTitleSQL = "{call searchMovie(?)}";
        try {
            CallableStatement searchMovieTitleStatement = connection.prepareCall(searchMovieTitleSQL);

            searchMovieTitleStatement.setString(1, "%" + movieTitle + "%");

            ResultSet movieResults = searchMovieTitleStatement.executeQuery();
            while (movieResults.next()) {
//TODO add if statement that only souts 1 of the titles if they are both the same
                System.out.println(movieResults.getString("PrimaryTitle") + ", " + movieResults.getString("OrignialTitle"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public void searchPerson(String personName) {
        connectToDatabase();
                                  //here the procedure or "routine" is called, if needed replace ? with '"+name+"'
        String searchPersonSQL = "{call searchPerson(?)}";
        try {
            CallableStatement searchPersonStatement = connection.prepareCall(searchPersonSQL);

            searchPersonStatement.setString(1, "%" + personName + "%");
            ResultSet personResults = searchPersonStatement.executeQuery();
            while (personResults.next()) {
                System.out.println(personResults.getString("primaryName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public void deleteMovie(String movieId)  {
        connectToDatabase();
        try {
            CallableStatement stmt = connection.prepareCall("{CALL deleteMovie(?)}");
            stmt.setObject(1, movieId);
            stmt.executeUpdate();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
    }


    //------------------------------------------------------------------------------------------------------------------
    //add functions
    public void addMovie(Movie movie) throws SQLException {
        connectToDatabase();
        String sql = "INSERT INTO IMDB.dbo.Movies (MovieID,TitleType, PrimaryTitle, OrignialTitle, Foradult, StartYear, EndYear, RunTimeMinutes) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, movie.getMovieIDt());
        stmt.setString(2, movie.getTitletype());
        stmt.setString(3, movie.getPrimarytitle());
        stmt.setString(4, movie.getOriginaltitle());
        stmt.setBoolean(5, movie.isIsadult());
        stmt.setInt(6, movie.getStartyear());
        stmt.setInt(7, movie.getEndyear());
        stmt.setInt(8, movie.getRuntimeminutes());
       /* stmt.setString(9, movie.getGenres()[0]);
        stmt.setString(10, movie.getGenres()[1]);
        stmt.setString(11, movie.getGenres()[2]);*/
        stmt.executeUpdate();
    }
    public void addgenre(Movie movie) throws SQLException {

    }


    public void addUser(Person user) {
        try {
            connectToDatabase();

            // Create a prepared statement to insert the user into the database
            String sql = "INSERT INTO IMDB.dbo.People (PersonID, PrimaryName, BirthYear, DeathYear) " +
                    //",primaryProfession1, primaryProfession2, knownForTitles1, knownForTitles2, knownForTitles3, knownForTitles4)" +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            //Statement stmt2 = connection.createStatement(sql);
            stmt.setString(1, user.getPersonID());
            stmt.setString(2, user.getPrimaryName());
            stmt.setInt(3, user.getBirthYear());
            stmt.setObject(4, user.getDeathYear(), Types.INTEGER);
            /*//TODO make it so you can input null, sql doesn't allow it
            if (user.getDeathYear() != null) {
                System.out.println("not null");
                stmt.setNull(4, user.getDeathYear());
            }*/

            /*stmt.setString(5, user.getPrimaryProfession().length > 0 ? user.getPrimaryProfession()[0] : "");
            stmt.setString(6, user.getPrimaryProfession().length > 1 ? user.getPrimaryProfession()[1] : "");
            stmt.setString(7, user.getKnownForTitles().length > 0 ? user.getKnownForTitles()[0] : "");
            stmt.setString(8, user.getKnownForTitles().length > 1 ? user.getKnownForTitles()[1] : "");
            stmt.setString(9, user.getKnownForTitles().length > 2 ? user.getKnownForTitles()[2] : "");
            stmt.setString(10, user.getKnownForTitles().length > 3 ? user.getKnownForTitles()[3] : "");*/

            // Execute the prepared statement
            stmt.executeUpdate();

            // Close the statement and connection
            stmt.close();
            closeConnection();

            System.out.println("User added successfully.");
        } catch (SQLException ex) {
            System.out.println("Error adding user: " + ex.getMessage());
        }
    }


                    //bulk add attempt



    //------------------------------------------------------------------------------------------------------------------




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
