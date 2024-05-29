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

public final class DBManager {

    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    private static final String URL = "jdbc:derby:BookStoreDB_Ebd; create=true";
    
    
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
        } catch (SQLException ex) {
            Logger.getLogger("SQL Exception: " + ex.getMessage());
        }    
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Couldn't close connection " + ex.getMessage());
            }
        }
    }

    public ResultSet queryDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("3 " + ex.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("4 " + ex.getMessage());
        }
    }
    
    // SQL query searching all schemas for tables with name matching tableName.
    // If exists, it's appended to ResultSet tableCheck before being deleted.
    public void handleExistingTable(String tableName){
        Connection connection = this.conn;
        
        try{
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tableCheck = metaData.getTables(null, null, tableName, null);
            
            if(tableCheck.next()){
                String dropTable = "DROP TABLE " + tableName;
                updateDB(dropTable);
                System.out.println("Existing table " +tableName+ " deleted.");
            }
            
            
            tableCheck.close();
        }catch (SQLException ex){
            System.out.println("Error in deleting existing table. " + ex.getMessage());
        }
                
                
        
    }

}
