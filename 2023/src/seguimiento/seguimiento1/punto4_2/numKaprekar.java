package seguimiento.seguimiento1.punto4_2;

/**
 * @author Alisson Campos Marin (grupo N)
 * @author Cristhian Andrés Miranda Ramirez (grupo D)
 * @author Diego Alejandro Vera Gonzaléz (grupo D)
 */
public class numKaprekar {

	public static void main(String[] args) {
		int numero = 703;
		boolean esKaprekarIterativo;
		double duracionEnSegundos;
		long tiempoEjecucion, startTime, endTime;

	    startTime = System.nanoTime();
	    esKaprekarIterativo = numeroKaprekarIterativo(numero);

		if (esKaprekarIterativo == true) {
			System.out.println( numero + " es un número Kaprekar");
		} else {
			System.out.println(numero + " no es un número Kaprekar");
		}

		endTime = System.nanoTime();

		tiempoEjecucion = endTime - startTime;
		duracionEnSegundos = (double) tiempoEjecucion / 1000000000.0;
	    System.out.println("Tiempo iterativo: "+duracionEnSegundos+" segundos");

	}

	/**
	 * Método que comprueba si un número es kaprekar
	 * @param numero dato a comprobar
	 * @return
	 *
	 * 		ORDEN DE COMPLEJIDAD O(N)
	 */
	private static boolean numeroKaprekarIterativo(int numero) {
		long cuadrado = (long) numero * numero; //eleva el número al cuadrado
		String cadena = String.valueOf(cuadrado); //convierte la variable cuadrado a una cadena

		// Si el número de dígitos es impar, agregamos un 0 al principio
		if (cadena.length() % 2 != 0) {
			cadena = "0" + cadena;
		}
		// Dividimos la cadena en dos partes iguales en el punto medio
		int puntoMedio = cadena.length() / 2;
		String strIzquierda = cadena.substring(0, puntoMedio);
		String strDerecha = cadena.substring(puntoMedio);

		// Convertimos las dos partes en números enteros
		int izquierda = Integer.parseInt(strIzquierda);
		int derecha = Integer.parseInt(strDerecha);

		// Verificamos si la suma es igual al número original
		return (izquierda + derecha == numero);
	}


}
