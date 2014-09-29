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
import model.TPersona;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Joel
 */
public class PersonaDao {
    
    Session sesion;
    Transaction trans;
    Query qry;
    
    public boolean ingresarPersona(TPersona persona) {
       try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            trans = sesion.beginTransaction();
            String idcl = obtenerIDPersona();
            if (idcl.equals("")) {
                return false;
            }
            persona.setIdPersona(idcl);
            sesion.save(persona);
            trans.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se  agrego Cliente correctamente", "Verificar")); 
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
    public boolean actualizarPersona(TPersona persona) {
            sesion = HibernateUtil.getSessionFactory().openSession();
            try {
                 sesion.beginTransaction();
                 sesion.merge(persona);
                 sesion.beginTransaction().commit();
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se  Actualizó Cliente "+persona.getNombres()+" correctamente", "Verificar"));    
            } catch (Exception e) {
                 System.out.println("Error en actualizar" + e.getMessage());
                 sesion.beginTransaction().rollback();
                 return false;
             }
            finally {
                 sesion.close();
             }
            return true;
    }
    
    public void actualizarUbigeo(TUbigeo ubigeo) {
        sesion = HibernateUtil.getSessionFactory().openSession();
       /* try {*/
            sesion.beginTransaction();
            sesion.merge(ubigeo);
            sesion.beginTransaction().commit();
      /*  } catch (Exception e) {
            System.out.println("Error en actualizar" + e.getMessage());
            sesion.beginTransaction().rollback();
        }*/
    }
    
    private String obtenerIDPersona() {
        String nuevoID = "";
       /* try {*/
            qry = sesion.createSQLQuery("select idpersona();");
            ArrayList<String> idNuevo = (ArrayList<String>) qry.list();
            nuevoID = idNuevo.size() > 0 ? idNuevo.get(0) : "";
      /* } catch (Exception ex) {
            nuevoID = "";
        }*/
        return nuevoID;
    }
    
    public TPersona BuscaporId(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (TPersona) session.load(TPersona.class, id);
    }
    
    public List listarUbigeo() {
        List<TUbigeo> listaubigeo = null;
       /* try {*/
            sesion = HibernateUtil.getSessionFactory().openSession();
            trans = sesion.beginTransaction();
            qry = sesion.createQuery("FROM TUbigeo");
            listaubigeo = (List<TUbigeo>) qry.list();
       /* } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sesion.close();
       }*/
        return listaubigeo;
    }
    
    public List obtenerPersonaTodos() {
        List<TPersona> listapersona = null;
      /*  try {*/
            sesion = HibernateUtil.getSessionFactory().openSession();
            trans = sesion.beginTransaction();
            qry = sesion.createQuery("FROM TTrabajador");
            listapersona = (List<TPersona>) qry.list();
       /* } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sesion.close();
       }*/
        return listapersona;
    }
}
