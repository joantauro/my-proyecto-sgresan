package model;
// Generated 07/06/2015 10:37:49 PM by Hibernate Tools 4.3.1



/**
 * TPedidodetalle generated by hbm2java
 */
public class TPedidodetalle  implements java.io.Serializable {


     private Integer TPedDetalle;
     private TPedido TPedido;
     private String diaNumero;
     private String diaNombre;

    public TPedidodetalle() {
    }

	
    public TPedidodetalle(TPedido TPedido) {
        this.TPedido = TPedido;
    }
    public TPedidodetalle(TPedido TPedido, String diaNumero, String diaNombre) {
       this.TPedido = TPedido;
       this.diaNumero = diaNumero;
       this.diaNombre = diaNombre;
    }
   
    public Integer getTPedDetalle() {
        return this.TPedDetalle;
    }
    
    public void setTPedDetalle(Integer TPedDetalle) {
        this.TPedDetalle = TPedDetalle;
    }
    public TPedido getTPedido() {
        return this.TPedido;
    }
    
    public void setTPedido(TPedido TPedido) {
        this.TPedido = TPedido;
    }
    
    public String getDiaNumero() {
        return this.diaNumero;
    }
    
    public void setDiaNumero(String diaNumero) {
        this.diaNumero = diaNumero;
    }
    public String getDiaNombre() {
        return this.diaNombre;
    }
    
    public void setDiaNombre(String diaNombre) {
        this.diaNombre = diaNombre;
    }




}


