package punto4_3;

import java.util.ArrayList;

public class numSmith {

    public static void main(String[] args) {
        int numero = 27;
        if (esNumeroDeSmith(numero)) {
            System.out.println(numero + " es un número Smith");
        } else {
            System.out.println(numero + " no es un número Smith");
        }
    }

    // Función principal que determina si un número es un número Smith
    private static boolean esNumeroDeSmith(int numero) {
        int sumaDigitosOriginal = sumaDigitos(numero); // Se calcula la suma de los dígitos del número original
        ArrayList<Integer> factores = factoresPrimos(numero); // Se descompone el número en sus factores primos
        int sumaDigitosFactores = sumaDigitosLista(factores); // Se calcula la suma de los dígitos de los factores primos
        return (sumaDigitosOriginal == sumaDigitosFactores); // Se compara la suma de dígitos del número original con la suma de dígitos de los factores primos
    }

    // Función para sumar los dígitos de un número
    public static int sumaDigitos(int numero) {
        int suma = 0;
        while (numero > 0) {
            suma += numero % 10; // Se agrega el último dígito del número a la suma
            numero /= 10;        // Se elimina el último dígito del número
        }
        return suma;
    }

    // Función para descomponer un número en sus factores primos
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

    // Función para sumar los dígitos de una lista de números
    public static int sumaDigitosLista(ArrayList<Integer> lista) {
        int suma = 0;
        for (int i : lista) { // Se recorre cada elemento de la lista
            suma += sumaDigitos(i); // Se suma los dígitos de cada elemento
        }
        return suma;
    }
}
