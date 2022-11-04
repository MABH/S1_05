package n1exercici5;
import java.io.*;

public class OutputSerializable {
	
	private FileOutputStream file;
	private ObjectOutputStream output;
	
	// Abrir el fichero
	public void abrir()	throws IOException
	{
		file = new FileOutputStream( "directorios.ser" );
		output = new ObjectOutputStream(file);
	}
	
	// Cerrar el fichero
	public void cerrar() throws IOException
	{
		if (output!=null)
			output.close();
	}
	
	// Escribir en el fichero
	public void escribir (Directorio contenidoDirectorio) throws IOException
	{
		if (output!=null)
			output.writeObject(contenidoDirectorio);
	}
}
