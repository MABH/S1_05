package n1exercici5;

import java.io.Serializable;

public class Directorio implements Serializable{
	private String contenidoDirectorio;

	public Directorio(String contenidoDirectorio) {
		this.contenidoDirectorio = contenidoDirectorio;
	}
	
	public String getContenidoDirectorio() {
		return contenidoDirectorio;
	}

	public void setContenidoDirectorio(String contenidoDirectorio) {
		this.contenidoDirectorio = contenidoDirectorio;
	}
}
