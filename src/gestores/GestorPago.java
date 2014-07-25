/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestores;

import entidades.Pago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class GestorPago {
    public static ArrayList<Pago> cuentaPagoCliente(int idCliente){
        ArrayList<Pago> cuentaPagoCliente = new ArrayList();
        
        String sql1 = "SELECT MONTOPAGO, FECHAPAGO From pago where pago.idcliente = ? order by fechapago desc";

        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql1);
            pst.setInt(1, idCliente);
            ResultSet resultSet = pst.executeQuery();

           while (resultSet.next()) {
               Pago pagoCliente = new Pago();
                pagoCliente.setPagoCliente(resultSet.getFloat("MONTOPAGO"));
                pagoCliente.setFechaPagoCliente(resultSet.getDate("FECHAPAGO"));
                cuentaPagoCliente.add(pagoCliente);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("no se pudo buscar CuentaPagoCliente");
        }
        return cuentaPagoCliente;
    }
    
    public static boolean ingresarPago(int codCli, float pagoRealizado, int tipoPago){
        boolean ok = false;
        String sql = "insert into pago (IDCLIENTE,MONTOPAGO, FECHAPAGO, TIPOPAGO) values (?,?,now(),?)";
        
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setInt(1, codCli);
            pst.setFloat(2, pagoRealizado);
            pst.setInt(3, tipoPago);
            pst.executeUpdate();
            ok=true;
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el pago");
        }
        return ok;
    }
}
