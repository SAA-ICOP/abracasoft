/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Ema
 */
public class Producto {

    private long CodigoDeProducto;
    private String NombreProducto;
    private float PrecioUnitario;
    private float PrecioContado;
    private float PrecioDebito;
    private float PrecioCredito;

    public float getPrecioContado() {
        return PrecioContado;
    }

    public void setPrecioContado(float PrecioContado) {
        this.PrecioContado = PrecioContado;
    }

    public float getPrecioDebito() {
        return PrecioDebito;
    }

    public void setPrecioDebito(float PrecioDebito) {
        this.PrecioDebito = PrecioDebito;
    }

    public float getPrecioCredito() {
        return PrecioCredito;
    }

    public void setPrecioCredito(float PrecioCredito) {
        this.PrecioCredito = PrecioCredito;
    }
    private int StockProducto;

    public Producto(long codigoDeProducto, String nombreProducto, float precioContado, float precioDebito, float precioCredito, int stockProducto) {
        this.CodigoDeProducto = codigoDeProducto;
        this.NombreProducto = nombreProducto;
        this.PrecioContado = precioContado;
        this.PrecioDebito = precioDebito;
        this.PrecioCredito = precioCredito;
        this.StockProducto = stockProducto;
    }

    public long getCodigoDeProducto() {
        return CodigoDeProducto;
    }

    public void setCodigoDeProducto(int CodigoDeProducto) {
        this.CodigoDeProducto = CodigoDeProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public float getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        PrecioUnitario = precioUnitario;
    }

    public int getStockProducto() {
        return StockProducto;
    }

    public void setStockProducto(int stockProducto) {
        StockProducto = stockProducto;
    }
    
    public String toString() {
        return NombreProducto;
    }
}
