package model;
// Generated 10/11/2014 08:33:41 AM by Hibernate Tools 4.3.1



/**
 * TPromocion generated by hbm2java
 */
public class TPromocion  implements java.io.Serializable {


     private Integer idPromociones;
     private String codPromocion;
     private String descripcion;
     private Double descuento;

    public TPromocion() {
    }

    public TPromocion(String codPromocion, String descripcion, Double descuento) {
       this.codPromocion = codPromocion;
       this.descripcion = descripcion;
       this.descuento = descuento;
    }
   
    public Integer getIdPromociones() {
        return this.idPromociones;
    }
    
    public void setIdPromociones(Integer idPromociones) {
        this.idPromociones = idPromociones;
    }
    public String getCodPromocion() {
        return this.codPromocion;
    }
    
    public void setCodPromocion(String codPromocion) {
        this.codPromocion = codPromocion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }




}

