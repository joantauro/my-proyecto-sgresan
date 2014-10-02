/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import dao.PersonaDao;
import dao.UsuarioDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.TPersona;
import model.TUbigeo;
import model.TUsuario;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class LoginBean {

   
    public TUsuario usuario;
    public TPersona persona;
    
    private String ruta;
    private boolean sesionI;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        usuario= new TUsuario();
        
        sesionI=true;
        persona = new TPersona();
        persona.setTUsuario(new TUsuario());
        persona.setTUbigeo(new TUbigeo());
    }
    
     public String logueo()
    {
      
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;  
        UsuarioDao dao = new UsuarioDao();
        PersonaDao pers = new PersonaDao();
        usuario= dao.buscarporusuario(usuario);
         
        
        if(usuario != null)
        {
            loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", usuario.getNombreUsuario());  
             persona = pers.BuscaporId(usuario.getNombreUsuario());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            sesionI=false;
            if(persona.getTUsuario().getTipoUsuario().equals("recepcionista"))
            {
                ruta="ReservaRecepcionista.xhtml";
            }else
            {
               ruta="newTemplateClient.xhtml"; 
            }
            
        }else
        {
            loggedIn = false; 
              msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials"); 
              System.out.println("Falla");
              ruta="#";
        }
        //FacesContext.getCurrentInstance().addMessage(null, msg); 
        context.addCallbackParam("loggedIn", loggedIn);  
        return ruta;
    }

     
    public void logoud() {

        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession sesion = (HttpSession) fc.getExternalContext().getSession(false);
        sesion.invalidate();
        //usuario = new TUsuario();
        this.sesionI=true;
        System.out.println(usuario.getNombreUsuario().length());
        context.addCallbackParam("loggedIn", true);  
        //return "index";
        //
    }
     
     public void PRUEBA()
     {
         System.out.println(usuario.getNombreUsuario().length());
     }
     
     
    public TUsuario getUsuario() {
        if(usuario==null)
        {
            usuario = new TUsuario();
        }
        return usuario;
    }

    public void setUsuario(TUsuario usuario) {
        this.usuario = usuario;
    }

    public TPersona getPersona() {
        return persona;
    }

    public void setPersona(TPersona persona) {
        this.persona = persona;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public boolean isSesion() {
        return sesionI;
    }

    public void setSesion(boolean sesion) {
        this.sesionI = sesion;
    }
    
     
     
    
}
