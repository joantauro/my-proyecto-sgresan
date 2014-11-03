/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.HabitacionDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.THabitacion;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class HabitacionBean {

    private List<THabitacion> habitaciones;
    private List<THabitacion> habitacionesdisponibles;
    private List<String> images;
    
    private Date fecInicio;
    private Date fecSalida;
    private String fecIn;
    private String fecSal;
    
    private DualListModel<THabitacion> cities;
    private Date max;
    /**
     * Creates a new instance of HabitacionBean
     */
    public HabitacionBean() {
        List<THabitacion> citiesSource = new ArrayList<THabitacion>();
        List<THabitacion> citiesTarget = new ArrayList<THabitacion>();
        max = new Date();
            fecIn="2016-01-01";
            fecSal="2017-01-01";
             HabitacionDao dao = new HabitacionDao();
       habitacionesdisponibles = dao.listarhabitaciones(fecIn, fecSal);
        for(int i = 0;i<habitacionesdisponibles.size();i++)
        {
            citiesSource.add(habitacionesdisponibles.get(i));
        }
        cities = new DualListModel<THabitacion>(citiesSource, citiesTarget);
        
        /* -----------------------------------------------------------------------  */
        images = new ArrayList<String>();
        for (int i = 1; i <= 4; i++) {
            images.add("habitacion" + i + ".jpg");
        }
        System.out.println(images.get(0));
    }

    public void Actualizar()
    {
        List<THabitacion> citiesSource = new ArrayList<THabitacion>();
        List<THabitacion> citiesTarget = new ArrayList<THabitacion>();
 
       HabitacionDao dao = new HabitacionDao();
       habitacionesdisponibles = dao.listarhabitaciones(fecIn, fecSal);
        for(int i = 0;i<habitacionesdisponibles.size();i++)
        {
            citiesSource.add(habitacionesdisponibles.get(i));
        }
        cities = new DualListModel<THabitacion>(citiesSource, citiesTarget);
        
    }
    
    public List<THabitacion> getHabitaciones() {
        HabitacionDao obj = new HabitacionDao();
        habitaciones = obj.listareserva();
        return habitaciones;
    }

    public List<THabitacion> getHabitacionesdisponibles() {
 HabitacionDao dao = new HabitacionDao();
       habitacionesdisponibles = dao.listarhabitaciones(fecIn, fecSal);
        return habitacionesdisponibles;
    }

    
    public List<String> getImages() {
        
        for (int i = 1; i <= 4; i++) {
            images.add("habitacion" + i + ".jpg");
        }
        System.out.println(images.get(0));
        return images;
    }

    
   public  void BUSQUEDA()
   {
       HabitacionDao dao = new HabitacionDao();
       fecIn=(fecInicio.getYear()+1900) +"/"+(fecInicio.getMonth()+1)+"/"+fecInicio.getDate();
       fecSal=(fecSalida.getYear()+1900) +"/"+(fecSalida.getMonth()+1)+"/"+fecSalida.getDate();
       habitacionesdisponibles = dao.listarhabitaciones(fecIn, fecSal);
       Actualizar();
       System.out.println("Fecha Entrada : "+ fecInicio.getDate() +"/"+(fecInicio.getMonth()+1)+"/"+(fecInicio.getYear()+1900));
       System.out.println("Fecha Salida : "+ fecSalida.getDate() +"/"+(fecSalida.getMonth()+1)+"/"+(fecSalida.getYear()+1900));
       System.out.println(habitacionesdisponibles.size());
   }
 public  void BUSQUEDA2(Date fecE,Date fecS)
   {
       HabitacionDao dao = new HabitacionDao();
       fecIn=(fecE.getYear()+1900) +"/"+(fecE.getMonth()+1)+"/"+fecE.getDate();
       fecSal=(fecS.getYear()+1900) +"/"+(fecS.getMonth()+1)+"/"+fecS.getDate();
       habitacionesdisponibles = dao.listarhabitaciones(fecIn, fecSal);
       Actualizar();
       System.out.println("Fecha Entrada : "+ fecE.getDate() +"/"+(fecE.getMonth()+1)+"/"+(fecE.getYear()+1900));
       System.out.println("Fecha Salida : "+ fecS.getDate() +"/"+(fecS.getMonth()+1)+"/"+(fecS.getYear()+1900));
       System.out.println(habitacionesdisponibles.size());
   }
    
    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecSalida() {
        return fecSalida;
    }

    public void setFecSalida(Date fecSalida) {
        this.fecSalida = fecSalida;
    }

    public DualListModel<THabitacion> getCities() {
        return cities;
    }

    public void setCities(DualListModel<THabitacion> cities) {
        this.cities = cities;
    }

    public String getFecIn() {
        return fecIn;
    }

    public void setFecIn(String fecIn) {
        this.fecIn = fecIn;
    }

    public String getFecSal() {
        return fecSal;
    }

    public void setFecSal(String fecSal) {
        this.fecSal = fecSal;
    }

    public Date getMax() {
        return max;
    }

    public void setMax(Date max) {
        this.max = max;
    }
    
    
    
}
