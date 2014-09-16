/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UsuarioDao;

import java.util.List;
import model.TUsuario;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Joel
 */
public class dao {
    
     List<TUsuario> listarusuario()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from TUsuario").list();
    }
}
