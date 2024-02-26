package clases;

import java.util.Date;

public class Prestamo {
	private int idLibro;
	private int idSocio;
	private Date fecha;
	private boolean devuelto;

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean getDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	@Override
	public String toString() {
		return "Prestamo [idLibro=" + idLibro + ", idSocio=" + idSocio + ", fecha=" + fecha + ", devuelto=" + devuelto
				+ "]";
	}

}
