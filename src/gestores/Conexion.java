/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ema
 */
public class Conexion {

    private static Connection conexion = null;

    public static Connection conectar() {

        if (conexion == null) {

            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception e) {

                System.out.println("Exception: " + "no se pudo registrar el driver");
                System.out.println("Error\n" + e.getMessage());
                return null;
            }
            try {

                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/abracasoftdb", "root", "admin");
                
            } catch (SQLException e) {

                System.out.println("SQLException: " + e.getMessage());
                return null;
            }
        }

        return conexion;

    }
}
