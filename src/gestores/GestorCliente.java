/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
        public static ArrayList<Cliente> listarClientesDB() {//Método para que se listen los productos en la pantalla "MenuDeGestionDeProd"

        ArrayList<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) { //int dniCuilCuit, String mailCliente
                Cliente cliente = new Cliente(resultSet.getInt("IDCLIENTE"),
                        resultSet.getString("NOMCLIENTE"),
                        resultSet.getString("DIRCLIENTE"), resultSet.getInt("CODIGOPOSTAL"), 
                        resultSet.getInt("TELCLIENTE"),resultSet.getInt("DNICLIENTE"),
                        resultSet.getString("MAILCLIENTE"));

                listaCliente.add(cliente);

            }
        } catch (SQLException e) {
            System.out.print(e.toString());
        }

        return listaCliente;
    }
        
    public static ArrayList<Cliente> ConsultaPorDescripcion(String Descripcion) { //Intento de busqueda predictiva
        ArrayList<Cliente> listaClienteEncontrado = new ArrayList<>();
        String Texto = "%" + Descripcion + "%";
        String sql = "SELECT * FROM cliente WHERE NOMCLIENTE like ?";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setString(1, Texto);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente(resultSet.getInt("IDCLIENTE"),
                        resultSet.getString("NOMCLIENTE"),
                        resultSet.getString("DIRCLIENTE"), resultSet.getInt("CODIGOPOSTAL"), 
                        resultSet.getInt("TELCLIENTE"),resultSet.getInt("DNICLIENTE"),
                        resultSet.getString("MAILCLIENTE"));
                listaClienteEncontrado.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("No se pudo efectuar la busqueda por descripcion en cliente");
        }
        return listaClienteEncontrado;
    }

    public static boolean eliminarCliente(int valorCelda) {
        boolean ok = false;
        String sql = "DELETE FROM `abracasoftdb`.`cliente` WHERE `IDCLIENTE`=?";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setInt(1, valorCelda);
            pst.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el cliente");
            ok = false;
        }
        return ok;
    }   

    public static boolean modificarCliente(int valorCelda, String nombre, String direccion, String email, int cp, int tel, int dni) {
        boolean ok = false;
        String sql = "UPDATE cliente SET CODIGOPOSTAL = ?, NOMCLIENTE = ?, DIRCLIENTE = ?, MAILCLIENTE = ?, "
                + "TELCLIENTE = ?, DNICLIENTE = ? WHERE IDCLIENTE = ?";
        
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setInt(1,cp);
            pst.setString(2, nombre);
            pst.setString(3, direccion);
            pst.setString(4, email);
            pst.setInt(5, tel);
            pst.setInt(6, dni);
            pst.setInt(7, valorCelda);
            pst.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            System.out.println("No se pudo modificar el producto");
            ok = false;
        }
        return ok;
    }
}
