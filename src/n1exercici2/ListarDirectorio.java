package n1exercici2;

import java.io.File;
import java.text.SimpleDateFormat;


public class ListarDirectorio {
	private String directorio;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public ListarDirectorio(String directorio) {		
		this.directorio = directorio;		
		File carpeta = new File(this.directorio);		
		String tabulador = "	";
		
		
		if(carpeta.exists()) {
			File[] archivos = carpeta.listFiles();
			PrintArbol(archivos, tabulador);
		}
		else {
			System.out.println("El directorio "+this.directorio+" no existe.");
		    
		}
		
	}
	
	public void PrintArbol(File[] archivos, String tabulador) {
		File[] nuevo_directorio;
		String nuevo_separador = tabulador;
		
		if (archivos == null || archivos.length == 0) {
		    System.out.println(nuevo_separador+"   - No hay elementos dentro de esta carpeta.-");
		    return;
		}
		else {
			nuevo_separador = nuevo_separador + "	";
		    for (int i=0; i< archivos.length; i++) {			
		    	sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				File archivo = archivos[i];
				System.out.println(nuevo_separador+String.format("%s (%s) -  %s",
							archivo.getName(),
				            archivo.isDirectory() ? "Carpeta" : "Archivo",
				            sdf.format(archivo.lastModified())
				   ));
				
		    	if (archivos[i].isDirectory()){
		    		nuevo_directorio = archivos[i].listFiles();		    		
					PrintArbol(nuevo_directorio, nuevo_separador);
				}
				
			}
		
		}
	}
}
