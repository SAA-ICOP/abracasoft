/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import entidades.Privilegio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ema
 */
public class GestorPrivilegio {

    public static boolean altaPrivilegioDeUsuarioEnBD(int idusuario, int idprivilegio) {
        boolean resultado = false;
        PreparedStatement pst = null;
        String sql = "INSERT INTO relation_582 (IDUSU,IDPRIVILEGIO) VALUES(?,?)";
        try {
            pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
            pst.setInt(1, idusuario);
            pst.setInt(2, idprivilegio);
            resultado = pst.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            resultado = false;
        }
        return resultado;
    }

    public static ArrayList<Privilegio> listarPrivilegiosDB() {

        ArrayList<Privilegio> listaPrivilegio = new ArrayList<Privilegio>();
        String sql = "SELECT * FROM privilegio";
        try {
            PreparedStatement pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Privilegio privilegio = new Privilegio();
                privilegio.setID(resultSet.getInt("IDPRIVILEGIO"));
                privilegio.setDescripcionDePrivilegio(resultSet.getString("DESCPRIVILEGIO"));
                listaPrivilegio.add(privilegio);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.toString());
        }
        return listaPrivilegio;
    }

}
