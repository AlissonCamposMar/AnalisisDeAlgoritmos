package punto4_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alisson Campos Marin (grupo N)
 * @author Cristhian Andrés Miranda Ramirez (grupo D)
 * @author Diego Alejandro Vera Gonzaléz (grupo D)
 */
public class numPolidivisible {
    public static void main(String[] args) {

        double duracionEnSegundos;
        long startTime, endTime, tiempoEjecucion;

        System.out.println("ingrese el tamaño de la matriz");
        Scanner tamText =  new Scanner(System.in);
        int tam = tamText.nextInt();
        int[][] matriz = new int[tam][tam];

        startTime = System.nanoTime(); // Medir el tiempo de inicio
        int[] polyDivisibleNumbers = findPolyDivisibleNumbers(matriz);

        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                System.out.println("Introduzca el elemento [" + x + "," + y + "]");
                matriz[x][y] = tamText.nextInt();
            }
        }

        // Imprimir el resultado en la consola
        System.out.println(Arrays.toString(polyDivisibleNumbers));
        endTime = System.nanoTime(); // Medir el tiempo de finalización

        tiempoEjecucion = endTime - startTime; // Calcular la duración de la ejecución en nanosegundos
        duracionEnSegundos = (double) tiempoEjecucion / 1000000000.0; // Convertir la duración a segundos

        // Imprimir el resultado en la consola
        System.out.println("Tiempo de ejecución: " + duracionEnSegundos + " segundos");
    }

    /**
     * @param n dato a comrobar
     * Método que comprueba si un número es polidivisible
     *
     *             ORDEN DE COMPLEJIDAD O(LOG(N))
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

    /**
     * Método para encontrar números polidivisibles en una matriz
     * @param matrix
     * @return
     */
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
