package model;
// Generated 25/09/2014 10:40:56 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TCliente generated by hbm2java
 */
public class TCliente  implements java.io.Serializable {


     private int idCliente;
     private TPersona TPersona;
     private Set TReservas = new HashSet(0);

    public TCliente() {
    }

	
    public TCliente(int idCliente, TPersona TPersona) {
        this.idCliente = idCliente;
        this.TPersona = TPersona;
    }
    public TCliente(int idCliente, TPersona TPersona, Set TReservas) {
       this.idCliente = idCliente;
       this.TPersona = TPersona;
       this.TReservas = TReservas;
    }
   
    public int getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public TPersona getTPersona() {
        return this.TPersona;
    }
    
    public void setTPersona(TPersona TPersona) {
        this.TPersona = TPersona;
    }
    public Set getTReservas() {
        return this.TReservas;
    }
    
    public void setTReservas(Set TReservas) {
        this.TReservas = TReservas;
    }




}


