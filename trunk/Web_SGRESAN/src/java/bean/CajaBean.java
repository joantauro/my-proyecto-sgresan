/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CajaDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.TCaja;
import model.TUsuario;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class CajaBean {

    private TCaja caja;
    private List<TCaja> listacaja;
    
 private double saldoR;
 private double arqueo;
 public boolean AC;
 public boolean CC;
    /**
     * Creates a new instance of CajaBean
     */
    public CajaBean() {
        caja = new TCaja();
        saldoR=0.0;arqueo=0.0;
        COMPROBAR();
    }

    public void COMPROBAR()
    {
       
        CajaDao dao = new CajaDao();
        if(dao.PK("Ap", "00:00:00")==0)
        {
            AC = true;
            CC=false;
        }else
        {
            if (dao.PK("Ap", "00:00:00") == 1)
            {
                if(dao.PK("Ci", "00:00:00") == 0)
                {
                    AC = false;
                    CC=true;
                }else
                {
                    AC = true;
                     CC=false;
                }
            }else
            {
           String d = dao.fech().getHours() + ":" + dao.fech().getMinutes() + ":" + dao.fech().getSeconds();

                if(dao.PK("Ci", d) == 0)
                {
                    AC = false;
                    CC=true;
                }else
                {
                    AC = true;
                     CC=false;
                }
            }
//             else
//            {
//                String d = dao.fech().getHours() + ":" + dao.fech().getMinutes() + ":" + (dao.fech().getSeconds() - 1);
//                if (dao.PK("Ap", d) == 0) {
//                    if (dao.PK("Ci", d) == 0) {
//                        AC = false;
//                        CC = true;
//                        System.out.println("Esta aca 1");
//                    } else {
//                        AC = true;
//                        CC = false;
//                        System.out.println("Esta aca 2");
//                    }
//                }
//            }
        }
        System.out.println(AC);
    }

    public boolean isCC() {
        return CC;
    }

    public void setCC(boolean CC) {
        this.CC = CC;
    }

  
    
    public boolean isAC() {
        return AC;
    }

    public void setAC(boolean AC) {
        this.AC = AC;
    }
    
    public TCaja getCaja() {
        return caja;
    }

    public void setCaja(TCaja caja) {
        this.caja = caja;
    }
 
    
    public void APERTURAR()
    {   CajaDao dao = new CajaDao();
        caja.setDescripcion("Apertura de Caja");
        caja.setSaldo(dao.Saldo());
        COMPROBAR();
    }
    
    public void CERRAR()
    {   CajaDao dao = new CajaDao();
        caja.setDescripcion("Cierre de Caja");
        caja.setSaldo(dao.Saldo());
    }
    
    public void CIERRE()
    {
        arqueo = caja.getSaldo()-getSaldoR();
    }
    
    public void INSERTAR()
    {
        CajaDao dao = new CajaDao();
        caja.setUsuario(((TUsuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario")).getNombreUsuario());
        dao.InsetartReserva(caja);
        COMPROBAR();
        LIMPIAR();
    }
    public void LIMPIAR()
    {
        caja= new TCaja();
    }
    public List<TCaja> getListacaja() {
        CajaDao dao = new CajaDao();
        listacaja = dao.listarHoy();
        return listacaja;
    }

    public double getSaldoR() {
        return saldoR;
    }

    public void setSaldoR(double saldoR) {
        this.saldoR = saldoR;
    }

    public double getArqueo() {
        return arqueo;
    }

    public void setArqueo(double arqueo) {
        this.arqueo = arqueo;
    }

 
 
    
    
}
