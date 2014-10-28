/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ClienteDao;
import dao.PersonaDao;
import dao.UsuarioDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.TCliente;
import model.TPersona;
import model.TUbigeo;
import model.TUsuario;

/**
 *
 * @author Monica
 */
@ManagedBean
@SessionScoped

public class PersonaBean {
    
    private TPersona persona;
    private TUsuario usuario;
    private TCliente cliente;
    private List<TUbigeo> listarUbigeoSel;
    private List<TCliente> listaclientes;
    private DataModel listapersona;
    private boolean esEdicion;
    
    PersonaDao dao  = new PersonaDao();
    
    @PostConstruct
    public void init() {
        usuario = new TUsuario();
        persona = new TPersona();
        persona.setTUbigeo(new TUbigeo());
        cliente = new TCliente();
        cliente.setTPersona(new TPersona());
    }
    
    public void LIMPIAR()
    {
        usuario = new TUsuario();
        persona = new TPersona();
        persona.setTUbigeo(new TUbigeo());
        cliente = new TCliente();
        cliente.setTPersona(new TPersona());
    }
    
    public boolean esVistaValida(){
        boolean resultado = true;
        if(!esNombreValido()){
            resultado = false;
        }
        return resultado;
    }
    
    public boolean esNombreValido()
    {
        boolean resultado = true;
        if(usuario.getNombreUsuario() == null || usuario.getNombreUsuario().trim().length() == 0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Debe ingresar el nombre"));
            resultado = false;
        }
        
        return resultado;
    }
    
    public void irAgregar() {
        if(!esVistaValida()){
            return;
        }
        UsuarioDao usuariodao = new UsuarioDao();
        usuario.setIdUsuario(usuario.getNombreUsuario());
        usuario.setEstado("Activo");
        usuario.setTipoUsuario("cliente");
        usuariodao.ingresarUsuario(usuario);
       
        
        //persona.setIdPersona(usuario.getNombreUsuario());
        persona.setTUsuario(usuario);
        persona.setEstado("Activo");
        dao.ingresarPersona(persona);
        
       
        
        ClienteDao clientedao = new ClienteDao();
        cliente.setIdCliente(usuario.getIdUsuario());
        cliente.setTPersona(persona);
        clientedao.ingresarCliente(cliente);
        
        
        usuario = new TUsuario();
        persona = new TPersona();
        persona.setTUbigeo(new TUbigeo());
        cliente = new TCliente();
        cliente.setTPersona(new TPersona());
    }
    
    public void irActualizar(String id) {
        PersonaDao obj = new PersonaDao();
//        obj.actualizarPersona(persona);
//        persona = new TPersona();
        persona = obj.buscarPorId(id);
        System.out.println(persona.getNombres());
        System.out.println(persona.getTUbigeo().getNombre());
    }
    
    public void ACTUALIZAR()
    {
        PersonaDao dao = new PersonaDao();
        dao.actualizarPersona(persona);
        
        usuario = new TUsuario();
        persona = new TPersona();
        persona.setTUbigeo(new TUbigeo());
        cliente = new TCliente();
        cliente.setTPersona(new TPersona());
    }
    public DataModel getListapersona() {
         PersonaDao profMgd = new PersonaDao();
        listapersona = new ListDataModel(profMgd.obtenerPersonaTodos());
        return listapersona;
    }

    public void setListapersona(DataModel listapersona) {
        this.listapersona = listapersona;
    }
    
    public void prepararPersona(String id) {
        PersonaDao obj = new PersonaDao();
        persona = obj.buscarPorId(id);
    }

    public TPersona getPersona() {
        return persona;
    }

    public void setPersona(TPersona persona) {
        this.persona = persona;
    }

    public List<TUbigeo> getListarUbigeoSel() {
        PersonaDao objTrb = new PersonaDao();
        listarUbigeoSel = objTrb.listarUbigeo();
        return listarUbigeoSel;
    }

     public void setListarUbigeoSel(List<TUbigeo> listarUbigeoSel) {
        this.listarUbigeoSel = listarUbigeoSel;
    }
    
    public String ingresar() {
        PersonaDao cliMgd = new PersonaDao();
        boolean resultado = isEsEdicion() ? cliMgd.actualizarPersona(persona) 
                            : cliMgd.ingresarPersona(persona);
        if (resultado) {
            return "persona";
        } else {
            return ""; //futuros errores
        }
    }

    public String getAccion() {
         return isEsEdicion() ? "Actualizar" : "Registrar";
    }

    public boolean isEsEdicion() {
        return esEdicion;
    }

    public void setEsEdicion(boolean esEdicion) {
        this.esEdicion = esEdicion;
    }

    public List<TCliente> getListaclientes() {
        ClienteDao dao =  new ClienteDao();
        listaclientes = dao.listarcliente();
        return listaclientes;
    }

    public TUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TUsuario usuario) {
        this.usuario = usuario;
    }
   
    
}
