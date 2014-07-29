/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

/**
 *
 * @author Administrador
 */

import entidades.Presupuesto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorPresupuesto {

    public static ArrayList<Presupuesto> buscarPresupuesto(String fechaDesde, String fechaHasta) {
        ArrayList<Presupuesto> listaPresupuesto = new ArrayList();
        
        String sql = "SELECT * FROM presupuesto WHERE VIGENPRESUPUESTO BETWEEN ? and ? order by VIGENPRESUPUESTO DESC";

        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setString(1, fechaDesde);
            pst.setString(2, fechaHasta);
            ResultSet resultSet = pst.executeQuery();

           while (resultSet.next()) {
                Presupuesto presupuesto = new Presupuesto();
                    presupuesto.setVigenciaDePresupuesto((resultSet.getDate("VIGENPRESUPUESTO")));
                    presupuesto.setIdCliente(resultSet.getInt("IDCLIENTE"));
                    presupuesto.setIdPresupuesto(resultSet.getInt("IDPRESUPUESTO"));
                    presupuesto.setIdVendedor(resultSet.getInt("IDUSU"));
                    presupuesto.setRelVenta(resultSet.getInt("IDVENTA"));
                listaPresupuesto.add(presupuesto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("no se pudo buscar presupuesto");
        }
        return listaPresupuesto;
    } 
    
    public static ArrayList<Presupuesto> buscarPresupuesto(int codigo){ //para que el EMA se ponga contento
        ArrayList<Presupuesto> listaPresupuesto = new ArrayList();
        
        String sql = "SELECT * FROM presupuesto WHERE IDPRESUPUESTO = ?";
        
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setInt(1, codigo);
            ResultSet resultSet = pst.executeQuery();

           while (resultSet.next()) {
                Presupuesto presupuesto = new Presupuesto();
                    presupuesto.setVigenciaDePresupuesto((resultSet.getDate("VIGENPRESUPUESTO")));
                    presupuesto.setIdCliente(resultSet.getInt("IDCLIENTE"));
                    presupuesto.setIdPresupuesto(resultSet.getInt("IDPRESUPUESTO"));
                    presupuesto.setIdVendedor(resultSet.getInt("IDUSU"));
                    presupuesto.setRelVenta(resultSet.getInt("IDVENTA"));
                listaPresupuesto.add(presupuesto);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("no se pudo buscar presupuesto");
        }
        return listaPresupuesto;
    }

    public static boolean eliminarPresupuesto(int valorCelda) {
        boolean ok = false;
        String sql1 = "DELETE FROM `abracasoftdb`.`relation_168` WHERE `IDPRESUPUESTO` = ?";
        String sql2 = "DELETE FROM `abracasoftdb`.`presupuesto` WHERE `IDPRESUPUESTO`=?";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql1);
            pst.setInt(1, valorCelda);
            pst.executeUpdate();
            
            pst = Conexion.conectar().prepareStatement(sql2);
            pst.setInt(1, valorCelda);
            pst.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el presupuesto");
            ok = false;
        }
        return ok;
    }

    public static boolean modificarPresupuesto(String nuevaVigencia, int valorCelda) {
        boolean ok = false;
        
        String sql = "UPDATE presupuesto SET VIGENPRESUPUESTO = ? WHERE IDPRESUPUESTO = ?";
        
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setString(1,nuevaVigencia);
            pst.setInt(2, valorCelda);
            pst.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            System.out.println("No se pudo modificar el presupuesto");
            ok = false;
        }
        return ok;
    }
    
    public static int agregarPresupuesto(int codiCli, String vigencia) {
        int nuevoPresupuesto = 0;
        String sql = "insert into presupuesto (IDCLIENTE, VIGENPRESUPUESTO) values (?,?)";
        String sql2 = "SELECT max(IDPRESUPUESTO) as id FROM presupuesto";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setInt(1,codiCli);
            pst.setString(2, vigencia);
            pst.executeUpdate();
            
            pst = Conexion.conectar().prepareStatement(sql2);
            ResultSet resultado = pst.executeQuery();
            if (resultado.next()) {
                nuevoPresupuesto = resultado.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo agregar el presupuesto");
        }
        return nuevoPresupuesto;
    }
    
    public static int agregarPresupuesto(String vigencia) {
        int nuevoPresupuesto = 0;
        String sql = "insert into presupuesto (VIGENPRESUPUESTO) values (?)";
        String sql2 = "SELECT max(IDPRESUPUESTO) as id FROM presupuesto";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setString(1, vigencia);
            pst.executeUpdate();
            
            pst = Conexion.conectar().prepareStatement(sql2);
            ResultSet resultado = pst.executeQuery();
            if (resultado.next()) {
                nuevoPresupuesto = resultado.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo agregar el presupuesto");
        }
        return nuevoPresupuesto;
    }
    
    public static boolean productoPresupuesto(int codPresu, long codProd, int cantidad, float precio) {
        boolean ok = false;
        
        String sql = "insert into relation_168 (IDPRESUPUESTO,IDPRODUCTO,CANTIDAD,PRECIOVENTA) values (?,?,?,?)";
        
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setInt(1,codPresu);
            pst.setLong(2, codProd);
            pst.setInt(3, cantidad);
            pst.setFloat(4, precio);
            pst.executeUpdate();
            ok=true;
        } catch (SQLException e) {
            System.out.println("No se pudo agregar el presupuesto");
        }
        return ok;
    }
    
    public static boolean presupuestoAVenta(int idVenta, int idPresupuesto){
        boolean ok = false;
        String sql = "update presupuesto set IDVENTA = ? where idpresupuesto=?";
        
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setInt(1,idVenta);
            pst.setInt(2, idPresupuesto);
            pst.executeUpdate();
            return ok = true;
        }catch (SQLException e){
            System.out.println("Fallo presupuestoAVenta");
        }
        
        return ok;
    }
}
