package MultiplicacionDeMatrices;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

public class III_5EnhancedParallelBlock_PREGUNTAR {
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
         * este no es la traduccion más fidedigna
         */

        //III.5 Enhanced Parallel Block

        /*IntStream.range(0, 2).parallel().forEach(idx -> {
            int i1 = idx * size / 2;
            for (int j1 = 0; j1 < size; j1 += bsize)
                for (int k1 = 0; k1 < size; k1 += bsize)
                    for (int i = i1; i < i1 + size / 2 && i < size; i++)
                        for (int j = j1; j < j1 + bsize && j < size; j++)
                            for (int k = k1; k < k1 + bsize && k < size; k++)
                                matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
        });*/


        //Otra posibilidad
        IntStream.range(0, 2).parallel().forEach(idx -> {
            int start = idx * size / 2;
            int end = (idx + 1) * size / 2;

            for (int i1 = start; i1 < end; i1 += bsize) {
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        for (int i = i1; i < Math.min(i1 + bsize, size); i++) {
                            for (int j = j1; j < Math.min(j1 + bsize, size); j++) {
                                for (int k = k1; k < Math.min(k1 + bsize, size); k++) {
                                    matrizA[i][j] += matrizB[i][k] * matrizC[k][j];
                                }
                            }
                        }
                    }
                }
            }
        });


        imprimirMatriz(matrizA, "A", size);

    }
}
