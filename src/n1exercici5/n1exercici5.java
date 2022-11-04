package n1exercici5;

import java.io.File;
import java.util.Scanner;


public class n1exercici5 {
static Scanner sc = new Scanner(System.in);
	static ListarDirectorio lista=new ListarDirectorio("");
	
	public static void main(String[] args) {
		Menu();		
	}

	public static void Menu() {		
		char opcion;
		
		do {
			System.out.println("\n1.- Crear documento de directorios");
			System.out.println("2.- Leer archivo de texto (txt)");
			System.out.println("3.- Serializar documento de directorios");
			System.out.println("4.- Deserializar documento de directorios");
			System.out.println("0.- Salir");
			opcion = sc.nextLine().charAt(0);
			
			switch(opcion) {
			case '1':
				CrearDocumento();
				break;
			case '2':
				LeerTxt();
				break;
			case '3':
				if (lista!=null)
					lista.EscribirSerializable();
				break;
			case '4':
				lista.LeerSerializable();
				break;
			}
			
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
		
		lista=new ListarDirectorio(directorio);		
	}
}