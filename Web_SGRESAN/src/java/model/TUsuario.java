package model;
// Generated 17/09/2014 12:29:13 PM by Hibernate Tools 4.3.1



/**
 * TUsuario generated by hbm2java
 */
public class TUsuario  implements java.io.Serializable {


     private String nombreUsuario;
     private TPerfil TPerfil;
     private String contrasena;
     private String estado;
     private TPersona TPersona;

    public TUsuario() {
    }

	
    public TUsuario(String nombreUsuario, TPerfil TPerfil, String contrasena, String estado) {
        this.nombreUsuario = nombreUsuario;
        this.TPerfil = TPerfil;
        this.contrasena = contrasena;
        this.estado = estado;
    }
    public TUsuario(String nombreUsuario, TPerfil TPerfil, String contrasena, String estado, TPersona TPersona) {
       this.nombreUsuario = nombreUsuario;
       this.TPerfil = TPerfil;
       this.contrasena = contrasena;
       this.estado = estado;
       this.TPersona = TPersona;
    }
   
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public TPerfil getTPerfil() {
        return this.TPerfil;
    }
    
    public void setTPerfil(TPerfil TPerfil) {
        this.TPerfil = TPerfil;
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
    public TPersona getTPersona() {
        return this.TPersona;
    }
    
    public void setTPersona(TPersona TPersona) {
        this.TPersona = TPersona;
    }




}


