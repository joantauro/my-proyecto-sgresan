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
import util.HibernateUtil;

/**
 *
 * @author Joel
 */
public class ReservaDao {
    public List<TReservadetalle> listareserva()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TReservadetalle").list();
    }
    
    public List<TReserva> listarestadoreserva()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TReserva where Estado<>'reserva'").list();
    }
    
    public void InsetartReserva(TReserva reserva)
    { 
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            
            sesion.save(reserva);
            sesion.beginTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    
    }
    
     public int PK() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int pk = (Integer.parseInt(session.createQuery("select count(*) from TReserva").uniqueResult().toString()))+1;
        return  pk;
    }
    
    public void InsetartReservaDetalle(TReservadetalle reserva)
    { 
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            
            sesion.save(reserva);
            sesion.beginTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    
    }
    
}
