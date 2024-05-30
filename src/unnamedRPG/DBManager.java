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
import java.util.logging.Level;
import java.util.logging.Logger;
import unnamedRPG.loginModule.LoginController;

public final class DBManager {

    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    private static final String URL = "jdbc:derby:Game_EDB; create=true";
    
    
    Connection conn;

    public DBManager() {
        establishConnection();
    }


    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection
    public void establishConnection() {
        try {
            this.conn = DriverManager.getConnection(URL);
            System.out.println(URL + " Connected.");
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12), score INT)");
            }
            statement.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger("SQL Exception: " + ex.getMessage());
        }    
    }


    public boolean checkUser(String username, String password) {
        boolean userCheck = false;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password, score FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");
                if (password.compareTo(pass) == 0) {
//                    score = rs.getInt("score");
                    userCheck = true;
                } else {
                    userCheck = false;
                }
            } else {
                System.out.println("no such user");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "', '" + password + "', 0)");
                userCheck = true;
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex);
        }
        return userCheck;
    }


    
    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {

            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            //Statement dropStatement=null;
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }
    
}

//
//    public void closeConnections() {
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException ex) {
//                System.out.println("Couldn't close connection " + ex.getMessage());
//            }
//        }
//    }
//
//    public ResultSet queryDB(String sql) {
//
//        Connection connection = this.conn;
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(sql);
//
//        } catch (SQLException ex) {
//            System.out.println("3 " + ex.getMessage());
//        }
//        return resultSet;
//    }
//
//    public void updateDB(String sql) {
//
//        Connection connection = this.conn;
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            statement = connection.createStatement();
//            statement.executeUpdate(sql);
//
//        } catch (SQLException ex) {
//            System.out.println("4 " + ex.getMessage());
//        }
//    }
//    
//    // SQL query searching all schemas for tables with name matching tableName.
//    // If exists, it's appended to ResultSet tableCheck before being deleted.
//    public void handleExistingTable(String tableName){
//        Connection connection = this.conn;
//        
//        try{
//            DatabaseMetaData metaData = connection.getMetaData();
//            ResultSet tableCheck = metaData.getTables(null, null, tableName, null);
//            
//            if(tableCheck.next()){
//                String dropTable = "DROP TABLE " + tableName;
//                updateDB(dropTable);
//                System.out.println("Existing table " +tableName+ " deleted.");
//            }
//            
//            
//            tableCheck.close();
//        }catch (SQLException ex){
//            System.out.println("Error in deleting existing table. " + ex.getMessage());
//        } 
//    }
//    
//    public void dbSetup() {
//        try {
//            conn = DriverManager.getConnection(url, dbusername, dbpassword);
//            Statement statement = conn.createStatement();
//            String tableName = "UserInfo";
//
//            if (!checkTableExisting(tableName)) {
//                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12), score INT)");
//            }
//            //statement.executeUpdate("INSERT INTO " + tableName + " VALUES('Fiction',0),('Non-fiction',10),('Textbook',20)");
//            statement.close();
//        } catch (Throwable e) {
//            System.out.println("dbSetup error" + e.getMessage());
//
//        }
//    }