/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.TUsuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Joel
 */
public class UsuarioDao {
   public TUsuario buscarporusuario(TUsuario user) {
     
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
        query.setString("pass", user.getContrasena());
        return (TUsuario) query.uniqueResult();
    }
}
