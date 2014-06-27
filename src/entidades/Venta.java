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
public class Venta {

    private Date FechaDeVenta;
    private float MontoPagoVenta;
    private char TipoPagoVenta;

    public Venta(Date fechaDeVenta, float montoPagoVenta, char tipoPagoVenta) {
        super();
        FechaDeVenta = fechaDeVenta;
        MontoPagoVenta = montoPagoVenta;
        TipoPagoVenta = tipoPagoVenta;
    }

    public Date getFechaDeVenta() {
        return FechaDeVenta;
    }

    public void setFechaDeVenta(Date fechaDeVenta) {
        FechaDeVenta = fechaDeVenta;
    }

    public float getMontoPagoVenta() {
        return MontoPagoVenta;
    }

    public void setMontoPagoVenta(float montoPagoVenta) {
        MontoPagoVenta = montoPagoVenta;
    }

    public char getTipoPagoVenta() {
        return TipoPagoVenta;
    }

    public void setTipoPagoVenta(char tipoPagoVenta) {
        TipoPagoVenta = tipoPagoVenta;
    }

}
