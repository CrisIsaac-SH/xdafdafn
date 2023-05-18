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
	private ArrayList<String> args = new ArrayList<String>();

	//constructor
	public Gramatica(String files){

		try {
			String almacenador;
			BufferedReader lector = new BufferedReader(new FileReader(files));
			while((almacenador = lector.readLine()) != null ){
				args.add(almacenador);
			}
			lector.close();

			//Se guardarán las características del archivo gld
			simbolos = almacenador.get(0);
			alfabeto = almacenador.get(1);
			sInicial = almacenador.get(2);

			for(int i = 3; i < almacenador.size();i++){
				reglasProduccion.add(almacenador.get(i));
			}

			

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No se pudo encontrar el archivo " + files);
		}
	}

	public static void main(String[] args) throws Exception{
		//primer argumento
	}
}
