package n1exercici5;

import java.io.*;

public class InputSerializable
{
	private FileInputStream file;
	private ObjectInputStream input;
	
	public void abrir()throws IOException	
	{
		file = new FileInputStream( "directorios.ser" );
		input = new ObjectInputStream (file);
	}
	
	public void cerrar() throws IOException
	{
		if (input!=null )
			input.close();
	}
	
	public Directorio leer () throws IOException, ClassNotFoundException
	{
		Directorio directorio = null;
		if (input!=null) {
			try {
				directorio = (Directorio) input.readObject();
				System.out.println("Fichero .ser, deserializado\n"+directorio.getContenidoDirectorio());
				
			} catch (EOFException eof) {
				// Fin del fichero
			}
		}
		return directorio;
	}
}
