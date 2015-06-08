package model;
// Generated 07/06/2015 10:37:49 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TCliente generated by hbm2java
 */
public class TCliente  implements java.io.Serializable {


     private String idCliente;
     private TPersona TPersona;
     private String tipoCliente;
     private Integer ruc;
     private String razonSocial;
     private String representanteLegal;
     private String descripcion;
     private Set TReservas = new HashSet(0);

    public TCliente() {
    }

	
    public TCliente(String idCliente, TPersona TPersona) {
        this.idCliente = idCliente;
        this.TPersona = TPersona;
    }
    public TCliente(String idCliente, TPersona TPersona, String tipoCliente, Integer ruc, String razonSocial, String representanteLegal, String descripcion, Set TReservas) {
       this.idCliente = idCliente;
       this.TPersona = TPersona;
       this.tipoCliente = tipoCliente;
       this.ruc = ruc;
       this.razonSocial = razonSocial;
       this.representanteLegal = representanteLegal;
       this.descripcion = descripcion;
       this.TReservas = TReservas;
    }
   
    public String getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public TPersona getTPersona() {
        return this.TPersona;
    }
    
    public void setTPersona(TPersona TPersona) {
        this.TPersona = TPersona;
    }
    public String getTipoCliente() {
        return this.tipoCliente;
    }
    
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public Integer getRuc() {
        return this.ruc;
    }
    
    public void setRuc(Integer ruc) {
        this.ruc = ruc;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getRepresentanteLegal() {
        return this.representanteLegal;
    }
    
    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getTReservas() {
        return this.TReservas;
    }
    
    public void setTReservas(Set TReservas) {
        this.TReservas = TReservas;
    }




}


