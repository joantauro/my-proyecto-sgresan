package model;
// Generated 19/10/2014 11:59:18 PM by Hibernate Tools 4.3.1



/**
 * TJuridica generated by hbm2java
 */
public class TJuridica  implements java.io.Serializable {


     private String TClienteIdCliente;
     private TCliente TCliente;
     private Integer ruc;

    public TJuridica() {
    }

	
    public TJuridica(TCliente TCliente) {
        this.TCliente = TCliente;
    }
    public TJuridica(TCliente TCliente, Integer ruc) {
       this.TCliente = TCliente;
       this.ruc = ruc;
    }
   
    public String getTClienteIdCliente() {
        return this.TClienteIdCliente;
    }
    
    public void setTClienteIdCliente(String TClienteIdCliente) {
        this.TClienteIdCliente = TClienteIdCliente;
    }
    public TCliente getTCliente() {
        return this.TCliente;
    }
    
    public void setTCliente(TCliente TCliente) {
        this.TCliente = TCliente;
    }
    public Integer getRuc() {
        return this.ruc;
    }
    
    public void setRuc(Integer ruc) {
        this.ruc = ruc;
    }




}


