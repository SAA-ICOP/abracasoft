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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;

/**
 * Esta clase gestiona la comunicación del sistema con la base de datos desde la
 * parte del usuario.
 *
 * @author Ema
 * @since 1.0
 */
public class GestorUsuario {
    /*
     * Se crea un atributo estatico que guarda la fecha actual tomada del sistema. 
     */

    static Date fecha = new Date();

    /*
     * Este metodo recibe un usuario (Usuario usuario) y los privilegios (ArrayList<Privilegio> privilegios)
    y guarda el usuario en la tabla usuario de la base de datos, llama al metodo consultarIDUsuario() 
    que devuelve el ID del usuario creado. Crea una instancia de la clase privilegio y llama al metodo 
    AltaPrivilegioDeUsuarioEnBD(int ID, Privilegio privilegio). El metodo devuelve un int(entre 1 y 0) 
    confirmando si se guardo el usuario con los privilegios.
     */
    public static int altaUsuarioEnBD(Usuario usuario, ArrayList<Privilegio> privilegios) {
        int usuarioGuardado = 0;
        int resultado = 0;
        int ID = 0;
        //GestorPrivilegio gestorPrivilegio = new GestorPrivilegio();
        String sql = "INSERT INTO usuario (NOMUSUARIO,PASSUSUARIO,FECHACREACION)"
                + "VALUES(?,?,?)";
        try {
            PreparedStatement pst = PoolDeConexiones.pedirConexion().prepareStatement(sql);
            pst.setString(1, usuario.getNombreUsuario());
            pst.setInt(2, usuario.getPassUsuario());
            pst.setDate(3, new java.sql.Date(fecha.getTime()));
            usuarioGuardado = pst.executeUpdate();
            if (usuarioGuardado == 1) {
                ID = consultarIDUsuario(pst);
            }
            if (ID != 0) {
                boolean guardoLosPrivilegios = false;
                guardoLosPrivilegios = GestorPrivilegio.AltaPrivilegioDeUsuarioEnBD(ID, privilegios);
                if (guardoLosPrivilegios) {
                    resultado = 1;
                }else{
                    resultado = 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.toString());
        }
        return resultado;
    }

    public static void ModificarUsuarioEnBD(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void BajaUsuarioEnBD(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
     * Este metodo recibe 1 String y 1 Interger, compara esos 2 datos con los que 
    se encuentran en la base de datos en la tabla usuario. Si son iguales retorna
    el IDUsuario que es un Integer.
     */
    public static int logIn(String usuario, int pass) {
        int idUsuario = 0;

        String sql = "SELECT IDUSU FROM usuario WHERE NOMUSUARIO = ? and PASSUSUARIO = ?";
        try {
            PreparedStatement pst = Conexion.conectar().prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setInt(2, pass);
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

    /*
     * Este metodo consulta el ID del usuario recientemente creado y lo retorna, no recibe parametros.
     */
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
            e.printStackTrace();
            System.out.println(e.toString());
            ID = 0;
        }
        return ID;
    }
}
