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
        int resultado;
        try {
            resultado = usuario.AltaDeUsuario(usuario, privilegios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            resultado = 0;
        }
        return resultado;
    }

    public boolean backUpNegocio() {
        boolean ok;
        try {
            Usuario usuario = new Usuario();
            ok = usuario.backUp();
        } catch (Exception e) {
            ok = false;
        }
        return ok;
    }
}
