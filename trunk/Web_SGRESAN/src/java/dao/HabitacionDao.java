/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.THabitacion;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Joel
 */
public class HabitacionDao {
    public List<THabitacion> listareserva()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from THabitacion").list();
    }
    
    public int Precio(int Hab) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int pk = (Integer.parseInt(session.createQuery("select precio from THabitacion where NroHabitacion="+Hab).uniqueResult().toString()))+1;
        return  pk;
    }
}
