/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import gestores.AbraBackUp;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Ema
 */
public class Usuario extends Privilegio {

    String NombreUsuario;
    int PassUsuario;

    public Usuario(String NombreUsuario, int PassUsuario, int ID, String DescripcionDePrivilegio) {
        super(ID, DescripcionDePrivilegio);
        this.NombreUsuario = NombreUsuario;
        this.PassUsuario = PassUsuario;
    }

    public Usuario() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.NombreUsuario);
        hash = 53 * hash + this.PassUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.NombreUsuario, other.NombreUsuario)) {
            return false;
        }
        if (this.PassUsuario != other.PassUsuario) {
            return false;
        }
        return true;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public int getPassUsuario() {
        return PassUsuario;
    }

    public void setPassUsuario(int passUsuario) {
        PassUsuario = passUsuario;
    }

    public static int AltaDeUsuario(Usuario usuario, int[] privilegios) throws SQLException {
       int resultado = gestores.GestorUsuario.AltaUsuarioEnBD(usuario, privilegios);
       return resultado;
    }

    public static void BajaDeUsuario(Usuario usuario) {
        gestores.GestorUsuario.BajaUsuarioEnBD(usuario);
    }

    public static void ModificarUsuario(Usuario usuario) {
        gestores.GestorUsuario.ModificarUsuarioEnBD(usuario);
    }

    public static int LogIn(String nombreDeUsuario, String pass) {
        int idUsuario;
        idUsuario = gestores.GestorUsuario.ingreso(nombreDeUsuario, pass);
        return idUsuario;
    }

    public static boolean backUp() {
        boolean ok;
        AbraBackUp backUpData = new AbraBackUp();
        ok = backUpData.CrearBackup("localhost", "3306", "root", "password", "abracasoftDB", "c:/abracasoftDB.sql");
        return ok;
    }
}
