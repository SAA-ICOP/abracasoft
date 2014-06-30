/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import entidades.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ema
 */
public class GestorProducto {
    
    public static void agregarProducto(Producto producto){
    String sql = "INSERT INTO producto (IDPRODUCTO,NOMPRODUCTO,PRECIOUNITARIO,STOCK) VALUES (?,?,?,?)";
    int cod = producto.getCodigoDeProducto();
    String descrip = producto.getNombreProducto();
    int cantidad = producto.getStockProducto();
    float precio = producto.getPrecioUnitario();
        if (cod>0 && precio>0 && cantidad >= 0 && descrip!=""){
            try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setInt(1, cod);
            pst.setString(2, descrip);
            pst.setFloat(3, precio);
            pst.setInt(4, cantidad);
            pst.executeUpdate();

            }catch (SQLException e) {
                System.out.println(e);
                System.out.println("Error al ejecutar el SQL");
            }
        }else{
            System.out.println("con los datos ingresados no se puede agregar un nuevo producto");
        }
    }

    public static ArrayList<Producto> listarProductosDB() {//Método para que se listen los productos en la pantalla "MenuDeGestionDeProd"

        ArrayList<Producto> listaProducto = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Producto producto = new Producto(resultSet.getInt("IDPRODUCTO"),
                        resultSet.getString("NOMPRODUCTO"), resultSet.getInt("PRECIOUNITARIO"), resultSet.getInt("STOCK"));

                listaProducto.add(producto);

            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }

        return listaProducto;
    }

    public static Producto ConsultaProducto(int CodigoBarra) { //Método para buscar por código de barra (usado en la pantalla "MenuDeGestionDeProd"

        String sql = "SELECT * FROM producto WHERE IDPRODUCTO = " + CodigoBarra;
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) { //cuando la consulta no da vacia pasa por acá
                Producto productoEncontrado = new Producto(resultSet.getInt("IDPRODUCTO"), resultSet.getString("NOMPRODUCTO"), resultSet.getInt("PRECIOUNITARIO"), resultSet.getInt("STOCK"));
                return productoEncontrado;
            } else { //si la consulta SQL no encuentra resultados carga un "producto" que avisa que no se ha encontrado nada con el código ingresado
                Producto productoEncontrado = new Producto(0, "No se encontró ningún producto con ese código", 0, 0);
                return productoEncontrado;
            }
        } catch (Exception e) {
            Producto productoEncontrado = new Producto(0, "Hubo un problema, consulte con el Administrador", 0, 0);
            return productoEncontrado;
        }
    }
    public static ArrayList<Producto> ConsultaPorDescripcion(String Descripcion) { //Método para buscar por descripcion (usado en la pantalla "MenuDeGestionDeProd"
        ArrayList<Producto> listaProductoEncontrado = new ArrayList<>();
        String Texto = "%" + Descripcion + "%";
        String sql = "SELECT * FROM producto WHERE NOMPRODUCTO like ?";

        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setString(1, Texto);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Producto producto = new Producto(resultSet.getInt("IDPRODUCTO"),resultSet.getString("NOMPRODUCTO"), resultSet.getInt("PRECIOUNITARIO"), resultSet.getInt("STOCK"));
                listaProductoEncontrado.add(producto);
            }
        } catch (SQLException e) {
            Producto productoEncontrado = new Producto(0, "Hubo un problema, consulte con el Administrador", 0, 0);
            listaProductoEncontrado.add(productoEncontrado);
            //return listaProductoEncontrado;
        }
        return listaProductoEncontrado;
    }    
}
