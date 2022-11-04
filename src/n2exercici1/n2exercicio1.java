package n2exercici1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class n2exercicio1 {
	static String rutaEscritura;
	static String directorio;
	static String nombre;
	
	public static void main(String[] args) {		
		//GuardarPropiedades();
		LeerPropiedades();
		ListarDirectorio lista=new ListarDirectorio(directorio, rutaEscritura, nombre);
		
	}
	
	public static void GuardarPropiedades() {
		Properties prop = new Properties();
		prop.setProperty("rutaEscritura","C:/Users/Miguel Angel/Documents");
		prop.setProperty("directorio","C:\\Users\\Miguel Angel\\Music");
		prop.setProperty("nombre","DirectoriosJava.txt");
		
		FileOutputStream os = null;	   	    
		try {
		  os=new FileOutputStream("configuracion.properties");
		  prop.store(os, "Fichero de Propiedades de directorio");
		} catch(IOException ioe) {ioe.printStackTrace();}
	}
	
	public static void LeerPropiedades() {
		Properties properties= new Properties();
		try {
				properties.load(new FileInputStream(new File("configuracion.properties")));
		      
				rutaEscritura = (String) properties.get("rutaEscritura");
				directorio = (String) properties.get("directorio");
				nombre = (String) properties.get("nombre");
				
		    } catch (FileNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
	}
}


