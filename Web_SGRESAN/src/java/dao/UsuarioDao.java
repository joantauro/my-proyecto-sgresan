/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.TUsuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.Utilidades;

/**
 *
 * @author Joel
 */
public class UsuarioDao {
    Session sesion;
    Transaction trans;
    Query qry;
    
    public boolean ingresarUsuario (TUsuario usuario) {
       try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            trans = sesion.beginTransaction();
//            String idcl = obtenerIDUsuario();
//            if (idcl.equals("")) {
//                return false;
//            }
//            usuario.setNombreUsuario(idcl);
            sesion.save(usuario);
            trans.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se  agrego Usuario correctamente", "Verificar")); 
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
    
    private String obtenerIDUsuario() {
        String nuevoID = "";
       /* try {*/
            qry = sesion.createSQLQuery("select idusuario();");
            ArrayList<String> idNuevo = (ArrayList<String>) qry.list();
            nuevoID = idNuevo.size() > 0 ? idNuevo.get(0) : "";
      /* } catch (Exception ex) {
            nuevoID = "";
        }*/
        return nuevoID;
    }
    
   public TUsuario buscarporusuario(TUsuario user) throws Exception {
       Utilidades obj = new Utilidades();
        String encriptado = obj.Encriptar(user.getContrasena());
        
       // System.out.println(encriptado);
       // String desencriptado = obj.Desencriptar(encriptado);
       // System.out.println(desencriptado);
        
//      TUsuario usuario = null;
//        final Session sesion = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        try {
//            tx =sesion.beginTransaction();
//            String sql="select u from TUsuario u where nombreUsuario=:user and contrasena=:pass"; 
//       
//        Query query = sesion.createQuery(sql);
//        query.setString("user", user.getNombreUsuario());
//        query.setString("pass", user.getContrasena());
//            usuario = (TUsuario) query.uniqueResult();
//            tx.commit();
//        } catch (Exception e) {
//            if(tx!=null)
//            {
//                tx.rollback();
//            }
//            throw  new RuntimeException(e);
//        } finally {
//            sesion.close();
//        }
//        return usuario;
//       
       
         Session sesion =HibernateUtil.getSessionFactory().openSession();
        String sql="select u from TUsuario u where nombreUsuario=:user and contrasena=:pass"; 
       
        Query query = sesion.createQuery(sql);
        query.setString("user", user.getNombreUsuario());
        query.setString("pass", encriptado);
        return (TUsuario) query.uniqueResult();
        
        
    }
}
