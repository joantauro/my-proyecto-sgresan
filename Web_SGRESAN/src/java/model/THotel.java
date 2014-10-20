package model;
// Generated 19/10/2014 11:59:18 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * THotel generated by hbm2java
 */
public class THotel  implements java.io.Serializable {


     private int ruc;
     private String razonSocial;
     private String fechaInicio;
     private String direccion;
     private String telefono;
     private byte[] logo;
     private Set THabitacions = new HashSet(0);

    public THotel() {
    }

	
    public THotel(int ruc, String razonSocial, String fechaInicio, String direccion, String telefono) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.fechaInicio = fechaInicio;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public THotel(int ruc, String razonSocial, String fechaInicio, String direccion, String telefono, byte[] logo, Set THabitacions) {
       this.ruc = ruc;
       this.razonSocial = razonSocial;
       this.fechaInicio = fechaInicio;
       this.direccion = direccion;
       this.telefono = telefono;
       this.logo = logo;
       this.THabitacions = THabitacions;
    }
   
    public int getRuc() {
        return this.ruc;
    }
    
    public void setRuc(int ruc) {
        this.ruc = ruc;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public byte[] getLogo() {
        return this.logo;
    }
    
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    public Set getTHabitacions() {
        return this.THabitacions;
    }
    
    public void setTHabitacions(Set THabitacions) {
        this.THabitacions = THabitacions;
    }




}


