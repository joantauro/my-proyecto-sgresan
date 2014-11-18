/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Joel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
    
     Conexion conn = new  Conexion();
        try
        {
            conn.conectar();
            String rutaInfrome="D:\\Archivos de Joel\\Documents\\NetBeansProjects\\trunk\\Web_SGRESAN\\src\\java\\vista\\reporte.jrxml";
            Map parametros = new HashMap();
            parametros.put("id","abc17");
            JasperReport reporteJasper = JasperCompileManager.compileReport(rutaInfrome);
            JasperPrint informe = JasperFillManager.fillReport(reporteJasper, parametros, conn.getConn());
           
            
             JasperExportManager.exportReportToPdfFile(informe,
          "D:\\InformePaisesMySQL.pdf");
            JasperViewer.viewReport(informe,false);
//            JasperViewer ventanavisor = new JasperViewer(informe, false);
//            ventanavisor.setTitle("FACTURA");
//            ventanavisor.setVisible(true);
         
        
        }   
        catch(JRException e)
        {
            System.out.println("Error : "+e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
  
        }
    }
    
}
