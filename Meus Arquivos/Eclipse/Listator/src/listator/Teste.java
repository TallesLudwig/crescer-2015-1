package listator;

import java.io.File;
import java.util.Scanner;


public class Teste {
		
	public static void main(String[] args) {
	
		
	System.out.println("Informe o caminho: \n ");	

	
	Scanner entrada = new Scanner(System.in);
	String str = entrada.nextLine();
	entrada.close();
	
	//String diretorio = "C:\\Users\\0152067\\Crescer Pai\\src\\modulo-01-java-OO\\Dia01"; 
	

	File file = new File(str); 
	File afile[] = file.listFiles(); 
	
	int i = 0; 
		for (int j = afile.length; i < j; i++) { 
			File arquivos = afile[i]; 
			System.out.println(arquivos.getName()); 
		}
	
	}
	
}
