/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Ema
 */
public class UsuarioNegocio extends Usuario {

    public UsuarioNegocio() {
    }

    public int AltaDeUsuarioNegocio(Usuario usuario, int[] privilegios) {
        int resultado = 0;
        try {
            resultado = usuario.AltaDeUsuario(usuario, privilegios);
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
