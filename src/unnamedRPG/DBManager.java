/*
 * The programs are designed for PDC paper
 */
package unnamedRPG;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import unnamedRPG.model.entities.Player;

public final class DBManager {

    private static final String URL = "jdbc:derby:Game_EDB; create=true";
    
    public String playerName = "";
    
    
    Connection conn;

    public DBManager() {
        establishConnection();
    }

    public void updatePlayerName(String name){
        this.playerName = name;
    }
    
    public Connection getConnection() {
        return this.conn;
    }

    // Establish connection, checking if appropriate structure exists. If not,
    // it creates the structure to support storage and retrieval of player information
    public void establishConnection() {
        try {
            this.conn = DriverManager.getConnection(URL);
            System.out.println(URL + " Connected.");
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExists(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12),"
                        + " existingCharacter BOOLEAN, hp INT, stamina INT, score INT, maxScore INT)");
            }
            statement.close();  
        } catch (SQLException ex) {
            System.out.println("SQL Exception establishConnection: " + ex);
        }    
    }
    
    public Player getPlayerChar() throws SQLException{
        Player playerChar = new Player("");
        ResultSet resultSet = queryDB("SELECT * FROM APP.USERINFO WHERE USERID = " + "'" + playerName + "'");

        Statement statement = conn.createStatement();
        
        while(resultSet.next()){
            System.out.println("QueryResult: " +  resultSet.getInt("SCORE"));
            if(resultSet.getBoolean("existingCharacter")){
                System.out.println("Character exists.\nLoading character.");
                int hp = resultSet.getInt("HP");
                int stamina = resultSet.getInt("STAMINA");
                int score = resultSet.getInt("SCORE");
                int maxScore = resultSet.getInt("MAXSCORE");
                playerChar.setStats(hp, stamina, score, maxScore);
            } else {
                System.out.println("Creating new character");
                String query = "UPDATE UserInfo SET EXISTINGCHARACTER = true WHERE USERID = 'seb'";
                updateDB(query);
            }
        }
        statement.close();
        return playerChar;
    }
    
    public void savePlayerStats(int hp, int stamina, int score, int maxScore) throws SQLException{
        String query = "UPDATE UserInfo SET EXISTINGCHARACTER = true, HP = " 
                + hp +", STAMINA =" + stamina +", SCORE =" + score + ", MAXSCORE =" + stamina + " WHERE USERID = "+ "'" + playerName + "'";
        updateDB(query);
    }

    public ResultSet queryDB(String sql) {

        Connection connection = this.conn;
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("SQL Exception queryDB: " + ex);
        }
        return resultSet;
    }

    public void updateDB(String sql) {

        Connection connection = this.conn;
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("SQL Exception updateDB: " + ex);
        }
    }
    
    private boolean checkTableExists(String newTableName) {
        boolean exists = false;
        try {
            System.out.println("Checking if table exists");
            DatabaseMetaData dbMetaData = conn.getMetaData();
            ResultSet resultSetMetaData = dbMetaData.getTables(null, null, null, null);
            while (resultSetMetaData.next()) {
                String tableName = resultSetMetaData.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + " exists");
                    exists = true;
                }
            }
            if (resultSetMetaData != null) {
                resultSetMetaData.close();
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception checkTableExists: " + ex);
        }
        return exists;
    }
    
    // UserLogin
    public boolean manageUserLogin(String username, String password) {
        boolean userCheck = false;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("User exists.");
                if (password.compareTo(pass) == 0) {
                    userCheck = true;
                } else {
                    userCheck = false;
                }
            } else {
                String query = ("INSERT INTO UserInfo (userid, password, existingCharacter) VALUES ('" 
                        + username + "', '" + password + "', false)");
                System.out.println("No such user.");
                System.out.println("Creating new user.");
                statement.executeUpdate(query);
                userCheck = true;
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception manageUserLogin: " + ex);
        }
        return userCheck;
    }
}