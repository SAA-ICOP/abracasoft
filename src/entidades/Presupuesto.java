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
public class Presupuesto {

    private Date FechaDePresupuesto;
    private Date VigenciaDePresupuesto;
    private int IdPresupuesto;
    private int IdCliente;
    private int IdVendedor;
    private int RelVenta;

    public int getIdVendedor() {
        return IdVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.IdVendedor = idVendedor;
    }

    public Date getFechaDePresupuesto() {
        return FechaDePresupuesto;
    }

    public void setFechaDePresupuesto(Date FechaDePresupuesto) {
        this.FechaDePresupuesto = FechaDePresupuesto;
    }

    public Date getVigenciaDePresupuesto() {
        return VigenciaDePresupuesto;
    }

    public void setVigenciaDePresupuesto(Date VigenciaDePresupuesto) {
        this.VigenciaDePresupuesto = VigenciaDePresupuesto;
    }

    public int getIdPresupuesto() {
        return IdPresupuesto;
    }

    public void setIdPresupuesto(int IdPresupuesto) {
        this.IdPresupuesto = IdPresupuesto;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public void setRelVenta(int aInt) {
        this.RelVenta = aInt;
    }

    public Object getRelVenta() {
        return RelVenta;
    }
}
