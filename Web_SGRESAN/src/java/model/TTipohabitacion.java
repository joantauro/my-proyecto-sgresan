package model;
// Generated 25/09/2014 10:40:56 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TTipohabitacion generated by hbm2java
 */
public class TTipohabitacion  implements java.io.Serializable {


     private int idTTipoHabitacion;
     private Promociones promociones;
     private String nombre;
     private Set THabitaciondetalles = new HashSet(0);

    public TTipohabitacion() {
    }

	
    public TTipohabitacion(int idTTipoHabitacion, Promociones promociones) {
        this.idTTipoHabitacion = idTTipoHabitacion;
        this.promociones = promociones;
    }
    public TTipohabitacion(int idTTipoHabitacion, Promociones promociones, String nombre, Set THabitaciondetalles) {
       this.idTTipoHabitacion = idTTipoHabitacion;
       this.promociones = promociones;
       this.nombre = nombre;
       this.THabitaciondetalles = THabitaciondetalles;
    }
   
    public int getIdTTipoHabitacion() {
        return this.idTTipoHabitacion;
    }
    
    public void setIdTTipoHabitacion(int idTTipoHabitacion) {
        this.idTTipoHabitacion = idTTipoHabitacion;
    }
    public Promociones getPromociones() {
        return this.promociones;
    }
    
    public void setPromociones(Promociones promociones) {
        this.promociones = promociones;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getTHabitaciondetalles() {
        return this.THabitaciondetalles;
    }
    
    public void setTHabitaciondetalles(Set THabitaciondetalles) {
        this.THabitaciondetalles = THabitaciondetalles;
    }




}


