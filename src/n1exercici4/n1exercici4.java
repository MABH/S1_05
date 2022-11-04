package n1exercici4;

import java.io.File;
import java.util.Scanner;

public class n1exercici4 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Menu();
		
	}

	public static void Menu() {		
		char opcion;
		
		do {
			System.out.println("\n1.- Crear documento de directorios");
			System.out.println("2.- Leer archivo de texto (txt)");
			System.out.println("0.- Salir");
			opcion = sc.nextLine().charAt(0);
			
			if (opcion=='1') CrearDocumento();
			else if (opcion=='2') LeerTxt();
		}while (opcion!='0');
		
		
	}
	
	public static void LeerTxt() {
		String directorio = "";
		
		System.out.println("Introduzca la ruta del archivo de texto: ");
		directorio = sc.nextLine();
		
		try {
			Scanner input = new Scanner(new File(directorio));
	        while (input.hasNextLine()) {
	        	String line = input.nextLine();
	            System.out.println(line);
	        }
	        input.close();
		} catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	
	public static void CrearDocumento() {
		String directorio = "";
		
		System.out.println("Introduzca la ruta del directorio: ");
		directorio = sc.nextLine();
		
		ListarDirectorio lista=new ListarDirectorio(directorio);
		
	}
}

