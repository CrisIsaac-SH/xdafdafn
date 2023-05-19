/*
	Utilice esta clase para guardar la informacion de su
	AFD. NO DEBE CAMBIAR LOS NOMBRES DE LA CLASE NI DE LOS 
	METODOS que ya existen, sin embargo, usted es libre de 
	agregar los campos y metodos que desee.
*/
import java.io.*;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Arrays;

public class AFD {

	/*
	 * Implemente el constructor de la clase AFD
	 * que recibe como argumento un string que
	 * representa el path del archivo que contiene
	 * la informacion del afd (i.e. "Documentos/archivo.afd").
	 * Puede utilizar la estructura de datos que desee
	 */
	public static BufferedReader Buff;
	public String string_1 = " ";
	public LinkedList<String> var_Arch;
	public static String nombreArchivo;
	// -------------------------------------
	public char[] finaal;
	public String[] repeticiones;
	public int estados;
	public char[] alfabetoo;
	// -------------------------------------
	public LinkedList<String> tranciss;
	public int cantidad_trancis;
	public String[] Trans;
	// -------------------------------------
	public static boolean Boolean;
	public static String accept;
	// -------------------------------------
	public String datosCuerda;
	public LinkedList<String> cuerdaValida;
	// -------------------------------------
	public LinkedList<String> input;


	

	public AFD(String path) {

		var_Arch = new LinkedList<String>();
		try {
			Buff = new BufferedReader(new FileReader(path));
			do {
				string_1 = Buff.readLine();
				var_Arch.add(string_1);
			}

			while (string_1 != null);

			var_Arch.pollLast();
			values(var_Arch);

		}

		catch (Exception g) {
		}
	}

	public void input(String banderas) {
		input = new LinkedList<String>();
		try {
			System.out.println("Ingrese una cuerda ");
			banderas = Buff.readLine();
			if (!banderas.equals("")) {
				input.pollLast();
			} else {
				input.add(banderas);
			}
		} catch (IOException d) {
			System.out.println("Input Ingresado Incorrecto.");
		}

		for (int a = 0; a < input.size(); a++) {
			String valfin = input.get(a);
			evaluate(valfin);
		}
	}

	public void values(LinkedList<String> var_Arch) {

				estados = Integer.parseInt(var_Arch.get(0));
				int[] estadosf = new int[estados];

				for (int i = 0; i < estados; i++){
					estadosf[i] = i;
				}

				finaal = (var_Arch.get(1)).replace(",", "").toCharArray();
				
				String repeticiones = var_Arch.get(2).replace(",", "");
				alfabetoo = repeticiones.toCharArray();

				
		}

	public void cuerdas(String crds) {

		cuerdaValida = new LinkedList<String>();

		try {
			Buff = new BufferedReader(new FileReader(crds));

			if (datosCuerda != null) {
				cuerdaValida.pollLast();

			} else {

				datosCuerda = Buff.readLine();
				cuerdaValida.add(datosCuerda);
			}
		}

		catch (Exception e) {
		}

		for (int a = 0; a < cuerdaValida.size(); a++) {

			String vals = cuerdaValida.get(a);
			evaluate(vals);
		}
	}

	/*
	 * Implemente el metodo transition, que recibe de argumento
	 * un entero que representa el estado actual del AFD y un
	 * caracter que representa el simbolo a consumir, y devuelve
	 * un entero que representa el siguiente estado
	 */
	public int getTransition(int currentState, char symbol) {

		ArrayList<String> trans = new ArrayList<String>();
		String trns;

		for(int i = 3; i <= var_Arch.size() - 1; i++){

			trns = var_Arch.get(i);
			trans.add(trns);
		}

		int x = 0;

		for(int j = 0; j <= alfabetoo.length - 1; j++){

			if (alfabetoo[j] == symbol) {
				break;
			}

			x++;
		}

		String ll = trans.get(x).replace(",", "");
		char[] transiciones = ll.toCharArray();

		int nuevoestado = Integer.parseInt(String.valueOf(transiciones[currentState]));

		return nuevoestado;
	}

	/*
	 * Implemente el metodo evaluate, que recibe como argumento
	 * un String que representa la cuerda a evaluar, y devuelve
	 * un boolean dependiendo de si la cuerda es aceptada o no
	 * por el afd
	 */
	public boolean evaluate(String string) {
		boolean Boolean = false;

		try {
			int state = 1;

			while(true){
				
					for (int a = 0; a < string.length(); a++) {

						char chars = string.charAt(a);
						String charsito = String.valueOf(chars);

						if(charsito.equals("")){
							break;

						}else{
							for (int b = 0; b < alfabetoo.length; b++) {
								
								if (alfabetoo[b] == chars) {
									state = getTransition(state, chars);

									if (state == 0) {
										return false;
									}else if(a == string.length() - 1){

										if (isFinal(state)) {
											return true;
										}else{
											return false;
										}
									}
									Boolean = true;
								} else {
									Boolean = false;
								}
							}
						}

					}
			
			}

		}

		catch (NullPointerException o) {

		}


		return Boolean;

	}

	/*
	 * Implemente el metodo evaluate_many, que recibe como argumento
	 * un arreglo de Strings que representa las cuerda a evaluar, y devuelve
	 * un arreglo booleans dependiendo de si cada cuerda es aceptada o no
	 * por el afd
	 */
	public boolean[] evaluateMany(String[] strings) {

		boolean[] resultado = new boolean[strings.length];
		System.out.println(Arrays.toString(strings));

		for (int i = 0; i < strings.length; i++) {

			if (strings[i].length() > 0) {

				resultado[i] = evaluate(strings[i]);
			} else {

				resultado[i] = false;
			}
		}
		// System.out.println(Arrays.toString(resultado));
		return resultado;
	}

	/*
	 * Implemente el metodo isFinal, que devuelve true si el estado enviado
	 * es un estado final, y false si no lo es
	 */
	public boolean isFinal(int currentState) {
		Boolean bool = false;

			for (int j = 0; j < finaal.length; j++) {
				int valor = Integer.parseInt(String.valueOf(finaal[j]));

					if (currentState == valor) {
						bool = true;
					}
			}
		return bool;			 
	}
}