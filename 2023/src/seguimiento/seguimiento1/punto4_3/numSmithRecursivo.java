package seguimiento.seguimiento1.punto4_3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Alisson Campos Marin (grupo N)
 * @author Cristhian Andrés Miranda Ramirez (grupo D)
 * @author Diego Alejandro Vera Gonzaléz (grupo D)
 */
public class numSmithRecursivo {
    public static void main(String[] args) {

        boolean esSmith;
        double duracionEnSegundos;
        long tiempoEjecucion, startTime, endTime;

        System.out.println("Ingrese un número: ");
        Scanner lectura = new Scanner (System.in);
        int valor = lectura.nextInt();

        startTime = System.nanoTime();
        esSmith = esNumeroSmithRecursivo(valor);

        if (esSmith == true) {
            System.out.println(valor + " es un número Smith");
        } else {
            System.out.println(valor + " no es un número Smith");
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
    private static boolean esNumeroSmithRecursivo(int numero) {
        int sumaDigitosOriginal = sumarDigitos(numero); // Se calcula la suma de los dígitos del número original
        ArrayList<Integer> factores = factoresPrimos(numero, 2, new ArrayList<Integer>()); // Se descompone el número en sus factores primos
        int sumaDigitosFactores = sumaDigitosLista(factores); // Se calcula la suma de los dígitos de los factores primos
        return (sumaDigitosOriginal == sumaDigitosFactores); // Se compara la suma de dígitos del número original con la suma de dígitos de los factores primos
    }

    /**
     * Función para sumar los dígitos de un número
     *
     * @param numero el número del cual se sumarán los dígitos
     * @return la suma de los dígitos del número
     *
     * ORDEN DE COMPLEJIDAD O(LOG(N))
     */
    public static int sumarDigitos(int numero) {
        if (numero < 10) {
            return numero;
        } else {
            return (numero % 10) + sumarDigitos(numero / 10);
        }
    }

    /**
     * Función para descomponer un número en sus factores primos
     *
     * @param numero el número a descomponer
     * @param divisor el divisor actual
     * @param factores la lista de factores primos
     * @return factores
     */
    public static ArrayList<Integer> factoresPrimos(int numero, int divisor, ArrayList<Integer> factores) {
        if (numero == 1) {
            return factores;
        } else if (numero % divisor == 0) {
            factores.add(divisor);
            return factoresPrimos(numero / divisor, divisor, factores);
        } else {
            return factoresPrimos(numero, divisor + 1, factores);
        }
    }

    /**
     * Función para sumar los dígitos de una lista de números
     *
     * @param lista Se recorre cada elemento de la lista
     * @return Se retorna la suma de los dígitos de cada elemento
     */
    public static int sumaDigitosLista(ArrayList<Integer> lista) {
        int suma = 0;
        for (int i : lista) { // Se recorre cada elemento de la lista
            suma += sumarDigitos(i); // Se suma los dígitos de cada elemento
        }
        return suma;
    }
}
