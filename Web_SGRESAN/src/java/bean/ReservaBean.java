/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import dao.ReservaDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TReserva;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class ReservaBean {

    private TReserva reserva;
    private List<TReserva> estadodereservas;
    private List<TReserva> reservas;
    
    public ArrayList<String> lista ;
    
    public int nrohabitacion;
    public String sino;
    public boolean editable;
    /**
     * Creates a new instance of ReservaBean
     */
    public ReservaBean() {
       nrohabitacion=1;
       createLista(nrohabitacion);
       editable=true;
       sino="";
       
       reserva = new TReserva();
    }

    public void InsertarReserva()
    {
        ReservaDao dao = new ReservaDao();
        dao.InsetartReserva(reserva);
         
    }
    
    
    public void createLista(int n)
    {
 
        lista= new ArrayList<String>();
        for(int i=0;i<n;i++)
        {
            lista.add("dobles");
        } 
    }
    
   
    public void HabilitarCuartos(String n)
    {
        sino=n;
        if(sino.equals("si"))
        {
            editable=false;
            nrohabitacion=2;
           
            
        }else
        {
            editable=true;
            nrohabitacion=1;
        }
         ElegirNroCuarto(nrohabitacion);
        //editable = !sino.equals("si");
    }
 
 
    public void ElegirNroCuarto(int n)
    {
        
         
        nrohabitacion=n;
         if(n==1){sino="no";}else{sino="si";}
         createLista(n);
       // FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lista", lista);
        System.out.println("Tamaño : " + lista.size());
        System.out.println("Nro : " + nrohabitacion); 
    }
    
    
    
    
    public void METODO()
    {
        
        
//        System.out.println("Tamaño : " + lista.size());
//        System.out.println("Nro : " + nrohabitacion); 
        for(int i=0;i<nrohabitacion;i++)
        {
            System.out.println(lista.get(i));
        }
    }
    
    
    public ArrayList<String> getLista() {
//        lista= new ArrayList<String>();
//        for(int i=0;i<nrohabitacion;i++)
//        {
//            lista.add("dobles");
//        } 
         
        return lista;
    }

    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
    }

    public int getNrohabitacion() {
        return nrohabitacion;
    }

    public void setNrohabitacion(int nrohabitacion) {
        this.nrohabitacion = nrohabitacion;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getSino() {
        return sino;
    }

    public void setSino(String sino) {
        this.sino = sino;
    }
    
     public TReserva getReserva() {
        return reserva;
    }

    public void setReserva(TReserva reserva) {
        this.reserva = reserva;
    }

    public List<TReserva> getEstadodereservas() {
        ReservaDao dao = new ReservaDao();
        estadodereservas=dao.listarestadoreserva();
        
        return estadodereservas;
    }

    public List<TReserva> getReservas() {
        ReservaDao dao = new ReservaDao();
        reservas=dao.listareserva(sino);
        return reservas;
    }
    
    public void LLENAR()
    {
        getReservas();
    }
}
