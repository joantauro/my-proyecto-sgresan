package model;
// Generated 25/09/2014 10:40:56 AM by Hibernate Tools 4.3.1



/**
 * TUsuario generated by hbm2java
 */
public class TUsuario  implements java.io.Serializable {


     private String nombreUsuario;
     private String contrasena;
     private String estado;
     private String tipoUsuario;
     private TPersona TPersona;

    public TUsuario() {
    }

	
    public TUsuario(String nombreUsuario, String contrasena, String estado, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.estado = estado;
        this.tipoUsuario = tipoUsuario;
    }
    public TUsuario(String nombreUsuario, String contrasena, String estado, String tipoUsuario, TPersona TPersona) {
       this.nombreUsuario = nombreUsuario;
       this.contrasena = contrasena;
       this.estado = estado;
       this.tipoUsuario = tipoUsuario;
       this.TPersona = TPersona;
    }
   
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public TPersona getTPersona() {
        return this.TPersona;
    }
    
    public void setTPersona(TPersona TPersona) {
        this.TPersona = TPersona;
    }




}

