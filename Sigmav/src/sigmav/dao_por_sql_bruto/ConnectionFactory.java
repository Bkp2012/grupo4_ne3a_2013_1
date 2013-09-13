/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fernando
 */
public class ConnectionFactory {
   
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/Sigmav?user=root";
    
    public static Connection preparedConnection() throws SQLException {
        
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection con = DriverManager.getConnection(JDBC_URL);
        con.setAutoCommit(true);
        
        return con;        
    }
    
    public static  Connection preparedConnectionTransaction() throws SQLException {

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection con = DriverManager.getConnection(JDBC_URL);
        con.setAutoCommit(false);
        return con;
    }

}
