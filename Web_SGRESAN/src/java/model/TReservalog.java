package model;
// Generated 07/06/2015 10:37:49 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * TReservalog generated by hbm2java
 */
public class TReservalog  implements java.io.Serializable {


     private Integer id;
     private String idReserva;
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
     private String cliente;
     private String accion;
     private Date fecha;
     private String pc;

    public TReservalog() {
    }

	
    public TReservalog(String idReserva, String estado, String descripcion) {
        this.idReserva = idReserva;
        this.estado = estado;
        this.descripcion = descripcion;
    }
    public TReservalog(String idReserva, String estado, Date fechaRegistro, Date fechaEntrada, Date fechaSalida, String descripcion, String modalidadPago, byte[] voucher, Double subtotal, Double igv, Double precio, String usuario, String cliente, String accion, Date fecha, String pc) {
       this.idReserva = idReserva;
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
       this.cliente = cliente;
       this.accion = accion;
       this.fecha = fecha;
       this.pc = pc;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getIdReserva() {
        return this.idReserva;
    }
    
    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
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
    public String getCliente() {
        return this.cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getAccion() {
        return this.accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getPc() {
        return this.pc;
    }
    
    public void setPc(String pc) {
        this.pc = pc;
    }




}


