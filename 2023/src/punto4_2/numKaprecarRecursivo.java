package punto4_2;

/**
 * @author Alisson Campos Marin (grupo N)
 * @author Cristhian Andrés Miranda Ramirez (grupo D)
 * @author Diego Alejandro Vera Gonzaléz (grupo D)
 */
public class numKaprecarRecursivo {
    public static void main(String[] args) {
        int numero = 703;
        double duracionEnSegundos;
        boolean esKaprekarRecursivo;
        long tiempoEjecucion, startTime, endTime;

        startTime = System.nanoTime();
        esKaprekarRecursivo = numeroKaprekarRecursivo(numero);

        if (esKaprekarRecursivo == true) {
            System.out.println(numero + " Sí es Kaprekar");
        }else{
            System.out.println(numero + " No es Kaprekar");
        }

        endTime = System.nanoTime();
        tiempoEjecucion = endTime - startTime;
        duracionEnSegundos = (double) tiempoEjecucion / 1000000000.0; // Convertir la duración a segundos

        // Imprimir el resultado en la consola
        System.out.println("Tiempo de ejecución: " + duracionEnSegundos + " segundos");

    }

    /**
     * Método que comprueba si un número es kaprekar
     * @param numero dato comprobar
     * @return
     */
    private static boolean numeroKaprekarRecursivo(int numero) {
        long cuadrado = (long) numero * numero;
        String cadena = String.valueOf(cuadrado);

        // Si el número de dígitos es impar, agregamos un 0 al principio
        if (cadena.length() % 2 != 0) {
            cadena = "0" + cadena;
        }

        return numeroKaprekarRecursivoAux(cadena, numero);
    }

    /**
     * Método para la comprobación del número kaprekar, para mayor eficiencia del algoritmo
     * @param cadena
     * @param numero
     * @return
     *
     *              ORDEN DE COMPLEJIDAD O(N)
     */
    private static boolean numeroKaprekarRecursivoAux(String cadena, int numero) {
        if (cadena.length() <= 1) {
            return false;
        } else {
            // Dividimos la cadena en dos partes iguales en el punto medio
            int puntoMedio = cadena.length() / 2;
            String strIzquierda = cadena.substring(0, puntoMedio);
            String strDerecha = cadena.substring(puntoMedio);

            // Convertimos las dos partes en números enteros
            int izquierda = Integer.parseInt(strIzquierda);
            int derecha = Integer.parseInt(strDerecha);

            // Verificamos si la suma es igual al número original
            if (izquierda + derecha == numero) {
                return true;
            } else {
                return numeroKaprekarRecursivoAux(strIzquierda, numero) || numeroKaprekarRecursivoAux(strDerecha, numero);
            }
        }
    }
}
