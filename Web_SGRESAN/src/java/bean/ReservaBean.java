/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class ReservaBean {

    
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
       sino="no";
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
    
    
    
    
}
