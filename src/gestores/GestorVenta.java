/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import entidades.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class GestorVenta {
        public static ArrayList<Venta> cuentaVentaCliente(int idCliente){
        ArrayList<Venta> cuentaVentaCliente = new ArrayList();
        
        String sql1 = "SELECT montoventa, fechaventa FROM venta,presupuesto WHERE venta.idpresupuesto = "
                + "presupuesto.idpresupuesto and presupuesto.idcliente = ? order by fechaventa desc";

        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql1);
            pst.setInt(1, idCliente);
            ResultSet resultSet = pst.executeQuery();

           while (resultSet.next()) {
                Venta ventaCliente = new Venta(resultSet.getDate("FECHAVENTA"),
                        resultSet.getFloat("MONTOVENTA"));
                cuentaVentaCliente.add(ventaCliente);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("no se pudo buscar VentasClientes");
        }
        return cuentaVentaCliente;
    }
}
