package n1exercici5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ListarDirectorio {
	private String directorio;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private String datos="";
	private Directorio contenidoDirectorio = new Directorio("");
	
	public ListarDirectorio(String directorio) {		
		this.directorio = directorio;		
		File carpeta = new File(this.directorio);		
		String tabulador = "	";		
		
		if(carpeta.exists()) {
			File[] archivos = carpeta.listFiles();
			CrearTxt(archivos, tabulador);		    
			GuardarDatos();
		}
		else {
			System.out.println("El directorio "+this.directorio+" no existe.");		    
		}
	}
	
	/***-Gestión de ficheros-***/
	public void CrearTxt(File[] archivos, String tabulador) {
		File[] nuevo_directorio;
		String nuevo_separador = tabulador;
		
		if (archivos == null || archivos.length == 0) {
			datos=datos+nuevo_separador+"   - No hay elementos dentro de esta carpeta.-";
		    return;
		}
		else {
			nuevo_separador = nuevo_separador + "	";
		    for (int i=0; i< archivos.length; i++) {			
		    	sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				File archivo = archivos[i];
				datos=datos+nuevo_separador+String.format("%s (%s) -  %s",
							archivo.getName(),
				            archivo.isDirectory() ? "Carpeta" : "Archivo",
				            sdf.format(archivo.lastModified()))+"\n";
				
		    	if (archivos[i].isDirectory()){
		    		nuevo_directorio = archivos[i].listFiles();		    		
					CrearTxt(nuevo_directorio, nuevo_separador);
				}				
			}		
		}
	}
	
	public void GuardarDatos() {
		FileWriter fichero = null;
        
        try
        {
        	fichero = new FileWriter("C:\\Users\\Miguel Angel\\Documents\\DirectoriosJava.txt");
        	fichero.write(datos);
        	contenidoDirectorio.setContenidoDirectorio(datos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {           
	           if (null != fichero)
	              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        } 	
	}
	/********************************/
	
	/***-Gestión del objeto serializable-***/
	public void EscribirSerializable() {
		OutputSerializable salida= new OutputSerializable();
		
		try {
			salida.abrir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			salida.escribir( contenidoDirectorio );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			salida.cerrar();
			System.out.println("Fichero serializado\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void LeerSerializable() {
		Directorio contenidoDirectorio=new Directorio("");
		InputSerializable entrada = new InputSerializable();	
		
		try {
			entrada.abrir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		do {
			try {
				contenidoDirectorio = entrada.leer();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (contenidoDirectorio!=null);
		try {
			entrada.cerrar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	/********************************/
}