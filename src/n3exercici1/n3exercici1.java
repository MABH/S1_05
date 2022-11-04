package n3exercici1;

import java.io.File;
import java.security.SecureRandom;
import java.util.Scanner;

public class n3exercici1 {

	public static void main(String[] args) {
		Encriptar cifrado = new Encriptar("C:\\Users\\Miguel Angel\\Documents\\DirectoriosJava.txt");
		String resultado = null;
		
		try {
			resultado = cifrado.encrypt();
			System.out.println("Fichero encriptado: "+resultado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
		try {
			System.out.println("\nFichero desencriptado: \n"+cifrado.decrypt(resultado));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Finalmente he incluido el método en la clase de cifrado
	//Y he hecho la lectura como un Stream porque me parece mas seguro
	/*public static String CargarTxt(String ruta)
	{
		Scanner sc = new Scanner(System.in);
		String texto="";				
			
		try{
			Scanner input = new Scanner(new File(ruta));
			while (input.hasNextLine()) {
			String line = input.nextLine();
			//System.out.println(line);
		   }
		input.close();
		} catch (Exception ex) {
		        ex.printStackTrace();
		}				
		return texto;		
	}	*/
}
