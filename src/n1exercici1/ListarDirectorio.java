package n1exercici1;
import java.io.File;


public class ListarDirectorio {
	private String directorio;
	
	public ListarDirectorio(String directorio) {		
		this.directorio = directorio;		
		File carpeta = new File(this.directorio);		
		
		if(carpeta.exists()) {
			String[] listado = carpeta.list();
			
			if (listado == null || listado.length == 0) {
			    System.out.println("No hay elementos dentro del directorio: "+this.directorio);
			    return;
			}
			else {
			    for (int i=0; i< listado.length; i++) {
			        System.out.println(listado[i]);
			    }
			}
		}
		else {
			System.out.println("El directorio "+this.directorio+" no existe.");
		    
		}
		
	}
}
