/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import entidades.Privilegio;
import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase gestiona la comunicación del sistema con la base de datos desde la
 * parte del usuario.
 *
 * @author Ema
 * @since 1.0
 */
public class GestorUsuario {

    static Date fecha = new Date();

    /**
     * Metodo para guardar un usuario con sus privilegios en la base de datos
     *
     * @param usuario
     * @param privilegios
     * @return
     * @throws SQLException
     */
    public static int altaUsuarioEnBD(Usuario usuario, ArrayList<Privilegio> privilegios) throws SQLException {
        int usuarioGuardado = 0;
        int resultado = 0;
        int ID = 0;

        String sql = "INSERT INTO usuario (NOMUSUARIO,PASSUSUARIO,FECHACREACION)"
                + "VALUES(?,?,?)";

        PreparedStatement pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
        pst.setString(1, usuario.getNombreUsuario());
        pst.setInt(2, usuario.getPassUsuario());
        pst.setDate(3, new java.sql.Date(fecha.getTime()));
        usuarioGuardado = pst.executeUpdate();
        if (usuarioGuardado == 1) {
            ID = consultarIDUsuario(pst);
        }
        if (ID != 0) {
            int guardoLosPrivilegios = 0;
            guardoLosPrivilegios = GestorPrivilegio.altaPrivilegioDeUsuarioEnBD(ID, privilegios);

            if (guardoLosPrivilegios == 0) {
                resultado = 0;
            } else {
                resultado = 1;
            }
        }
        return resultado;
    }

    /**
     * Metodo para modificar un usuario y sus respectivos privilegios en la base
     * de datos.
     *
     * @param usuario
     * @param privilegios
     * @return
     * @throws SQLException
     */
    public static int ModificarUsuarioEnBD(Usuario usuario, ArrayList<Privilegio> privilegios) throws SQLException {
        int privilegiosGuardados = 0;
        int usuarioGuardado = 0;
        int idUsuario;
        int ok = 0;
        PreparedStatement pst;

        String sql = "SELECT max(IDUSU) as id FROM log";
        pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
        ResultSet resultado = pst.executeQuery(sql);
        if (resultado.next()) {
            idUsuario = resultado.getInt("id");
        } else {
            idUsuario = 0;
        }

        String sql2 = "UPDATE usuario SET nomusuario = '?' AND passusuario = '?'"
                + "WHERE idusu = '?'";
        pst = PoolDeConexiones.pedirConexion().prepareStatement(sql2);
        pst.setString(1, usuario.getNombreUsuario());
        pst.setInt(2, usuario.getPassUsuario());
        pst.setInt(3, idUsuario);
        usuarioGuardado = pst.executeUpdate();
        if (usuarioGuardado == 1) {
            privilegiosGuardados = GestorPrivilegio.modificarPrivilegiosEnBD(privilegios, idUsuario);
        }
        if (privilegiosGuardados == 1) {
            ok = 1;
        }
        return ok;
    }

    public static int ModificarUsuarioEnBD(String nombre, ArrayList<Privilegio> privilegios) throws SQLException {
        int privilegiosGuardados = 0;
        int usuarioGuardado = 0;
        int idUsuario;
        int ok = 0;
        PreparedStatement pst;
        String sql = "SELECT max(IDUSU) as id FROM log";
        pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
        ResultSet resultado = pst.executeQuery(sql);
        if (resultado.next()) {
            idUsuario = resultado.getInt("id");
        } else {
            idUsuario = 0;
        }
        String sql2 = "UPDATE usuario SET nomusuario = '?'"
                + "WHERE idusu = '?'";
        pst = PoolDeConexiones.pedirConexion().prepareStatement(sql2);
        pst.setString(1, nombre);
        pst.setInt(2, idUsuario);
        usuarioGuardado = pst.executeUpdate();

        if (usuarioGuardado == 1) {
            privilegiosGuardados = GestorPrivilegio.modificarPrivilegiosEnBD(privilegios, idUsuario);
        }
        if (privilegiosGuardados == 1) {
            ok = 1;
        }
        return ok;
    }

    public static int ModificarUsuarioEnBD(int pass, ArrayList<Privilegio> privilegios) throws SQLException {
        int privilegiosGuardados = 0;
        int usuarioGuardado = 0;
        int idUsuario;
        PreparedStatement pst;
        int ok = 0;

        String sql = "SELECT max(IDUSU) as id FROM log";
        pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
        ResultSet resultado = pst.executeQuery(sql);
        if (resultado.next()) {
            idUsuario = resultado.getInt("id");
        } else {
            idUsuario = 0;
        }

        String sql2 = "UPDATE usuario SET passusuario = '?'"
                + "WHERE idusu = '?'";
        pst = PoolDeConexiones.pedirConexion().prepareStatement(sql2);
        pst.setInt(1, pass);
        pst.setInt(2, idUsuario);
        usuarioGuardado = pst.executeUpdate();
        if (usuarioGuardado == 1) {
            privilegiosGuardados = GestorPrivilegio.modificarPrivilegiosEnBD(privilegios, idUsuario);
        }
        if (privilegiosGuardados == 1) {
            ok = 1;
        }
        return ok;
    }

    public static int ModificarUsuarioEnBD(ArrayList<Privilegio> privilegios) throws SQLException {
        int privilegiosGuardados = 0;
        PreparedStatement pst;
        int idUsuario;
        int ok = 0;

        String sql = "SELECT max(IDUSU) as id FROM log";
        pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
        ResultSet resultado = pst.executeQuery(sql);
        if (resultado.next()) {
            idUsuario = resultado.getInt("id");
        } else {
            idUsuario = 0;
        }
        privilegiosGuardados = GestorPrivilegio.modificarPrivilegiosEnBD(privilegios, idUsuario);
        if (privilegiosGuardados == 1) {
            ok = 1;
        }
        return ok;
    }

    /**
     * Metodo para dar de baja un usuario y los privilegios en la base de datos.
     *
     * @param usuario
     * @return boolean
     * @throws java.sql.SQLException
     */
    public static boolean BajaUsuarioEnBD(Usuario usuario) throws SQLException {
        PreparedStatement pst;
        int idUsuario = usuario.getID();
        boolean ok;
        String sql = "UPDATE usuario SET fechabaja = '?' WHERE idusu = ?";
        pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
        pst.setDate(1, new java.sql.Date(fecha.getTime()));
        pst.setInt(2, idUsuario);
        ok = pst.execute(sql);
        return ok;
    }

    /**
     * Metodo de logIn
     *
     * @param usuario
     * @param pass
     * @return idUsuario
     * @throws java.sql.SQLException
     */
    public static int logIn(String usuario, int pass) throws SQLException {
        int idUsuario = 0;
        String sql = "SELECT IDUSU FROM usuario WHERE NOMUSUARIO = ? and PASSUSUARIO = ? "
                + "AND FECHABAJA IS NULL";

        PreparedStatement pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
        pst.setString(1, usuario);
        pst.setInt(2, pass);
        ResultSet resultado = pst.executeQuery();
        if (resultado.next()) { //cuando la consulta no da vacia pasa por acá
            idUsuario = resultado.getInt("IDUSU");
        }
        return idUsuario;
    }

    private static int consultarIDUsuario(PreparedStatement pst) {
        int ID;
        String sql = "SELECT max(idusu) as id FROM usuario";
        try {
            ResultSet resultado = pst.executeQuery(sql);
            if (resultado.next()) {
                ID = resultado.getInt("id");
            } else {
                ID = 0;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            ID = 0;
        }
        return ID;
    }
}
