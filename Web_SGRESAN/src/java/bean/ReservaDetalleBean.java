/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import dao.ArchivoDao;
import dao.ClienteDao;
import dao.HabitacionDao;
import dao.ReservaDao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.TCliente;
import model.THabitacion;
import model.THotel;
import model.TPersona;
import model.TReserva;
import model.TReservadetalle;
import model.TUsuario;
import org.primefaces.event.TransferEvent;
import org.primefaces.extensions.event.timeline.TimelineAddEvent;
import org.primefaces.extensions.event.timeline.TimelineModificationEvent;
import org.primefaces.extensions.model.timeline.TimelineEvent;
import org.primefaces.extensions.model.timeline.TimelineModel;
import org.primefaces.model.DualListModel;
import util.email;

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
    private List<TReservadetalle> list;
    private TCliente cli ;
    private String motivo;
     public int nrohabitacion;
     private double igv; private double costoTotal;
    private TimelineModel model;  
    private TimelineEvent event; // current event to be changed, edited, deleted or added  
    private long zoomMax;  
    private Date start; private String startm;
    private Date end;  private String endm; 
    private TimeZone timeZone = TimeZone.getTimeZone("America/Lima");  
    private boolean timeChangeable = true; 
    
    ReservaDao dao  = new ReservaDao();
    
    private DualListModel<THabitacion> cities;
        private String fecIn;
    private String fecSal;
    private List<THabitacion> habitacionesdisponibles;
    
    private double costo;
    private boolean editable;
    long dia;
    private Date max;
    //private boolean editable=true;
    /**
     * Creates a new instance of ReservaDetalleBean
     */
    private String tipohab;
    private String nombreC;
    
    public ReservaDetalleBean() {
        zoomMax=1200000001;
        event = new TimelineEvent();tipohab="";
        costo=0;editable=false;
       igv=0.0;costoTotal=0.0;
     
        
        reserva = new TReservadetalle();
        reserva.setTHabitacion(new THabitacion());
        reserva.setTReserva(new TReserva());
        
        reserv = new TReserva();
        reserv.setTCliente(new TCliente());
        hab = new THabitacion();
        hab.setTHotel(new THotel());
       
        llenar();
         List<THabitacion> citiesSource = new ArrayList<THabitacion>();
        List<THabitacion> citiesTarget = new ArrayList<THabitacion>();
       
            fecIn="2016-01-01";
            fecSal="2017-01-01";
             HabitacionDao daop = new HabitacionDao();
       habitacionesdisponibles = daop.listarhabitaciones(fecIn, fecSal);
        for(int i = 0;i<habitacionesdisponibles.size();i++)
        { 
            citiesSource.add(new THabitacion(habitacionesdisponibles.get(i).getIdHabitacion(), 
                    habitacionesdisponibles.get(i).getTHotel(), 
                    habitacionesdisponibles.get(i).getTTipohabitacion(),
                    habitacionesdisponibles.get(i).getNroHabitacion(),
                    habitacionesdisponibles.get(i).getDescripcion(), 
                    habitacionesdisponibles.get(i).getPrecio()));

        } 
        cities = new DualListModel<THabitacion>(citiesSource, citiesTarget);
    }
    
    public void INICIALIZACION()
    {
        costo=0.0;motivo="";startm="";
        endm="";
        reserva = new TReservadetalle();
        reserva.setTHabitacion(new THabitacion());
        reserva.setTReserva(new TReserva());
        
        reserv = new TReserva();
        reserv.setTCliente(new TCliente());
        cli = new TCliente();
        cli.setTPersona(new TPersona());
    }
    
    
    
    
    public void CAMBIO()
    {
        max=reserv.getFechaEntrada();
       Calendar cal = new GregorianCalendar();
       cal.setTime(max);
       cal.add(Calendar.DATE,1);
       
        System.out.println(cal.getTime());
        reserv.setFechaSalida(cal.getTime());
        BUSQUEDA2(reserv.getFechaEntrada(), reserv.getFechaSalida());
    }
    
  
    public void createTimeline() {
        model = new TimelineModel();
    }
    
    public void HOSPEDAR()
    {
        
        ArchivoDao ar = new ArchivoDao();
        reserv = reserva.getTReserva();
        reserv.setEstado("hospedado");
        ar.ModificarReserva(reserv);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Se hospedo ") );
        llenar();INICIALIZACION();
        
    }
    
    public void onAdd(TimelineAddEvent e) {
        
//        if(e.getStartDate().before(new Date()))
//        {
//            llenar();
//            System.out.println("Ex menor");
//        }else
//        {
//            
            reserv.setFechaEntrada(e.getStartDate());
            //model.add(event); 
            System.out.println("Es mayor");
       // }
         
    }  
    
     public void onEdit(TimelineModificationEvent e) {  
           event = e.getTimelineEvent();  
           reserva =((TReservadetalle)event.getData());
           startm=reserva.getTReserva().getFechaEntrada().getDate()+"/"+(reserva.getTReserva().getFechaEntrada().getMonth()+1)+"/"+(reserva.getTReserva().getFechaEntrada().getYear()+1900);
           endm=reserva.getTReserva().getFechaSalida().getDate()+"/"+(reserva.getTReserva().getFechaSalida().getMonth()+1)+"/"+(reserva.getTReserva().getFechaSalida().getYear()+1900);
           
           ReservaDao rdao = new ReservaDao();
           list= rdao.listarNumeroCuartos(reserva.getTReserva().getIdReserva());
           
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
         reserv.setDescripcion(motivo);
         reserv.setFechaEntrada(start);
         reserv.setFechaSalida(end);
         dao.MoficiarReserva(reserv);
         model = new TimelineModel(); 
         llenar();INICIALIZACION();
     }
     
     
     public void CANCEL()
     {
         reserv.setDescripcion(motivo);
         reserv.setEstado("cancelado");
         System.out.println(reserv.getIdReserva());
         dao.MoficiarReserva(reserv);
         model = new TimelineModel(); 
       llenar();
       INICIALIZACION();
     }
     
     public void registrarprereserva()
     { ClienteDao clidao = new ClienteDao();
       String valor = clidao.buscarCliente(((TPersona)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("persona")).getIdPersona()).getIdCliente(); 
        email e = new email();
 
         cli = clidao.buscarCliente(valor);
   
        reserv.setIdReserva(dao.PK());
        reserv.setEstado("pre-reserva");
        reserv.setFechaRegistro(new Date());
        reserv.setModalidadPago("Deposito");
        reserv.setUsuario(((TUsuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario")).getNombreUsuario());
        reserv.setTCliente(cli);
        reserv.setPrecio(costoTotal);
        //e.send(cli.getTPersona().getEmail(),"Reserva LQR","Buenas Noches \n Su reserva fue registrado exitosamente\nAtte. La Querencia Hermanos");
        dao.InsetartReserva(reserv);
        
        reserva.setTReserva(reserv);
        
         for (int i = 0; i < cities.getTarget().size(); i++) {
            //hab.setNroHabitacion(Integer.parseInt(lista.get(i)));
            reserva.setTHabitacion(cities.getTarget().get(i));
            reserva.setCosto(cities.getTarget().get(i).getPrecio()*dia);
            dao.InsetartReservaDetalle(reserva);
        }
         //INICIALIZACION();
     }
     
     public void registrarreserva()
     { ClienteDao clidao = new ClienteDao();
       String valor = clidao.buscarCliente(((TPersona)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("persona")).getIdPersona()).getIdCliente(); 
         

        TCliente clie = new TCliente();
        clie.setIdCliente(valor);
        reserv.setIdReserva(dao.PK());
        reserv.setEstado("reservado");
        reserv.setFechaRegistro(new Date());
        reserv.setModalidadPago("Deposito");
        reserv.setUsuario(((TUsuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario")).getNombreUsuario()); 
        reserv.setTCliente(clie);
        reserv.setPrecio(costoTotal);
        dao.InsetartReserva(reserv);
        
        reserva.setTReserva(reserv);
        
        
        for (int i = 0; i < cities.getTarget().size(); i++) {
            //hab.setNroHabitacion(Integer.parseInt(lista.get(i)));
            reserva.setTHabitacion(cities.getTarget().get(i));
            reserva.setCosto(cities.getTarget().get(i).getPrecio()*dia);
            dao.InsetartReservaDetalle(reserva);
        }
     }
      public void Actualizar()
    {
        List<THabitacion> citiesSource = new ArrayList<THabitacion>();
        List<THabitacion> citiesTarget = new ArrayList<THabitacion>();
 
       HabitacionDao dao = new HabitacionDao();
       habitacionesdisponibles = dao.listarhabitaciones(fecIn, fecSal);
        for(int i = 0;i<habitacionesdisponibles.size();i++)
        {
            citiesSource.add(new THabitacion(habitacionesdisponibles.get(i).getIdHabitacion(), 
                    habitacionesdisponibles.get(i).getTHotel(), 
                    habitacionesdisponibles.get(i).getTTipohabitacion(),
                    habitacionesdisponibles.get(i).getNroHabitacion(),
                    habitacionesdisponibles.get(i).getDescripcion(), 
                    habitacionesdisponibles.get(i).getPrecio()));
        }
        cities = new DualListModel<THabitacion>(citiesSource, citiesTarget);
        
    }
     
      public  void BUSQUEDA2(Date fecE,Date fecS)
   {
       HabitacionDao daop = new HabitacionDao();
       fecIn=(fecE.getYear()+1900) +"/"+(fecE.getMonth()+1)+"/"+fecE.getDate();
       fecSal=(fecS.getYear()+1900) +"/"+(fecS.getMonth()+1)+"/"+fecS.getDate();
       habitacionesdisponibles = daop.listarhabitaciones(fecIn, fecSal);
       Actualizar();
       System.out.println("Fecha Entrada : "+ fecE.getDate() +"/"+(fecE.getMonth()+1)+"/"+(fecE.getYear()+1900));
       System.out.println("Fecha Salida : "+ fecS.getDate() +"/"+(fecS.getMonth()+1)+"/"+(fecS.getYear()+1900));
       System.out.println(habitacionesdisponibles.size());
       nombre();
   }
 
      public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((THabitacion) item).getNroHabitacion()).append("<br />");
            
        }
        costo=0.0;
        reserv.setSubtotal(costo);
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
       dia=(reserv.getFechaSalida().getTime()-reserv.getFechaEntrada().getTime())/MILLSECS_PER_DAY;
       for (int i = 0; i < cities.getTarget().size(); i++) {
            costo=costo+ cities.getTarget().get(i).getPrecio()*dia;
            
        }
       
       igv=costo*0.18;
       
       costoTotal=costo+igv;
       reserv.setSubtotal(costo);
       reserv.setIgv(igv);
       reserv.setPrecio(costoTotal);
          System.out.println(costo);
          System.out.println("Dias : " + (reserv.getFechaSalida().getTime()-reserv.getFechaEntrada().getTime())/MILLSECS_PER_DAY);
//        FacesMessage msg = new FacesMessage();
//        msg.setSeverity(FacesMessage.SEVERITY_INFO);
//        msg.setSummary("Items Transferred");
//        msg.setDetail(builder.toString());
//         
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }  
      public void nombre()
      {
         ClienteDao dao = new ClienteDao();
         cli = dao.buscarCliente(reserv.getTCliente().getIdCliente());
      }
      public void GUARDARDETALLES()
      {
//          System.out.println(cities.getTarget().get(0));
//          System.out.println(cities.getSource().get(0));
        
        //cli.setIdCliente(reserv.getTCliente().getIdCliente());
        reserv.setIdReserva(dao.PK());
        reserv.setUsuario(((TUsuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario")).getNombreUsuario());
        if(reserv.getModalidadPago().equals("Efectivo"))
        {
            reserv.setEstado("reservado");
        }else
        {
            reserv.setEstado("pre-reserva");
        }
        reserv.setFechaRegistro(new Date());
     
        //reserv.setPrecio(costoTotal);
        reserv.setTCliente(cli);
        dao.InsetartReserva(reserv);
        
        reserva.setTReserva(reserv);
        
         for (int i = 0; i < cities.getTarget().size(); i++) {
            //hab.setNroHabitacion(Integer.parseInt(lista.get(i)));
            reserva.setTHabitacion(cities.getTarget().get(i));
            reserva.setCosto(cities.getTarget().get(i).getPrecio()*dia);
            dao.InsetartReservaDetalle(reserva);
        }
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Se Registro 1 reserva a nombre de  "+cli.getTPersona().getNombres()) );
        llenar();INICIALIZACION();
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
      
        listareservas = dao.listareservafiltros(tipohab);System.out.println("Lista" + listareservas.size());
        for(int i=0;i<listareservas.size();i++)
         {
        if(!"cancelado".equals(listareservas.get(i).getTReserva().getEstado()))
        {
             model.add(new TimelineEvent(listareservas.get(i), listareservas.get(i).getTReserva().getFechaEntrada(), 
                                                              listareservas.get(i).getTReserva().getFechaSalida(), true, 
                                                              listareservas.get(i).getTHabitacion().getIdHabitacion() + "", 
                                                              listareservas.get(i).getTReserva().getEstado())); // eSTADO
        
            System.out.println("N°" + i);}
         }  
    }

    public List<TReservadetalle> getListareservas() {
        
        listareservas = dao.listareservafiltros(tipohab);
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

 

    public int getNrohabitacion() {
        return nrohabitacion;
    }

    public void setNrohabitacion(int nrohabitacion) {
        this.nrohabitacion = nrohabitacion;
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

    public List<THabitacion> getHabitacionesdisponibles() {
        HabitacionDao dao = new HabitacionDao();
       habitacionesdisponibles = dao.listarhabitaciones(fecIn, fecSal);
        return habitacionesdisponibles;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Date getMax() {
        return max;
    }

    public void setMax(Date max) {
        this.max = max;
    }

    public String getTipohab() {
        return tipohab;
    }

    public void setTipohab(String tipohab) {
        this.tipohab = tipohab;
    }

    public TCliente getCli() {
        return cli;
    }

    public void setCli(TCliente cli) {
        this.cli = cli;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public List<TReservadetalle> getList() {
        return list;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getStartm() {
        return startm;
    }

    public void setStartm(String startm) {
        this.startm = startm;
    }

    public String getEndm() {
        return endm;
    }

    public void setEndm(String endm) {
        this.endm = endm;
    }

 
     
     
     
     
}
