package model;
// Generated 19/10/2014 11:59:18 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TTipohabitacion generated by hbm2java
 */
public class TTipohabitacion  implements java.io.Serializable {


     private int idTTipoHabitacion;
     private String nombre;
     private Set THabitacions = new HashSet(0);

    public TTipohabitacion() {
    }

	
    public TTipohabitacion(int idTTipoHabitacion) {
        this.idTTipoHabitacion = idTTipoHabitacion;
    }
    public TTipohabitacion(int idTTipoHabitacion, String nombre, Set THabitacions) {
       this.idTTipoHabitacion = idTTipoHabitacion;
       this.nombre = nombre;
       this.THabitacions = THabitacions;
    }
   
    public int getIdTTipoHabitacion() {
        return this.idTTipoHabitacion;
    }
    
    public void setIdTTipoHabitacion(int idTTipoHabitacion) {
        this.idTTipoHabitacion = idTTipoHabitacion;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getTHabitacions() {
        return this.THabitacions;
    }
    
    public void setTHabitacions(Set THabitacions) {
        this.THabitacions = THabitacions;
    }




}

