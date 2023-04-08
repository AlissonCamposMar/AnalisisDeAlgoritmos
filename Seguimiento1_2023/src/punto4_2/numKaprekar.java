package punto4_2;

public class numKaprekar {

	public static void main(String[] args) {
		int numero = 4879;
		boolean esKaprekarIterativo;
		long tiempoEjecucionIterativo, startTime, endTime;

	    startTime = System.nanoTime();
	    esKaprekarIterativo = numeroKaprekarIterativo(numero);
	    endTime = System.nanoTime();
	    tiempoEjecucionIterativo = endTime - startTime;

		if (esKaprekarIterativo == true) {
			System.out.println( numero + " es un número Kaprekar");
		} else {
			System.out.println(numero + " no es un número Kaprekar");
		}

	    System.out.println("Tiempo iterativo: "+tiempoEjecucionIterativo+" Nanosegundos");

	}

	private static boolean numeroKaprekarIterativo(int numero) {
		long square = (long) numero * numero;
		String strSquare = String.valueOf(square);

		// Si el número de dígitos es impar, agregamos un 0 al principio
		if (strSquare.length() % 2 != 0) {
			strSquare = "0" + strSquare;
		}
		// Dividimos la cadena en dos partes iguales en el punto medio
		int midpoint = strSquare.length() / 2;
		String strLeft = strSquare.substring(0, midpoint);
		String strRight = strSquare.substring(midpoint);

		// Convertimos las dos partes en números enteros
		int left = Integer.parseInt(strLeft);
		int right = Integer.parseInt(strRight);

		// Verificamos si la suma es igual al número original
		return (left + right == numero);
	}


}
