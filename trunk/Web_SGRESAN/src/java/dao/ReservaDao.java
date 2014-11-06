/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.THabitacion;
import model.TReserva;
import model.TReservadetalle;
import model.TReservalog;
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

     public List<THabitacion> listarhabitacionesconfiltros(String id,String fecEnt,String fecSal)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("select th from THabitacion th \n" +
                                    " inner join th.TTipohabitacion tt"
                                    + "  where idHabitacion not in (\n" +
                                   "select hab.idHabitacion from TReservadetalle  reservdet\n" +
                                   "inner join reservdet.TReserva rerserv\n" +
                                   "inner join reservdet.THabitacion hab\n" +
                                   " where (fechaEntrada <  '"+fecEnt+"' and fechaSalida >  '"+fecEnt+"')\n" +
"or (fechaEntrada < '"+fecSal+"' and fechaSalida > '"+fecSal+"') \n" +
"or (fechaEntrada between  '"+fecEnt+"' and '"+fecSal+"' and fechaSalida between '"+fecEnt+"' and '"+fecSal+"') \n" +
"or (fechaEntrada < '"+fecEnt+"' and fechaSalida > '"+fecSal+"') )  and tt.nombre like '%"+id+"%'").list();
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
                tx.rollback();System.out.println(e.getMessage());
            }System.out.println(e.getMessage());
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
    
    public List<TReserva> listareserva(String id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TReserva where ModalidadPago like '%"+id+"%'").list();
    } 
     public List<TReservadetalle> listarNumeroCuartos(String id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TReservadetalle where TReserva='"+id+"'").list();
    }
     public List<TReservalog> listareservalog()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TReservalog").list();
    } 
}
