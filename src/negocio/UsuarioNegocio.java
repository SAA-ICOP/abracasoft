/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Privilegio;
import entidades.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ema
 */
public class UsuarioNegocio extends Usuario {

    public UsuarioNegocio() {
    }

    public int altaDeUsuarioNegocio(Usuario usuario, ArrayList<Privilegio> privilegios) {
        int resultado = 0;
        try {
            resultado = usuario.altaDeUsuario(usuario, privilegios);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public int modificarUsuarioNegocio(Usuario usuario, ArrayList<Privilegio> privilegios) {
        int resultado = 0;
        try {
            resultado = usuario.ModificarUsuario(usuario, privilegios);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public int modificarUsuarioNegocio(String nombreUsuario, ArrayList<Privilegio> privilegios) {
        int resultado = 0;
        UsuarioNegocio usuario = new UsuarioNegocio();
        try {
            resultado = usuario.ModificarUsuario(nombreUsuario, privilegios);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public int modificarUsuarioNegocio(int passUsuario, ArrayList<Privilegio> privilegios) {
        int resultado = 0;
        UsuarioNegocio usuario = new UsuarioNegocio();
        try {
            resultado = usuario.ModificarUsuario(passUsuario, privilegios);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public int logIn(String nombreDeUsuario, int contraseña) {
        int idUsuario = 0;
        try {
            idUsuario = Usuario.LogIn(nombreDeUsuario, contraseña);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return idUsuario;
    }

    public boolean backUpNegocio() {
        boolean ok = false;
        try {
            Usuario usuario = new Usuario();
            ok = usuario.backUp();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return ok;
    }
}
