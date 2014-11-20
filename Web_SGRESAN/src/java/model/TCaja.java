package model;
// Generated 10/11/2014 08:33:41 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * TCaja generated by hbm2java
 */
public class TCaja  implements java.io.Serializable {


     private Integer idCaja;
     private TTrabajador TTrabajador;
     private Date fecha;
     private Date hora;
     private String descripcion;
     private Double entrada;
     private Double salida;
     private Double saldo;
     private Double arqueo;
     private String moneda;

    public TCaja() {
    }

    public TCaja(TTrabajador TTrabajador, Date fecha, Date hora, String descripcion, Double entrada, Double salida, Double saldo, Double arqueo, String moneda) {
       this.TTrabajador = TTrabajador;
       this.fecha = fecha;
       this.hora = hora;
       this.descripcion = descripcion;
       this.entrada = entrada;
       this.salida = salida;
       this.saldo = saldo;
       this.arqueo = arqueo;
       this.moneda = moneda;
    }
   
    public Integer getIdCaja() {
        return this.idCaja;
    }
    
    public void setIdCaja(Integer idCaja) {
        this.idCaja = idCaja;
    }
    public TTrabajador getTTrabajador() {
        return this.TTrabajador;
    }
    
    public void setTTrabajador(TTrabajador TTrabajador) {
        this.TTrabajador = TTrabajador;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getHora() {
        return this.hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getEntrada() {
        return this.entrada;
    }
    
    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }
    public Double getSalida() {
        return this.salida;
    }
    
    public void setSalida(Double salida) {
        this.salida = salida;
    }
    public Double getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public Double getArqueo() {
        return this.arqueo;
    }
    
    public void setArqueo(Double arqueo) {
        this.arqueo = arqueo;
    }
    public String getMoneda() {
        return this.moneda;
    }
    
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }




}

