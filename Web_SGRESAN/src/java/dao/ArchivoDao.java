/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TReserva;
import model.TReservadetalle;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Joel
 */
public class ArchivoDao {
    public List<TReserva> listareserva(String id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TReserva where TCliente='"+id+"'").list();
    }
}
