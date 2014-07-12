/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.Date;

/**
 *
 * @author pablo
 */
public class Pago {
    private float pagoCliente;
    private Date fechaPagoCliente;

    public float getPagoCliente() {
        return pagoCliente;
    }

    public void setPagoCliente(float pagoCliente) {
        this.pagoCliente = pagoCliente;
    }

    public Date getFechaPagoCliente() {
        return fechaPagoCliente;
    }

    public void setFechaPagoCliente(Date fechaPagoCliente) {
        this.fechaPagoCliente = fechaPagoCliente;
    }
    
    
            
}
