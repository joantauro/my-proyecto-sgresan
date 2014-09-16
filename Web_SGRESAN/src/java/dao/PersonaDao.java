/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.TPersona;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Joel
 */
public class PersonaDao {
    public TPersona BuscaporId(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (TPersona) session.load(TPersona.class, id);
    }
}
