package model;
// Generated 13/09/2014 07:59:20 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * THabitacion generated by hbm2java
 */
public class THabitacion  implements java.io.Serializable {


     private int nroHabitacion;
     private THotel THotel;
     private String tipoHabitacion;
     private String descripcion;
     private String precio;
     private Set TReservadetalles = new HashSet(0);
     private Set THabitaciondetalles = new HashSet(0);

    public THabitacion() {
    }

	
    public THabitacion(int nroHabitacion, THotel THotel, String tipoHabitacion, String descripcion, String precio) {
        this.nroHabitacion = nroHabitacion;
        this.THotel = THotel;
        this.tipoHabitacion = tipoHabitacion;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public THabitacion(int nroHabitacion, THotel THotel, String tipoHabitacion, String descripcion, String precio, Set TReservadetalles, Set THabitaciondetalles) {
       this.nroHabitacion = nroHabitacion;
       this.THotel = THotel;
       this.tipoHabitacion = tipoHabitacion;
       this.descripcion = descripcion;
       this.precio = precio;
       this.TReservadetalles = TReservadetalles;
       this.THabitaciondetalles = THabitaciondetalles;
    }
   
    public int getNroHabitacion() {
        return this.nroHabitacion;
    }
    
    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }
    public THotel getTHotel() {
        return this.THotel;
    }
    
    public void setTHotel(THotel THotel) {
        this.THotel = THotel;
    }
    public String getTipoHabitacion() {
        return this.tipoHabitacion;
    }
    
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public Set getTReservadetalles() {
        return this.TReservadetalles;
    }
    
    public void setTReservadetalles(Set TReservadetalles) {
        this.TReservadetalles = TReservadetalles;
    }
    public Set getTHabitaciondetalles() {
        return this.THabitaciondetalles;
    }
    
    public void setTHabitaciondetalles(Set THabitaciondetalles) {
        this.THabitaciondetalles = THabitaciondetalles;
    }




}


