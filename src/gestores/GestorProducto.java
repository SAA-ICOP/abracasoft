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

    //Consejo el metodo tiene que recibir un "producto" no los campos en individual. 
    //El metodo tiene que devolver un int para poder utilizarlo para devolver un msj de que se cargo correctamente.
    public static boolean agregarProducto(long CodigoBarra, String Descripcion, float Precio, int Stock) {
        boolean ok = false;
        String sql = "INSERT INTO producto (IDPRODUCTO,NOMPRODUCTO,PRECIOUNITARIO,STOCK) VALUES (?,?,?,?)";
        //Consejo esto no es mas rapido.
        long cod = CodigoBarra;
        String descrip = Descripcion;
        int cantidad = Stock;
        float precio = Precio;
        if (cod > 0 && precio > 0 && cantidad >= 0 && descrip != "") {
            try {
                PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
                pst.setLong(1, cod);
                pst.setString(2, descrip);
                pst.setFloat(3, precio);
                pst.setInt(4, cantidad);
                pst.executeUpdate(); //El executeUpdate devuelve 1 si anduvo, lo guardas en un campo auxiliar y lo retornas.
                ok = true;
            } catch (SQLException e) {
                System.out.println(e);
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
                Producto producto = new Producto(resultSet.getLong("IDPRODUCTO"), resultSet.getString("NOMPRODUCTO"), 
                        resultSet.getFloat("PRECIOCONTADO"), resultSet.getFloat("PRECIO2"), resultSet.getFloat("PRECIO3"), 
                        resultSet.getInt("STOCK"));

                listaProducto.add(producto);

            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }

        return listaProducto;
    }

    public static Producto ConsultaProducto(long CodigoBarra) { //Método para buscar por código de barra (usado en la pantalla "MenuDeGestionDeProd"

        String sql = "SELECT * FROM producto WHERE IDPRODUCTO = " + CodigoBarra;
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) { //cuando la consulta no da vacia pasa por acá
                Producto productoEncontrado = new Producto(resultSet.getLong("IDPRODUCTO"), resultSet.getString("NOMPRODUCTO"), 
                        resultSet.getFloat("PRECIOCONTADO"), resultSet.getFloat("PRECIO2"), resultSet.getFloat("PRECIO3"), 
                        resultSet.getInt("STOCK"));
                return productoEncontrado;
            } else { //si la consulta SQL no encuentra resultados carga un "producto" que avisa que no se ha encontrado nada con el código ingresado
                Producto productoEncontrado = new Producto(0, "No se encontró ningún producto con ese código", 0, 0, 0, 0);
                return productoEncontrado;
            }
        } catch (Exception e) {
            Producto productoEncontrado = new Producto(0, "Hubo un problema, consulte con el Administrador", 0, 0, 0, 0);
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
                Producto producto = new Producto(resultSet.getLong("IDPRODUCTO"), resultSet.getString("NOMPRODUCTO"), 
                        resultSet.getFloat("PRECIOCONTADO"), resultSet.getFloat("PRECIO2"), resultSet.getFloat("PRECIO3"), 
                        resultSet.getInt("STOCK"));
                listaProductoEncontrado.add(producto);
            }
        } catch (SQLException e) {
            Producto productoEncontrado = new Producto(0, "Hubo un problema, consulte con el Administrador", 0, 0, 0, 0);
            listaProductoEncontrado.add(productoEncontrado);
        }
        return listaProductoEncontrado;
    }

    public static long utlimoProducto() { // este método está al dope, lo hice por error y lo dejo por las dudas.
        long ID = 0;
        String sql = "SELECT max(IDPRODUCTO) as id FROM producto";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            ResultSet resultado = pst.executeQuery();
            if (resultado.next()) {
                ID = resultado.getLong("id");
            }
            System.out.println(ID);
            return ID;

        } catch (SQLException e) {
            System.out.println(e);
            return ID;
        }
    }

    public static boolean actualizarPrecio(long codProd, int precioACambiar, float importe) {
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
        long cod = codProd;
        float valor = importe;
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            //pst.setString(1, precio);
            pst.setFloat(1, valor);
            pst.setLong(2, cod);
            pst.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error al ejecutar el SQL");
        }
        return ok;
    }
    
    public static ArrayList<Object> presupuestoProducto(long codigo){
        ArrayList<Object> presupuestoProducto = new ArrayList();
        
        String sql = "select producto.IDPRODUCTO, producto.NOMPRODUCTO, relation_168.CANTIDAD, relation_168.PRECIOVENTA from relation_168, producto where IDPRESUPUESTO = ? and relation_168.IDPRODUCTO = producto.IDPRODUCTO";
        
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setLong(1, codigo);
            ResultSet resultSet = pst.executeQuery();

           while (resultSet.next()) {
                Object [] detalle = { resultSet.getLong("IDPRODUCTO"),
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

    public static boolean eliminarProducto(long valorCelda) {
        boolean ok = false;
        String sql1 = "DELETE FROM `abracasoftdb`.`relation_168` WHERE `IDPRODUCTO` = ?";
        String sql2 = "DELETE FROM `abracasoftdb`.`producto` WHERE `IDPRODUCTO`=?";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql1);
            pst.setLong(1, valorCelda);
            pst.executeUpdate();
            
            pst = Conexion.conectar().prepareStatement(sql2);
            pst.setLong(1, valorCelda);
            pst.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el producto");
            ok = false;
        }
        return ok;
    }

    public static boolean modificarProducto(long valorCelda, String descripcion, int stock, float pcontado, float pdebito, float pcredito) {
        boolean ok = false;
        String sql = "UPDATE producto SET NOMPRODUCTO = ?, Stock = ?, PrecioContado = ?, precio2 = ?, precio3 = ? WHERE IDPRODUCTO = ?";
        
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setString(1,descripcion);
            pst.setInt(2, stock);
            pst.setFloat(3, pcontado);
            pst.setFloat(4, pdebito);
            pst.setFloat(5, pcredito);
            pst.setLong(6, valorCelda);
            pst.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            System.out.println("No se pudo modificar el producto");
            ok = false;
        }
        return ok;
    }
}
