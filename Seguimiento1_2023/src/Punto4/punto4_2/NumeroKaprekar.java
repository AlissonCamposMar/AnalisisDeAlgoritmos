package Punto4.punto4_2;

public class NumeroKaprekar {

	public static void main(String[] args) {
		int numero = 4879;
		boolean esKaprekarIterativo, esKaprekarRecursivo;
		long tiempoEjecucionIterativo, tiempoEjecucionRecursivo, startTime, endTime;

	    startTime = System.nanoTime();
	    esKaprekarIterativo = numeroKaprekarIterativo(numero);
	    endTime = System.nanoTime();
	    tiempoEjecucionIterativo = endTime - startTime;

	    startTime = System.nanoTime();
	    esKaprekarRecursivo = numeroKaprekarRecursivo(numero, 0, 0, 0);
	    endTime = System.nanoTime();
	    tiempoEjecucionRecursivo = endTime - startTime;

	    System.out.println("Tiempo iterativo: "+tiempoEjecucionIterativo+" Nanosegundos");
	    System.out.println("Tiempo recursivo: "+tiempoEjecucionRecursivo+" Nanosegundos");

		if ( esKaprekarIterativo == true && esKaprekarRecursivo == true) {
			System.out.println("Sí es Kaprekar");
		}else{
			System.out.println("No es Kaprekar");
		}
	}

	private static boolean numeroKaprekarIterativo(int numero) {
		//Se eleva el numero a la potencia 2 para poder operar
		int potencia = (int) Math.pow(numero, 2);
		int aux = potencia;
		int numeroDigitos = 0;

		/*
		 * Primero se busca la cantidad de digitos de la potencia operando sobre el auxiliar
		 * para no alterar el numero original, se va dividiendo entre 10 para ir sacando digito
		 * por digito hasta que el numero llegue a 0
		*/
		while (aux > 0) {
			numeroDigitos++;
			aux /= 10;
		}

		/*
		 * Se divide el numero de digitos para saber por donde partir el numero a la mitad con
		 * el operador m�dulo luego
		 */
		int mitadDigitos = numeroDigitos / 2;

		/*
		 * Cuando es un numero impar, sumamos 1 a la mitad de digitos para que parta el
		 * numero teniendo la parte izquierda menor a la derecha
		 */
		if (numeroDigitos % 2 != 0) {
			mitadDigitos++;
		}

		/*
		 * La parte derecha se saca con el operador m�dulo, operando la potencia
		 * por 10 elevado a la mitad de la cantidad de digitos que haya, ya que esto
		 * saca el resto de la divisi�n
		 */
		int parteDerecha = potencia % (int)Math.pow(10, mitadDigitos);

		/*
		 * En esta parte verifica que la segunda parte del numero no sea 0, en caso de que
		 * sea as� automaticamente retorna que no es un numero Kaprekar
		 */
		if (parteDerecha == 0) {
			return false;
		}

		int parteIzquierda = (potencia - parteDerecha) / (int)Math.pow(10, mitadDigitos);

		/*
		 * En este punto se verifica la presencia de algun digito 0 en la mitad como ultimo
		 * digito de la parte izquierda, si sucede esto se ignora ese 0 como si estuviera en
		 * inicio de la parte derecha
		 */
		if (parteIzquierda % 10 == 0) {
			parteIzquierda /= 10;
		}

		return (parteIzquierda+parteDerecha == numero);
	}

	private static boolean numeroKaprekarRecursivo(int numero, int potencia, int aux, int numeroDigitos) {
		/*
		 * Esta primera condicion es para obtener la potencia del numero y el auxiliar, solo entra aqui la primera vez que se llama
		 * a la funcion cuando el numero de digitos es 0
		 */
		if (numeroDigitos == 0) {
			potencia = (int) Math.pow(numero, 2);
			aux = potencia;
		}
		/*
		 * El caso base es cuando el auxiliar llegue a 0 de dividirlo varias veces entre 10
		 */
		if (aux == 0) {
			/*
			 * Se divide el numero de digitos para saber por donde partir el numero a la mitad con
			 * el operador m�dulo luego
			 */
			int mitadDigitos = numeroDigitos / 2;

			/*
			 * Cuando es un numero impar, sumamos 1 a la mitad de digitos para que parta el
			 * numero teniendo la parte izquierda menor a la derecha
			 */
			if (numeroDigitos % 2 != 0) {
				mitadDigitos++;
			}

			/*
			 * La parte derecha se saca con el operador m�dulo, operando la potencia
			 * por 10 elevado a la mitad de la cantidad de digitos que haya, ya que esto
			 * saca el resto de la divisi�n
			 */
			int parteDerecha = potencia % (int)Math.pow(10, mitadDigitos);

			/*
			 * En esta parte verifica que la segunda parte del numero no sea 0, en caso de que
			 * sea as� automaticamente retorna que no es un numero Kaprekar
			 */
			if (parteDerecha == 0) {
				return false;
			}

			int parteIzquierda = (potencia - parteDerecha) / (int)Math.pow(10, mitadDigitos);

			/*
			 * En este punto se verifica la presencia de algun digito 0 en la mitad como ultimo
			 * digito de la parte izquierda, si sucede esto se ignora ese 0 como si estuviera en
			 * inicio de la parte derecha
			 */
			if (parteIzquierda % 10 == 0) {
				parteIzquierda /= 10;
			}

			return (parteIzquierda+parteDerecha == numero);
		}else{
			/*
			 * Caso recursivo que va quitando el ultimo digito del auxiliar con el modulo y aumentando
			 * el numero de digitos en cada iteracion
			 */
			return numeroKaprekarRecursivo(numero, potencia, aux/=10, ++numeroDigitos);
		}
	}
}
