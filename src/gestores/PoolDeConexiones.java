/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource; 
//import org.apache.commons.dbcp.BasicDataSource; 

//↕↕ Puede que les genere problemas, la versión anterior se encuentra comentada abajo

//import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author Ema
 */
public class PoolDeConexiones {

    private static Connection conexion = null;

    public static Connection pedirConexion() {
        
        if (conexion == null){
            try {
            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
            basicDataSource.setUrl("jdbc:mysql://localhost:3306/abracasoftdb");
            basicDataSource.setUsername("root");
            basicDataSource.setPassword("");

            conexion = basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage());

            return null;
        }
        }        
        return conexion;
    }

}
