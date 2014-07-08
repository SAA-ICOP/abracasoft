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
import javax.swing.JOptionPane;

/**
 *
 * @author Ema
 */
public class GestorProducto {

    //Consejo el metodo tiene que recibir un "producto" no los campos en individual. 
    //El metodo tiene que devolver un int para poder utilizarlo para devolver un msj de que se cargo correctamente.
    public static boolean agregarProducto(int CodigoBarra, String Descripcion, float Precio, int Stock) {
        boolean ok = false;
        String sql = "INSERT INTO producto (IDPRODUCTO,NOMPRODUCTO,PRECIOUNITARIO,STOCK) VALUES (?,?,?,?)";
        //Consejo esto no es mas rapido.
        int cod = CodigoBarra;
        String descrip = Descripcion;
        int cantidad = Stock;
        float precio = Precio;
        if (cod > 0 && precio > 0 && cantidad >= 0 && descrip != "") {
            try {
                PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
                pst.setInt(1, cod);
                pst.setString(2, descrip);
                pst.setFloat(3, precio);
                pst.setInt(4, cantidad);
                pst.executeUpdate(); //El executeUpdate devuelve 1 si anduvo, lo guardas en un campo auxiliar y lo retornas.
                ok = true;
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "No se ha podido agregar un nuevo producto");
            }
        } else {
            System.out.println("con los datos ingresados no se puede agregar un nuevo producto");
        }
        return ok;
    }

    public static ArrayList<Producto> listarProductosDB() {//Método para que se listen los productos en la pantalla "MenuDeGestionDeProd"

        ArrayList<Producto> listaProducto = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Producto producto = new Producto(resultSet.getInt("IDPRODUCTO"),
                        resultSet.getString("NOMPRODUCTO"), resultSet.getInt("PRECIOUNITARIO"), 
                        resultSet.getInt("STOCK"));

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
                Producto producto = new Producto(resultSet.getInt("IDPRODUCTO"), resultSet.getString("NOMPRODUCTO"), resultSet.getInt("PRECIOUNITARIO"), resultSet.getInt("STOCK"));
                listaProductoEncontrado.add(producto);
            }
        } catch (SQLException e) {
            Producto productoEncontrado = new Producto(0, "Hubo un problema, consulte con el Administrador", 0, 0);
            listaProductoEncontrado.add(productoEncontrado);
        }
        return listaProductoEncontrado;
    }

    public static int utlimoProducto() { // este método está al dope, lo hice por error y lo dejo por las dudas.
        int ID = 0;
        String sql = "SELECT max(IDPRODUCTO) as id FROM producto";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            ResultSet resultado = pst.executeQuery();
            if (resultado.next()) {
                ID = resultado.getInt("id");
            }
            System.out.println(ID);
            return ID;

        } catch (SQLException e) {
            System.out.println(e);
            return ID;
        }
    }

    public static boolean actualizarPrecio(int codProd, int precioACambiar, float importe) {
        boolean ok = false;
        String precio;
        switch (precioACambiar) {
            case 1:
                precio = "PRECIOCONTADO";
                break;
            case 2:
                precio = "PRECIO2";
                break;
            case 3:
                precio = "PRECIO3";
                break;
            default:
                precio = "error que no debería suceder";
                break;
        }

        String sql = "UPDATE producto SET " + precio + " = ? WHERE IDPRODUCTO = ?"; //? STRING PRECIO, ? FLOAT, ? INT
        int cod = codProd;
        float valor = importe;
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            //pst.setString(1, precio);
            pst.setFloat(1, valor);
            pst.setInt(2, cod);
            pst.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error al ejecutar el SQL");
        }
        return ok;
    }
    
    public static ArrayList<Object> presupuestoProducto(int codigo){
        ArrayList<Object> presupuestoProducto = new ArrayList();
        
        String sql = "select producto.IDPRODUCTO, producto.NOMPRODUCTO, relation_168.CANTIDAD, relation_168.PRECIOVENTA from relation_168, producto where IDPRESUPUESTO = ? and relation_168.IDPRODUCTO = producto.IDPRODUCTO";
        
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setInt(1, codigo);
            ResultSet resultSet = pst.executeQuery();

           while (resultSet.next()) {
                Object [] detalle = { resultSet.getInt("IDPRODUCTO"),
                        resultSet.getString("NOMPRODUCTO"), 
                        resultSet.getInt("CANTIDAD"), resultSet.getFloat("PRECIOVENTA")};
                presupuestoProducto.add(detalle);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("no se pudo buscar presupuesto");
        }
        return presupuestoProducto;
    }
}
