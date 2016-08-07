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

    public static int altaPrivilegioDeUsuarioEnBD(int idusuario, ArrayList<Privilegio> idprivilegios) throws SQLException {
        int r;
        PreparedStatement pst = null;
        String sql = "INSERT INTO relation_582 (IDUSU,IDPRIVILEGIO) VALUES(?,?)";
            pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
            pst.setInt(1, idusuario);
            for (int i = 0; i < idprivilegios.size(); i++) {
                pst.setInt(2, idprivilegios.get(i).getID());
            }
            r = pst.executeUpdate();
            
        return r;
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

    static int modificarPrivilegiosEnBD(ArrayList<Privilegio> idPrivilegios, int idUsuario) throws SQLException {
        int resultado;
        String sql = "UPDATE relation_582 SET idprivilegio = '?' WHERE idusuario = '?'";
        PreparedStatement pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
        for (int i = 0; i < idPrivilegios.size(); i++) {
            pst.setInt(1, idPrivilegios.get(i).getID());
        }
        pst.setInt(2, idUsuario);
        resultado = pst.executeUpdate();
        return resultado;
    }
    public static ArrayList<Privilegio> listarPrivilegiosPorUsuario(int idUsuario) throws SQLException{
        ArrayList<Privilegio> privilegios = null;
        String sql = "SELECT relation_582.IDPRIVILEGIO FROM relation_582 WHERE relation_582.IDUSU = ?";
        PreparedStatement pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
        ResultSet resulset = pst.executeQuery();
        while (resulset.next()) {            
            Privilegio privilegio = new Privilegio();
            privilegio.setID(resulset.getInt("IDPRIVILEGIO"));
            privilegios.add(privilegio);
        }
        return privilegios;
    }

}
