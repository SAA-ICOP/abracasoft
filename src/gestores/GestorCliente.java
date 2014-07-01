/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class GestorCliente {
    public static boolean agregarCliente(String nombreCliente, String direccionCliente, int codigoPostalCliente, int telefonoCliente, int dniCuilCuit, String mailCliente){
        boolean estado = false;
        String sql = "INSERT INTO cliente (CODIGOPOSTAL, NOMCLIENTE, DIRCLIENTE, MAILCLIENTE, TELCLIENTE, DNICLIENTE) VALUES (?,?,?,?,?,?)";
        
        String nombre = nombreCliente;
        String direccion = direccionCliente;
        int codigoPostal = codigoPostalCliente;
        int telefono = telefonoCliente;
        int documento = dniCuilCuit;
        String mail = mailCliente;
        
        if (nombre.trim().length()!=0){
            try {
                PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
                pst.setInt(1, codigoPostal);
                pst.setString(2, nombre);
                pst.setString(3, direccion);
                pst.setString(4, mail);
                pst.setInt(5, telefono);
                pst.setInt(6, documento);
                pst.executeUpdate(); //El executeUpdate devuelve 1 si anduvo, lo guardas en un campo auxiliar y lo retornas.
                estado = true;
            }catch (SQLException e) {
                System.out.println(e);
                System.out.println("Error al ejecutar el SQL en gestorCliente");
                estado = false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "El campo 'nombre' no puede estar vacio");
        }
        return estado;
    }
}
