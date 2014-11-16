package model;
// Generated 10/11/2014 08:33:41 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TPersona generated by hbm2java
 */
public class TPersona  implements java.io.Serializable {


     private String idPersona;
     private TUbigeo TUbigeo;
     private TUsuario TUsuario;
     private String nombres;
     private String apellidoP;
     private String apellidoM;
     private String dni;
     private Date fechaNacimiento;
     private String direccion;
     private String telefono;
     private String celular;
     private String email;
     private String estado;
     private byte[] imagen;
     private String observacion;
     private Set TClientes = new HashSet(0);
     private Set TTrabajadors = new HashSet(0);

    public TPersona() {
    }

	
    public TPersona(TUbigeo TUbigeo, TUsuario TUsuario) {
        this.TUbigeo = TUbigeo;
        this.TUsuario = TUsuario;
    }
    public TPersona(TUbigeo TUbigeo, TUsuario TUsuario, String nombres, String apellidoP, String apellidoM, String dni, Date fechaNacimiento, String direccion, String telefono, String celular, String email, String estado, byte[] imagen, String observacion, Set TClientes, Set TTrabajadors) {
       this.TUbigeo = TUbigeo;
       this.TUsuario = TUsuario;
       this.nombres = nombres;
       this.apellidoP = apellidoP;
       this.apellidoM = apellidoM;
       this.dni = dni;
       this.fechaNacimiento = fechaNacimiento;
       this.direccion = direccion;
       this.telefono = telefono;
       this.celular = celular;
       this.email = email;
       this.estado = estado;
       this.imagen = imagen;
       this.observacion = observacion;
       this.TClientes = TClientes;
       this.TTrabajadors = TTrabajadors;
    }
   
    public String getIdPersona() {
        return this.idPersona;
    }
    
    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }
    public TUbigeo getTUbigeo() {
        return this.TUbigeo;
    }
    
    public void setTUbigeo(TUbigeo TUbigeo) {
        this.TUbigeo = TUbigeo;
    }
    public TUsuario getTUsuario() {
        return this.TUsuario;
    }
    
    public void setTUsuario(TUsuario TUsuario) {
        this.TUsuario = TUsuario;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidoP() {
        return this.apellidoP;
    }
    
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    public String getApellidoM() {
        return this.apellidoM;
    }
    
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public byte[] getImagen() {
        return this.imagen;
    }
    
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Set getTClientes() {
        return this.TClientes;
    }
    
    public void setTClientes(Set TClientes) {
        this.TClientes = TClientes;
    }
    public Set getTTrabajadors() {
        return this.TTrabajadors;
    }
    
    public void setTTrabajadors(Set TTrabajadors) {
        this.TTrabajadors = TTrabajadors;
    }




}


