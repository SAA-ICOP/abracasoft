/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Ema
 */
public class GestorUsuario {

    static Date fecha = new Date();

    public static int ingreso(String usuario, String pass) {
        int idUsuario = 0;

        String sql = "SELECT IDUSU FROM usuario WHERE NOMUSUARIO = ? and PASSUSUARIO = ?";

        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, pass);
            ResultSet resultado = pst.executeQuery();

            if (resultado.next()) { //cuando la consulta no da vacia pasa por acá
                idUsuario = resultado.getInt("IDUSU");
                return idUsuario;
            } else { //si la consulta SQL no encuentra resultados devuelve 0
                return idUsuario;
            }

        } catch (Exception e) {
            return idUsuario;
        }
    }

    public static int AltaUsuarioEnBD(Usuario usuario, int[] privilegios) throws SQLException {
        int usuarioGuardado = 0;
        int resultado = 0;
        int ID = 0;
        GestorPrivilegio privilegio = new GestorPrivilegio();
        String sql = "INSERT INTO usuario (NOMUSUARIO,PASSUSUARIO,FECHACREACION)"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setString(1, usuario.getNombreUsuario());
            pst.setInt(2, usuario.getPassUsuario());
            pst.setDate(3, new java.sql.Date(fecha.getTime()));
            usuarioGuardado = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.conectar().close();
        }
        if (usuarioGuardado == 1) {
            ID = consultarIDUsuario();
        }
        if (ID != 0) {
            resultado = privilegio.AltaPrivilegioDeUsuarioEnBD(ID, privilegios);
        }
        return resultado;
    }

    public static void BajaUsuarioEnBD(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void ModificarUsuarioEnBD(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int consultarIDUsuario() throws SQLException {
        int ID;
        String sql = "SELECT MAX(IDUSU) AS IDUSU FROM usuario";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            ResultSet resultado = pst.executeQuery(sql);
            ID = resultado.getInt("IDUSU");
        } catch (SQLException e) {
            e.printStackTrace();
            ID = 0;
        } finally {
            Conexion.conectar().close();
        }
        return ID;        
    }
}
