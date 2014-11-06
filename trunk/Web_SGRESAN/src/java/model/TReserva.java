package model;
// Generated 27/10/2014 12:31:22 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TReserva generated by hbm2java
 */
public class TReserva  implements java.io.Serializable {


     private String idReserva;
     private TCliente TCliente;
     private String estado;
     private Date fechaRegistro;
     private Date fechaEntrada;
     private Date fechaSalida;
     private String descripcion;
     private String modalidadPago;
     private byte[] voucher;
     private Double subtotal;
     private Double igv;
     private Double precio;
     private String usuario;
     private Set TReservadetalles = new HashSet(0);

    public TReserva() {
    }

	
    public TReserva(String idReserva, TCliente TCliente, String estado, String descripcion) {
        this.idReserva = idReserva;
        this.TCliente = TCliente;
        this.estado = estado;
        this.descripcion = descripcion;
    }
    public TReserva(String idReserva, TCliente TCliente, String estado, Date fechaRegistro, Date fechaEntrada, Date fechaSalida, String descripcion, String modalidadPago, byte[] voucher, Double subtotal, Double igv, Double precio, String usuario, Set TReservadetalles) {
       this.idReserva = idReserva;
       this.TCliente = TCliente;
       this.estado = estado;
       this.fechaRegistro = fechaRegistro;
       this.fechaEntrada = fechaEntrada;
       this.fechaSalida = fechaSalida;
       this.descripcion = descripcion;
       this.modalidadPago = modalidadPago;
       this.voucher = voucher;
       this.subtotal = subtotal;
       this.igv = igv;
       this.precio = precio;
       this.usuario = usuario;
       this.TReservadetalles = TReservadetalles;
    }
   
    public String getIdReserva() {
        return this.idReserva;
    }
    
    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }
    public TCliente getTCliente() {
        return this.TCliente;
    }
    
    public void setTCliente(TCliente TCliente) {
        this.TCliente = TCliente;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Date getFechaEntrada() {
        return this.fechaEntrada;
    }
    
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public Date getFechaSalida() {
        return this.fechaSalida;
    }
    
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getModalidadPago() {
        return this.modalidadPago;
    }
    
    public void setModalidadPago(String modalidadPago) {
        this.modalidadPago = modalidadPago;
    }
    public byte[] getVoucher() {
        return this.voucher;
    }
    
    public void setVoucher(byte[] voucher) {
        this.voucher = voucher;
    }
    public Double getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    public Double getIgv() {
        return this.igv;
    }
    
    public void setIgv(Double igv) {
        this.igv = igv;
    }
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Set getTReservadetalles() {
        return this.TReservadetalles;
    }
    
    public void setTReservadetalles(Set TReservadetalles) {
        this.TReservadetalles = TReservadetalles;
    }




}


