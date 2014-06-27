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
public class Proveedor {

    private int CuitProveedor;
    private String RazonSocialProveedor;

    public Proveedor(int cuitProveedor, String razonSocialProveedor) {
        super();
        CuitProveedor = cuitProveedor;
        RazonSocialProveedor = razonSocialProveedor;
    }

    public int getCuitProveedor() {
        return CuitProveedor;
    }

    public void setCuitProveedor(int cuitProveedor) {
        CuitProveedor = cuitProveedor;
    }

    public String getRazonSocialProveedor() {
        return RazonSocialProveedor;
    }

    public void setRazonSocialProveedor(String razonSocialProveedor) {
        RazonSocialProveedor = razonSocialProveedor;
    }

}
