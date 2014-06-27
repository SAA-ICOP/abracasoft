/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Ema
 */
public class Gasto {

    private String DescripcionGasto;
    private Date FechaGasto;
    private float MontoGasto;

    public Gasto(String descripcionGasto, Date fechaGasto, float montoGasto) {
        super();
        DescripcionGasto = descripcionGasto;
        FechaGasto = fechaGasto;
        MontoGasto = montoGasto;
    }

    public String getDescripcionGasto() {
        return DescripcionGasto;
    }

    public void setDescripcionGasto(String descripcionGasto) {
        DescripcionGasto = descripcionGasto;
    }

    public Date getFechaGasto() {
        return FechaGasto;
    }

    public void setFechaGasto(Date fechaGasto) {
        FechaGasto = fechaGasto;
    }

    public float getMontoGasto() {
        return MontoGasto;
    }

    public void setMontoGasto(float montoGasto) {
        MontoGasto = montoGasto;
    }

}
