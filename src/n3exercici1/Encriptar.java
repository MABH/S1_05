package n3exercici1;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Encriptar {   
   private final static String algoritmo = "AES";   
   private final String tipoCifrado = "AES/CBC/PKCS5Padding";   
   IvParameterSpec ivParams;
   private SecretKey llave;
   private String ruta=null;
   private String texto;
   
   public Encriptar(String ruta) {
		this.ruta = ruta;
		this.texto = leerFichero(ruta);
	}
   
   public String encrypt() throws Exception {
           Cipher cipher = Cipher.getInstance(tipoCifrado);
           llave = generarLlave();       
          
           SecureRandom randomSecureRandom = SecureRandom.getInstance("SHA1PRNG");
           byte[] iv = new byte[cipher.getBlockSize()];
           randomSecureRandom.nextBytes(iv);

           ivParams = new IvParameterSpec(iv);
           
           cipher.init(Cipher.ENCRYPT_MODE, llave, ivParams);
           byte[] encrypted = cipher.doFinal(this.texto.getBytes());
           return new String(encodeBase64(encrypted));
   }

   
   public String decrypt(String encrypted) throws Exception {
           Cipher cipher = Cipher.getInstance(tipoCifrado);
           SecretKeySpec secretKeySpec = new SecretKeySpec(llave.getEncoded(), algoritmo);
           //iv = cipher.getIV();
           //IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
           byte[] enc = decodeBase64(encrypted);
           cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParams);
           byte[] decrypted = cipher.doFinal(enc);
           return new String(decrypted);
   }

   public static SecretKey generarLlave() throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance(algoritmo);
	    keyGenerator.init(128); //Llave de 128 bits
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}
   
   public static String leerFichero(String ruta) {		
		String linea;
		String texto="";
		
		try {
			 FileInputStream fis = new FileInputStream(ruta);
			 InputStreamReader is = new InputStreamReader(fis, "ISO-8859-1");
			 BufferedReader bf = new BufferedReader(is);
			 linea=bf.readLine();
			 
			 while (linea!=null) {		
				 texto += linea+"\n";	 
				 linea = bf.readLine();
			 }
			 
			 fis.close();
			 System.out.println("Texto importado correctamente\n"+texto);
		 } catch (FileNotFoundException e) {
			 System.out.println("Fichero no encontrado");
			 e.printStackTrace();
		 } catch (IOException e) {
			 System.out.println("Error de E/S");
			 e.printStackTrace();
		 }		 
		
		return texto;
	}
}
