/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ClienteDao;
import dao.PersonaDao;
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

/**
 *
 * @author Monica
 */
@ManagedBean
@SessionScoped

public class PersonaBean {
    
    private TPersona persona;
    private List<TUbigeo> listarUbigeoSel;
    private List<TCliente> listaclientes;
    private DataModel listapersona;
    private boolean esEdicion;
    
    PersonaDao dao  = new PersonaDao();
    
    @PostConstruct
    public void init() {
        persona = new TPersona();
        persona.setTUbigeo(new TUbigeo());
    }
    
    public void irAgregar() {

        persona.setIdPersona("ab123");
        persona.setEstado("Activo");
        dao.ingresarPersona(persona);
    }
    
    public String irActualizar() {
        setEsEdicion(true);
      //  setPersona((TPersona) listaclientes.getRowData());
        int codigoUb = persona.getTUbigeo().getIdTUbigeo();
//    corregir    persona.setTUbigeo(new TUbigeo(codigoUb, "", false));
        String cod = persona.getIdPersona();
        persona.setIdPersona(cod);
        return "nuevapersona";

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
        persona = obj.BuscaporId(id);
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
   
    
}
