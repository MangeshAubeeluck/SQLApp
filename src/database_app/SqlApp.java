package database_app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class SqlApp {
	static Logger log = Logger.getLogger(SqlApp.class.getName());
	PreparedStatement pst;
	ResultSet rs;
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\\\Users\\\\maubeeluck\\\\AppData\\\\Roaming\\\\DBeaverData\\\\workspace6\\\\.metadata\\\\sample-database-sqlite-1\\\\Chinook.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    /**
     * select all rows in the warehouses table
     */
    public List<Client> selectAll(){
        String sql = "SELECT * FROM client_data"; // sql query saved in the variable sql
        List<Client> clients = new ArrayList(); // list being saved in the variable clients
        
        try (Connection conn = this.connect();    // 
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql))   
        {
            
            // loop through the result set
            while (rs.next()) {
            	Client cli = new Client(0, sql, null);
            	cli.setId(rs.getLong("id")); // s
            	cli.setName(rs.getString("name"));
            	cli.setAmountDue(rs.getBigDecimal("amountDue"));// setting the amount due of the client
            	clients.add(cli);// appending the client object to the list of clients 

            }
            
            
        } catch (SQLException e) {
            log.info(e.getMessage());
        }
        
        return clients;
    }
    public List<Client> filterAll(){
        String sql = "SELECT * FROM client_data where NOT amountDue <='5' "; // sql query saved in the variable sql
        List<Client> clients = new ArrayList(); // list being saved in the variable clients
        
        try (Connection conn = this.connect();    // 
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql))   
        {
            
            // loop through the result set
            while (rs.next()) {
            	Client cli = new Client(0, sql, null);
            	cli.setId(rs.getLong("id")); // s
            	cli.setName(rs.getString("name"));
            	cli.setAmountDue(rs.getBigDecimal("amountDue"));// setting the amount due of the client
            	clients.add(cli);// appending the client object to the list of clients 

            }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return clients;
    }
    
    public List<Client> sortAll(){
        String sql = "SELECT * FROM client_data ORDER BY amountDue DESC "; // sql query saved in the variable sql
        List<Client> clients = new ArrayList(); // list being saved in the variable clients
        try (Connection conn = this.connect();    // 
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql))   
        {
            
            // loop through the result set
            while (rs.next()) {
            	Client cli = new Client(0, sql, null);
            	cli.setId(rs.getLong("id")); // s
            	cli.setName(rs.getString("name"));
            	cli.setAmountDue(rs.getBigDecimal("amountDue"));// setting the amount due of the client
            	clients.add(cli);// appending the client object to the list of clients 

            }
            
            
        } catch (SQLException e) {
            log.info(e.getMessage());
        }
        
        return clients;
    }
       
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SqlApp app = new SqlApp();
          List<Client> clients =app.selectAll() ;
          log.info("all clients from database:"+ clients.toString());
          
          List<Client> clientSort =app.sortAll();
          log.info("all clients sorted in the database:"+ clientSort.toString());
          
          List<Client> clientFilter =app.filterAll();
          log.info("all filtered client:"+ clientFilter.toString());

    }

	

}
