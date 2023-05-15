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
public class numPolidivisibleRecursivo {
    public static void main(String[] args) {

        double duracionEnSegundos;
        long startTime, endTime, tiempoEjecucion;

        System.out.println("ingrese el tamaño de la matriz");
        Scanner tamText =  new Scanner(System.in);
        int tam = tamText.nextInt();
        int[][] matriz = new int[tam][tam];
        startTime = System.nanoTime(); // Medir el tiempo de inicio

        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                System.out.println("Introduzca el elemento [" + x + "," + y + "]");
                matriz[x][y] = tamText.nextInt();
            }
        }


        int[] polyDivisibleNumbers = findPolyDivisibleNumbers(matriz, 0, 0, new ArrayList<>());
        // Imprimir el resultado en la consola
        System.out.println(Arrays.toString(polyDivisibleNumbers));

        endTime = System.nanoTime(); // Medir el tiempo de finalización

        tiempoEjecucion = endTime - startTime; // Calcular la duración de la ejecución en nanosegundos
        duracionEnSegundos = (double) tiempoEjecucion / 1000000000.0; // Convertir la duración a segundos

        // Imprimir el resultado en la consola
        System.out.println("Tiempo de ejecución: " + duracionEnSegundos + " segundos");

    }

    /**
     * @param n dato a comprobar
     * Método que comprueba si un número es polidivisible
     *
     *          ORDEN DE COMPLEJIDAD O(LOG(N))
     */
    public static boolean isPolyDivisible(int n, int divisor) {
        if (n == 0) { // Caso base: no quedan dígitos por comprobar
            return true;
        }
        if (n % divisor != 0) { // Si el dígito actual no es divisible por su posición...
            return false; // ...el número no es polidivisible, devolvemos false.
        }
        // Llamada recursiva para comprobar el siguiente dígito
        return isPolyDivisible(n / 10, divisor - 1);
    }

    /**
     * Método para encontrar números polidivisibles en una matriz
     *
     * @param matrix
     * @param row
     * @param col
     * @param resultList
     * @return
     */
    public static int[] findPolyDivisibleNumbers(int[][] matrix, int row, int col, List<Integer> resultList) {

        if (row == matrix.length) { // Caso base: se han revisado todas las filas
            int[] resultArray = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                resultArray[i] = resultList.get(i);
            }
            return resultArray;
        }

        if (col == matrix[row].length) {    // Si se ha revisado toda la fila actual...
                                            // ...pasar a la siguiente fila (row + 1)
            return findPolyDivisibleNumbers(matrix, row + 1, 0, resultList);
        }

        int num = matrix[row][col];
        //Validación del número polidivisible y con la condición num>0...
        //... se excluyen los números negativos y el cero
        if (num > 0 && isPolyDivisible(num, Integer.toString(num).length())) {
            resultList.add(num);
        }
        // Llamada recursiva para revisar el siguiente número en la misma fila (col + 1)
        return findPolyDivisibleNumbers(matrix, row, col + 1, resultList);
    }

}
