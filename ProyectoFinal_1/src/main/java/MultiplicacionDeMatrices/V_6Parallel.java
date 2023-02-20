package MultiplicacionDeMatrices;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

public class V_6Parallel {
    public static int[][] llenarMatrizAleatoria(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(10); // Valor aleatorio entre 0 y 99
            }
        }

        return matriz;
    }

    public void imprimirMatriz(int[][] matriz,String letra,int size)
    {
        // Imprimir la matriz A
        System.out.println("Matriz"+letra+": ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }

    }
    @Test
    public void metodosTraducidos(){

        // Tamaño de las matrices
        int size = 4;

        //Raiz cuadrada del tamaño de las matrices
        int bsize = (int) Math.sqrt(size);

        int[][] matrizB = {
                {7, 3, 4, 9},
                {4, 8, 7, 9},
                {2, 8, 0, 5},
                {0, 2, 3, 7}
        };
        //int[][] matrizB = llenarMatrizAleatoria(size, size);
        imprimirMatriz(matrizB, "B", size);

        int[][] matrizC = {
                {7, 0, 2, 8},
                {0, 0, 2, 7},
                {3, 0, 8, 8},
                {8, 9, 8, 4}
        };
        //int[][] matrizC = llenarMatrizAleatoria(size, size);
        imprimirMatriz(matrizC, "C", size);

        //Resultado de esta multiplicación
        /*
         * {133 81 124 145}
         * {121 81 152 180}
         * {54  45 60  92}
         * {65  63 84  66}
         */

        //Matriz del resultado de la multiplicación
        int[][] matrizA = new int[size][size];

        /**
         * Sirve
         */


        //V .6 Parallel

        ForkJoinPool pool = new ForkJoinPool();

        pool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                IntStream.range(0, size).parallel().forEach(i -> {
                    for (int j = 0; j < size; j++) {
                        for (int k = 0; k < size; k++) {
                            matrizA[k][i] += matrizB[k][j] * matrizC[j][i];
                        }
                    }
                });
            }
        });


        imprimirMatriz(matrizA, "A", size);

    }
}
