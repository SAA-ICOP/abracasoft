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
public class Cliente {

    private String NombreCliente;
    private String ProvinciaCliente;
    private String LocalidadCliente;
    private String DireccionCliente;
    private int CodigoPostalCliente;
    private int TelefonoCliente;
    private int DniCuilCuit;
    private String Esatdo;
    private int IdCliente;

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getDniCuilCuit() {
        return DniCuilCuit;
    }

    public String getEsatdo() {
        return Esatdo;
    }

    public void setEsatdo(String Esatdo) {
        this.Esatdo = Esatdo;
    }

    public void setDniCuilCuit(int DniCuilCuit) {
        this.DniCuilCuit = DniCuilCuit;
    }
    private String MailCliente;

    public Cliente(int idCliente, String nombreCliente, String provinciaCliente,
            String localidadCliente, String direccionCliente,
            int codigoPostalCliente, int telefonoCliente, int dniCuilCuit, String mailCliente) {
        super();
        IdCliente = idCliente;
        NombreCliente = nombreCliente;
        ProvinciaCliente = provinciaCliente;
        LocalidadCliente = localidadCliente;
        DireccionCliente = direccionCliente;
        CodigoPostalCliente = codigoPostalCliente;
        TelefonoCliente = telefonoCliente;
        DniCuilCuit = dniCuilCuit;
        MailCliente = mailCliente;
    }
    
        public Cliente(int idCliente, String nombreCliente, String direccionCliente,
            int codigoPostalCliente, int telefonoCliente, int dniCuilCuit, String mailCliente) {
        super();
        IdCliente = idCliente;
        NombreCliente = nombreCliente;
        DireccionCliente = direccionCliente;
        CodigoPostalCliente = codigoPostalCliente;
        TelefonoCliente = telefonoCliente;
        DniCuilCuit = dniCuilCuit;
        MailCliente = mailCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public String getProvinciaCliente() {
        return ProvinciaCliente;
    }

    public void setProvinciaCliente(String provinciaCliente) {
        ProvinciaCliente = provinciaCliente;
    }

    public String getLocalidadCliente() {
        return LocalidadCliente;
    }

    public void setLocalidadCliente(String localidadCliente) {
        LocalidadCliente = localidadCliente;
    }

    public String getDireccionCliente() {
        return DireccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        DireccionCliente = direccionCliente;
    }

    public int getCodigoPostalCliente() {
        return CodigoPostalCliente;
    }

    public void setCodigoPostalCliente(int codigoPostalCliente) {
        CodigoPostalCliente = codigoPostalCliente;
    }

    public int getTelefonoCliente() {
        return TelefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        TelefonoCliente = telefonoCliente;
    }

    public String getMailCliente() {
        return MailCliente;
    }

    public void setMailCliente(String mailCliente) {
        MailCliente = mailCliente;
    }

}
