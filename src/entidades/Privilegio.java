/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Ema
 */
public class Privilegio {

    int ID;
    String DescripcionDePrivilegio;

    public Privilegio(int ID, String DescripcionDePrivilegio) {
        this.ID = ID;
        this.DescripcionDePrivilegio = DescripcionDePrivilegio;
    }

    public Privilegio() {
        
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.ID;
        hash = 31 * hash + Objects.hashCode(this.DescripcionDePrivilegio);
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
        final Privilegio other = (Privilegio) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.DescripcionDePrivilegio, other.DescripcionDePrivilegio)) {
            return false;
        }
        return true;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripcionDePrivilegio() {
        return DescripcionDePrivilegio;
    }

    public void setDescripcionDePrivilegio(String DescripcionDePrivilegio) {
        this.DescripcionDePrivilegio = DescripcionDePrivilegio;
    }
    
    public ArrayList<Privilegio> listarPrivilegios(){
        return gestores.GestorPrivilegio.listarPrivilegiosDB();
    }
}
