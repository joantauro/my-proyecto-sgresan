/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import dao.ReservaDao;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.THabitacion;
import model.TReserva;
import model.TReservadetalle;
import org.primefaces.extensions.event.timeline.TimelineAddEvent;
import org.primefaces.extensions.event.timeline.TimelineModificationEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class ReservaDetalleBean {

    private List<TReservadetalle> listareservas;
    private TReservadetalle reserva;
    
    
    private TimelineModel model;  
    private TimelineEvent event; // current event to be changed, edited, deleted or added  
    private long zoomMax;  
    private Date start;  
    private Date end;  
    private TimeZone timeZone = TimeZone.getTimeZone("America/Lima");  
    private boolean timeChangeable = true; 
    
    //private boolean editable=true;
    /**
     * Creates a new instance of ReservaDetalleBean
     */
    public ReservaDetalleBean() {
        event = new TimelineEvent();
        reserva = new TReservadetalle();
        reserva.setTHabitacion(new THabitacion());
        reserva.setTReserva(new TReserva());
        
        llenar();
    }
    
    
    
    public void createTimeline() {
        model = new TimelineModel();
    }
    
    public void onAdd(TimelineAddEvent e) {
        
        if(e.getStartDate().before(new Date()))
        {
            llenar();
            System.out.println("Ex menor");
        }else
        {
            model.add(event); 
            System.out.println("Es mayor");
        }
         
    }  
    
     public void onEdit(TimelineModificationEvent e) {  
           event = e.getTimelineEvent();
    } 
    
     public void onDelete(TimelineModificationEvent e) {  
        // get clone of the TimelineEvent to be deleted  
        event = e.getTimelineEvent();
    } 
     public void llenar()
    {// set initial start / end dates for the axis of the timeline  
         Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));  
        Date now = new Date();  
  
        // groups  
        String[] NAMES = new String[] {"1", "2", "3", "4", "5", "6"};  
  
        // create timeline model  
        model = new TimelineModel();  
        
        cal.setTimeInMillis(now.getTime() - 4 * 60 * 60 * 1000);  
        start = cal.getTime();  
  
        cal.setTimeInMillis(now.getTime() + 8 * 60 * 60 * 40000);  
        end = cal.getTime();  
          //  event = new TimelineEvent("Joel", start, end, true, "1", "available");
        ReservaDao dao = new ReservaDao();
        listareservas = dao.listareserva();
        for (TReservadetalle listareserva : listareservas) {
            model.add(new TimelineEvent(listareserva.getTReserva().getTCliente().getTPersona().getNombres(), listareserva.getTReserva().getFechaEntrada(), listareserva.getTReserva().getFechaSalida(), true, listareserva.getTHabitacion().getNroHabitacion() + "", "maybe")); // eSTADO
        }
        
    }

    public List<TReservadetalle> getListareservas() {
        ReservaDao dao = new ReservaDao();
        listareservas = dao.listareserva();
        return listareservas;
    }

    public void setListareservas(List<TReservadetalle> listareservas) {
        this.listareservas = listareservas;
    }

    public TimelineModel getModel() {
        return model;
    }

    public void setModel(TimelineModel model) {
        this.model = model;
    }

    public TimelineEvent getEvent() {
        return event;
    }

    public void setEvent(TimelineEvent event) {
        this.event = event;
    }

    public long getZoomMax() {
        return zoomMax;
    }

    public void setZoomMax(long zoomMax) {
        this.zoomMax = zoomMax;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isTimeChangeable() {
        return timeChangeable;
    }

    public void setTimeChangeable(boolean timeChangeable) {
        this.timeChangeable = timeChangeable;
    }

    public TReservadetalle getReserva() {
        return reserva;
    }

    public void setReserva(TReservadetalle reserva) {
        this.reserva = reserva;
    }
     
     
     
     
}
