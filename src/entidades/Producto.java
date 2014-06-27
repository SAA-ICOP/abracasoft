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

    private int CodigoDeProducto;
    private String NombreProducto;
    private int PrecioUnitario;
    private int StockProducto;

    public Producto(int CodigoDeProducto, String NombreProducto, int PrecioUnitario, int StockProducto) {
        this.CodigoDeProducto = CodigoDeProducto;
        this.NombreProducto = NombreProducto;
        this.PrecioUnitario = PrecioUnitario;
        this.StockProducto = StockProducto;
    }

    public int getCodigoDeProducto() {
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

    public int getPrecioUnitario() {
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
}
