/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.HabitacionDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.THabitacion;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class HabitacionBean {

    private List<THabitacion> habitaciones;
    
    private List<String> images;
    /**
     * Creates a new instance of HabitacionBean
     */
    public HabitacionBean() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 4; i++) {
            images.add("habitacion" + i + ".jpg");
        }
    }

    public List<THabitacion> getHabitaciones() {
        HabitacionDao obj = new HabitacionDao();
        habitaciones = obj.listareserva();
        return habitaciones;
    }

    public List<String> getImages() {
         
            images.add("habitacion1.jpg");
         
        
        return images;
    }
    
}
