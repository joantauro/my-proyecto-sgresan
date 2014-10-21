/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ArchivoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TCliente;
import model.TReserva;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Joel
 */
@ManagedBean
@SessionScoped
public class ArchivoBean {
private UploadedFile file;
private TReserva reserva;
private List<TReserva> reservas;
    /**
     * Creates a new instance of ArchivoBean
     */
    public ArchivoBean() {
        reserva = new TReserva();
        reserva.setTCliente(new TCliente());
    }

    public void AGREGAR_BOLETA()
    {
          byte[] bytes = file.getContents();
//        String tip = file.getContentType();
//        dato.setFecha(new java.util.Date());
//        
//        dato.setNombreArchivo(file.getFileName());
//        dato.setArchivo(bytes);
//        dato.setTipoArchivo(tip);
//        obj.Insertar(dato);
// 
//        
//        dato = new Dato();
    }

    public List<TReserva> getReservas() {
        ArchivoDao obj = new ArchivoDao();
        reservas=obj.listareserva("1");
        return reservas;
    }
    
    
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public TReserva getReserva() {
        return reserva;
    }

    public void setReserva(TReserva reserva) {
        this.reserva = reserva;
    }
    
    
}
