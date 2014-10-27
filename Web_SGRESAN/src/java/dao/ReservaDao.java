/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.TReserva;
import model.TReservadetalle;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Joel
 */
public class ReservaDao {
    public List<TReservadetalle> listareserva()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TReservadetalle ").list();
    }
    
    public List<TReservadetalle> listareservafiltros(String id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("select r from TReservadetalle  r\n"
                + "inner join r.THabitacion  j\n"
                + "inner join j.TTipohabitacion t\n"
                + "where t.nombre like '%" + id + "%'").list();
    }

    public List<TReserva> listarestadoreserva()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TReserva where Estado='pre-reserva'").list();
    }
    
    public void InsetartReserva(TReserva reserva)
    { 
          Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx =sesion.beginTransaction();
            sesion.save(reserva);
            tx.commit();
        } catch  (Exception e) {
            if(tx!=null)
            {
                tx.rollback();
            }
        } finally {
            sesion.close();
        }
    
    }
    
    public void MoficiarReserva(TReserva reserva)
    { 
         Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx =sesion.beginTransaction();
            sesion.merge(reserva);
            tx.commit();
        } catch  (Exception e) {
            if(tx!=null)
            {
                tx.rollback();
            }
        } finally {
            sesion.close();
        }
    }
    
     public String PK() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int pk = (Integer.parseInt(session.createQuery("select count(*) from TReserva ").uniqueResult().toString()))+1;
        return  "abc"+pk;
    }
    
    public void InsetartReservaDetalle(TReservadetalle reserva)
    { 
          Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx =sesion.beginTransaction();
            sesion.save(reserva);
            tx.commit();
        } catch  (Exception e) {
            if(tx!=null)
            {
                tx.rollback();
            }
        } finally {
            sesion.close();
        }
    
    }
    
    public TReservadetalle BuscaporId(int id) {
        
        TReservadetalle reserva = null;
        final Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx =sesion.beginTransaction();
            reserva = (TReservadetalle) sesion.load(TReservadetalle.class, id);
            tx.commit();
        } catch (Exception e) {
            if(tx!=null)
            {
                tx.rollback();
            }
            throw  new RuntimeException(e);
        } finally {
            sesion.close();
        }
        return reserva;
    }
    
}
