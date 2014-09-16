/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Joel
 */
@ManagedBean
@RequestScoped
public class pue {

    /**
     * Creates a new instance of pue
     */
    public pue() {
    }
    
    public String navega() {
      return "Reserva.xhtml";
   }
}
