import java.util.*;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//imports

public class Gramatica{
	//campos
	private String simbolos = "";
	private String alfabeto = "";
	private String sInicial = "";
	private ArrayList<String> reglasProduccion = new ArrayList<String>();
	//campo -->guardará los archivos generados?!?!?!
	private ArrayList<String> argus = new ArrayList<String>();

	//constructor
	public Gramatica(String files){

		try {
			String almacenador;
			BufferedReader lector = new BufferedReader(new FileReader(files));
			while((almacenador = lector.readLine()) != null ){
				argus.add(almacenador);
			}
			lector.close();

			//Se guardarán las características del archivo gld
			simbolos = argus.get(0);
			alfabeto = argus.get(1);
			sInicial = argus.get(2);

			for(int i = 3; i < argus.size();i++){
				reglasProduccion.add(argus.get(i));
			}


			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se pudo encontrar el archivo " + files);
		}
	}

	public static void main(String[] args) throws Exception{
		//primer argumento
		String fileGLD = args[0];
		String flag = args[1];
		String filesOut = args[2];
		String path = args[3];

		ArrayList<String> listaCuerdas = new ArrayList<String>(); //Lista donde se guardan las cuerdas a analizar

		Gramatica constante = new Gramatica(fileGLD);
	}
}
