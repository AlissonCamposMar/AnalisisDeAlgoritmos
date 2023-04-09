package punto4_4;

import java.util.Scanner;

/**
 * @author Alisson Campos Marin (grupo N)
 * @author Cristhian Andrés Miranda Ramirez (grupo D)
 * @author Diego Alejandro Vera Gonzaléz (grupo D)
 */
public class matrizImpar {
    public static void main(String[] args) {
        //int n = 5; // Tamaño de la matriz
        //int[][] matriz = new int[n][n]; // Declaración de la matriz

        double duracionEnSegundos;
        long startTime, endTime, duration;

        System.out.println("Ingrese un número impar: ");
        Scanner lectura = new Scanner (System.in);
        int valor = lectura.nextInt();

        while (valor % 2 == 0){
            System.out.println("no es impar, vuelva a ingresarlo: ");
            lectura = new Scanner (System.in);
            valor = lectura.nextInt();

        }

        int[][] matriz = new int[valor][valor];


        startTime = System.nanoTime(); // Medir el tiempo de inicio

        llenarMatriz(matriz, valor);
        imprimirMatriz(matriz, valor);

        endTime = System.nanoTime(); // Medir el tiempo de finalización

        duration = (endTime - startTime); // Calcular la duración de la ejecución en nanosegundos
        duracionEnSegundos = (double) duration / 1000000000.0; // Convertir la duración a segundos

        // Imprimir el resultado en la consola
        System.out.println("Tiempo de ejecución: " + duracionEnSegundos + " segundos");

    }

    /**
     * Método para imprimir una matriz
     * @param matriz
     * @param n
     */
    private static void imprimirMatriz(int[][] matriz, int n) {

        // Impresión de la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Método que llena una matriz de n*n con n impar
     * @param matriz
     * @param n
     *
     * ORDEN DE COMPLEJIDAD O(N^2)
     */
    private static void llenarMatriz(int[][] matriz, int n) {
        // Llenado de la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < n / 2) {
                    if (j >= i && j < n - i) {
                        matriz[j][i] = 1;
                    }
                } else {
                    if (j >= n - i - 1 && j <= i) {
                        matriz[j][i] = 1;
                    }
                }
            }
        }
    }


}