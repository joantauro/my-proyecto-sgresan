package Entidad;

import java.math.BigInteger;





public class Estadistica {

	private BigInteger CANTIDAD;

	private String FECHA;
        
        private String TEXTO;
	
	public Estadistica()
	{
		
	}
	
	public Estadistica(BigInteger CANTIDAD,String FECHA,String TEXTO)
	{
		this.CANTIDAD=CANTIDAD;
		this.FECHA=FECHA;
                this.TEXTO=TEXTO;
	}
	
	public BigInteger getCANTIDAD() {
		return CANTIDAD;
	}
	public void setCantidad(BigInteger CANTIDAD) {
		this.CANTIDAD = CANTIDAD;
	}
	public String getFECHA() {
		return FECHA;
	}
	public void setFECHA(String FECHA) {
		this.FECHA = FECHA;
	}

    public String getTEXTO() {
        return TEXTO;
    }

    public void setTEXTO(String TEXTO) {
        this.TEXTO = TEXTO;
    }
        
        
	
}
