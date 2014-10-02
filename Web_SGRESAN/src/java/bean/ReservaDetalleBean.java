/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import dao.ClienteDao;
import dao.HabitacionDao;
import dao.ReservaDao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.TCliente;
import model.THabitacion;
import model.THotel;
import model.TReserva;
import model.TReservadetalle;
import model.TUsuario;
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
    private TReserva reserv;
    private THabitacion hab;
     public ArrayList<String> lista ;
    
    
     public int nrohabitacion;
     
    private TimelineModel model;  
    private TimelineEvent event; // current event to be changed, edited, deleted or added  
    private long zoomMax;  
    private Date start;  
    private Date end;  
    private TimeZone timeZone = TimeZone.getTimeZone("America/Lima");  
    private boolean timeChangeable = true; 
    
    ReservaDao dao  = new ReservaDao();
    //private boolean editable=true;
    /**
     * Creates a new instance of ReservaDetalleBean
     */
    public ReservaDetalleBean() {
        event = new TimelineEvent();
        
       nrohabitacion=1;
       createLista(nrohabitacion);
        
        reserva = new TReservadetalle();
        reserva.setTHabitacion(new THabitacion());
        reserva.setTReserva(new TReserva());
        
        reserv = new TReserva();
        reserv.setTCliente(new TCliente());
        hab = new THabitacion();
        hab.setTHotel(new THotel());
       
        llenar();
    }
    
    
    public void createLista(int n)
    {
       
        //HabitacionDao dao = new HabitacionDao();
        lista= new ArrayList<String>();
        for(int i=0;i<n;i++)
        {
           // lista.add(dao.listareserva().get(i).getDescripcion());
            lista.add("dobles");
        } 
    }
    
    public void PRECIO()
    {   
        try
        {
            double suma=0;
//        reserv.setPrecio(i);
//        i++;
        System.out.println(lista.size());
        HabitacionDao o = new HabitacionDao();
         for (int i = 0; i < nrohabitacion; i++) {
            if (!"".equals(lista.get(i))) {
                suma = suma + o.Precio(Integer.parseInt(lista.get(i)));
            } else {
                suma+=0;
            }

        }
         reserv.setPrecio(suma);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
     public void ElegirNroCuarto(int n)
    {
        System.out.println("Valor de n : "+n);
        nrohabitacion=n;
         createLista(n);
        System.out.println("Tamaño : " + lista.size());
        System.out.println("Nro : " + nrohabitacion); 
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
            
            reserv.setFechaEntrada(e.getStartDate());
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
        
        //reserva = dao.BuscaporId(((TReservadetalle)event.getData()).getIdTReservaDetalle());
        reserva =((TReservadetalle)event.getData());
        reserv = reserva.getTReserva();
        
       //  System.out.println(reserva.getIdTReservaDetalle());
       //  System.out.println(((TReservadetalle)event.getData()).getIdTReservaDetalle());
    } 
    
     public void onChange(TimelineModificationEvent e) {
        event = e.getTimelineEvent();  
        reserva =((TReservadetalle)event.getData());
        reserv = reserva.getTReserva();
        
        start = event.getStartDate();
        end = event.getEndDate();
//        FacesMessage msg =  
//            new FacesMessage(FacesMessage.SEVERITY_INFO, "The booking dates " + cuarto.getCuarto() + " have been updated", null);  
//        FacesContext.getCurrentInstance().addMessage(null, msg);  

    }
     public void REPROGRAMAR()
     {
         reserv.setFechaEntrada(start);
         reserv.setFechaSalida(end);
         dao.MoficiarReserva(reserv);
         model = new TimelineModel(); 
         llenar();
     }
     
     public void CANCEL()
     {
         reserv.setEstado("cancelado");
         System.out.println(reserv.getIdReserva());
         dao.MoficiarReserva(reserv);
         model = new TimelineModel(); 
       llenar();
     }
     
     public void registrarprereserva()
     { ClienteDao clidao = new ClienteDao();
       int valor = clidao.buscarCliente(((TUsuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario")).getNombreUsuario()).getIdCliente(); 
         

        TCliente cli = new TCliente();
        cli.setIdCliente(valor);
        reserv.setIdReserva(dao.PK());
        reserv.setEstado("pre-reserva");
        reserv.setDescripcion("Ninguna");
        reserv.setTCliente(cli);
        dao.InsetartReserva(reserv);
        
        reserva.setTReserva(reserv);
        
        
        
        for (int i = 0; i < nrohabitacion; i++) {
            hab.setNroHabitacion(Integer.parseInt(lista.get(i)));
            reserva.setTHabitacion(hab);
            dao.InsetartReservaDetalle(reserva);
        }
     }
     
    public void saveDetails() {  
        
        
        TCliente cli = new TCliente();
        cli.setIdCliente(reserv.getTCliente().getIdCliente());
        reserv.setIdReserva(dao.PK());
        reserv.setEstado("pre-reserva");
        reserv.setDescripcion("Ninguna");
        reserv.setTCliente(cli);
        dao.InsetartReserva(reserv);
        
        reserva.setTReserva(reserv);
        
        
        
        for (int i = 0; i < nrohabitacion; i++) {
            hab.setNroHabitacion(Integer.parseInt(lista.get(i)));
            reserva.setTHabitacion(hab);
            dao.InsetartReservaDetalle(reserva);
        }
        
        model = new TimelineModel(); 
        /*for(int i=0;i<cdao.listar().size();i++)
         {
           model.add(new TimelineEvent(cdao.listar().get(i), cdao.listar().get(i).getStart(), cdao.listar().get(i).getEnd()));
         }*/
        llenar();
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
      
        listareservas = dao.listareserva();System.out.println("Lista" + listareservas.size());
        for(int i=0;i<listareservas.size();i++)
         {
        if(!"cancelado".equals(listareservas.get(i).getTReserva().getEstado()))
        {
             model.add(new TimelineEvent(listareservas.get(i), listareservas.get(i).getTReserva().getFechaEntrada(), 
                                                              listareservas.get(i).getTReserva().getFechaSalida(), true, 
                                                              listareservas.get(i).getTHabitacion().getNroHabitacion() + "", 
                                                              listareservas.get(i).getTReserva().getEstado())); // eSTADO
        
            System.out.println("N°" + i);}
         }
      
//        for (TReservadetalle listareserva : listareservas) {
//            model.add(new TimelineEvent(listareservas.get(i), listareserva.getTReserva().getFechaEntrada(), 
//                                                              listareserva.getTReserva().getFechaSalida(), true, 
//                                                              listareserva.getTHabitacion().getNroHabitacion() + "", 
//                                                              listareserva.getTReserva().getEstado())); // eSTADO
//        }
        
    }

    public List<TReservadetalle> getListareservas() {
        
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

    public TReserva getReserv() {
        return reserv;
    }

    public void setReserv(TReserva reserv) {
        this.reserv = reserv;
    }

    public THabitacion getHab() {
        return hab;
    }

    public void setHab(THabitacion hab) {
        this.hab = hab;
    }

    public ArrayList<String> getLista() {
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

 
     
     
     
     
}
