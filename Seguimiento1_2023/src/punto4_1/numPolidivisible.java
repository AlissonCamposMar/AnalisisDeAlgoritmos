package punto4_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class numPolidivisible {
    public static void main(String[] args) {
        int[][] matrix = {{123, 24, 36}, {80, 42, 63}, {2016}};
        double duracionEnSegundos;
        long startTime, endTime, duration;

        startTime = System.nanoTime(); // Medir el tiempo de inicio
        int[] polyDivisibleNumbers = findPolyDivisibleNumbers(matrix);
        // Imprimir el resultado en la consola
        System.out.println(Arrays.toString(polyDivisibleNumbers));
        endTime = System.nanoTime(); // Medir el tiempo de finalización

        duration = (endTime - startTime); // Calcular la duración de la ejecución en nanosegundos
        duracionEnSegundos = (double) duration / 1000000000.0; // Convertir la duración a segundos

// Imprimir el resultado en la consola
        System.out.println("Tiempo de ejecución: " + duracionEnSegundos + " segundos");
    }

    /**
     * @param n
     * Método que comprueba si un número es polidivisible
     */
    public static boolean isPolyDivisible(int n) {
        String x = Integer.toString(n); //el valor recibido por parámetro se convierte a String y se almacena en la variable x...
        int divisor = x.length();       //...el tamaño del string se almacena en la variable int divisor que servirá como contador...
        //....para ir desde el último dígito hasta el primero

        while (n > 0) { // Mientras queden dígitos por comprobar...

            if (n % divisor != 0) {// Si el dígito actual no es divisible por su posición...
                return false; // ...el número no es polidivisible, devolvemos false.
            }

            n /= 10; // Pasamos al siguiente dígito dividiendo n entre 10.
            divisor--; //Decrementa el contador para el siguiente dígito
        }
        return true; //sí todo lo anterior fue exitoso entonces retornara true
    }

    // Método para encontrar números polidivisibles en una matriz
    public static int[] findPolyDivisibleNumbers(int[][] matrix) {
        // Se crea una lista para almacenar los resultados
        List<Integer> resultList = new ArrayList<>();

        // Se itera a través de cada fila de la matriz
        for (int[] row : matrix) { //row es una variable que representa cada fila de la matriz de entrada

            // Se itera a través de cada número de la fila
            for (int num : row) {

                //Validación del número polidivisible y con la condición num>0...
                //... se excluyen los números negativos y el cero
                if (num > 0 && isPolyDivisible(num)) {
                    resultList.add(num);
                }
            }
        }

        //La lista de resultados se convierte en un arreglo y luego se retorna
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

}
