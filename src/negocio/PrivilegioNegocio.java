/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import entidades.Privilegio;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ema
 */
public class PrivilegioNegocio {
    
    public ArrayList<Privilegio> listarPrivilegios(){
        Privilegio privilegio = new Privilegio();
        ArrayList<Privilegio> listadeprivilegios = new ArrayList<Privilegio>();
        try {
           listadeprivilegios = privilegio.listarPrivilegios();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.toString());
        }
        return listadeprivilegios;
    }
    public ArrayList<Privilegio> listarPrivilegiosPorUsuario(int idUsuario) throws SQLException{
        Privilegio privilegio = new Privilegio();
        return privilegio.listarPrivilegiosPorUsuario(idUsuario);
    }
    
}
