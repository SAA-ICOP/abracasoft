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
        String sql = "DELETE FROM `abracasoftdb`.`presupuesto` WHERE `IDPRESUPUESTO`=?";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setInt(1, valorCelda);
            pst.executeUpdate();
            ok = true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el presupuesto");
            ok = false;
        }
        return ok;
    }
}
