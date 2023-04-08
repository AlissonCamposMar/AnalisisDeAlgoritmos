package punto4_3;

import java.util.ArrayList;
/**
 * @author Alisson Campos Marin (grupo N)
 * @author Cristhian Andrés Miranda Ramirez (grupo D)
 * @author Diego Alejandro Vera Gonzaléz (grupo D)
 */
public class numSmith {

    public static void main(String[] args) {
        int numero = 27;
        boolean esSmith;
        double duracionEnSegundos;
        long tiempoEjecucion, startTime, endTime;

        startTime = System.nanoTime();
        esSmith = esNumeroSmith(numero);

        if (esSmith == true) {
            System.out.println(numero + " es un número Smith");
        } else {
            System.out.println(numero + " no es un número Smith");
        }

        endTime = System.nanoTime();

        tiempoEjecucion = endTime - startTime;
        duracionEnSegundos = (double) tiempoEjecucion / 1000000000.0;
        System.out.println("Tiempo iterativo: "+duracionEnSegundos+" segundos");

    }

    /**
     * Función principal que determina si un número es un número Smith
     *
     * @param numero el número a comprobar
     * @return la comparación de la suma de dígitos del número original con la suma de dígitos de los factores primos
     */
    private static boolean esNumeroSmith(int numero) {
        int sumaDigitosOriginal = sumarDigitos(numero); // Se calcula la suma de los dígitos del número original
        ArrayList<Integer> factores = factoresPrimos(numero); // Se descompone el número en sus factores primos
        int sumaDigitosFactores = sumaDigitosLista(factores); // Se calcula la suma de los dígitos de los factores primos
        return (sumaDigitosOriginal == sumaDigitosFactores); // Se compara la suma de dígitos del número original con la suma de dígitos de los factores primos
    }

    /**
     * Función para sumar los dígitos de un número
     *
     * @param numero el número del cual se sumarán los dígitos
     * @return la suma de los dígitos del número
     */
    public static int sumarDigitos(int numero) {
        int suma = 0;
        while (numero > 0) {
            suma += numero % 10; // Se agrega el último dígito del número a la suma
            numero /= 10;        // Se elimina el último dígito del número
        }
        return suma;
    }

    /**
     * Función para descomponer un número en sus factores primos
     *
     * @param numero el número a comprobar
     * @return factores
     */
    public static ArrayList<Integer> factoresPrimos(int numero) {
        ArrayList<Integer> factores = new ArrayList<Integer>(); // Se crea una lista vacía para los factores primos
        int divisor = 2; // Se comienza con el primer número primo
        while (numero > 1) { // Se sigue descomponiendo hasta que el número sea 1
            while (numero % divisor == 0) {
                factores.add(divisor);
                numero /= divisor;
            }
            divisor++; // Si el divisor no es un factor primo, se pasa al siguiente número primo
        }
        return factores;
    }

    /**
     * Función para sumar los dígitos de una lista de números
     *
     * @param lista Se recorre cada elemento de la lista
     * @return Se retorna la suma de los dígitos de cada elemento
     */
    public static int sumaDigitosLista(ArrayList<Integer> lista) {
        int suma = 0;
        for (int i : lista) { //
            suma += sumarDigitos(i); //
        }
        return suma;
    }
}
