/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.TCliente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Joel
 */
public class ClienteDao {
    
    Session sesion;
    Transaction trans;
    Query qry;

    public boolean ingresarCliente(TCliente cliente) {
       try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            trans = sesion.beginTransaction();
            String idcl = obtenerIDCliente();
            if (idcl.equals("")) {
                return false;
            }
//            corregir     cliente.setCdCliente(idcl);
            sesion.save(cliente);
            trans.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se  agrego Trabajador correctamente", "Verificar")); 
        } catch (Exception ex) {
            //despues agrego para que salgan mensajes de error            
            trans.rollback();
            ex.printStackTrace();
            return false;
        } finally {
            sesion.close();
        }
        return true;
    }
    
        private String obtenerIDCliente() {
        String nuevoID = "";
       /* try {*/
            qry = sesion.createSQLQuery("select idcliente();");
            ArrayList<String> idNuevo = (ArrayList<String>) qry.list();
            nuevoID = idNuevo.size() > 0 ? idNuevo.get(0) : "";
      /* } catch (Exception ex) {
            nuevoID = "";
        }*/
        return nuevoID;
    }
    public List<TCliente> listareserva()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TCliente").list();
    }
    
    public TCliente buscarCliente(String id)
    {
        Session sesion =HibernateUtil.getSessionFactory().openSession();
        String sql="select u from TCliente u where TPersona=:user"; 
       
        Query query = sesion.createQuery(sql);
        query.setString("user", id);
       
        return (TCliente) query.uniqueResult();
    }
}
