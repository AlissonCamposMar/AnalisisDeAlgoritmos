package punto4_4;

/**
 * @author Alisson Campos Marin (grupo N)
 * @author Cristhian Andrés Miranda Ramirez (grupo D)
 * @author Diego Alejandro Vera Gonzaléz (grupo D)
 */
public class matrizImparRecursivo {
    public static void main(String[] args) {

        int n = 5; // Tamaño de la matriz
        int[][] matriz = new int[n][n]; // Declaración de la matriz

        double duracionEnSegundos;
        long startTime, endTime, duration;

        startTime = System.nanoTime(); // Medir el tiempo de inicio

        llenarMatrizRecursivo(matriz, n, 0, 0);
        imprimirMatriz(matriz, n, 0, 0);

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
     * @param i
     * @param j
     */
    private static void imprimirMatriz(int[][] matriz, int n, int i, int j) {
        // Caso base
        if (i >= n) {
            return;
        }
        // Lógica recursiva
        System.out.print(matriz[i][j] + " ");
        if (j == n-1) {
            System.out.println();
            imprimirMatriz(matriz, n, i+1, 0);
        } else {
            imprimirMatriz(matriz, n, i, j+1);
        }
    }
    /**
     * Método que llena una matriz de n*n con n impar de forma recursiva
     * @param matriz
     * @param n
     * @param i
     * @param j
     *
     * ORDEN DE COMPLEJIDAD O(N^2)
     */
    private static void llenarMatrizRecursivo(int[][] matriz, int n, int i, int j) {
        //Base case: si se han completado todas las filas, terminar la
        // función recursiva
        if (i == n) {
            return;
        }

        //Si se han completado todas las columnas en la fila actual, pasar a
        // la siguiente fila
        if (j == n) {
            llenarMatrizRecursivo(matriz, n, i+1, 0);
            return;
        }

        // Lógica para llenar la matriz recursivamente
        if (i < n / 2) {
            if (j >= i && j < n - i) {
                matriz[j][i] = 1;
            }
        } else {
            if (j >= n - i - 1 && j <= i) {
                matriz[j][i] = 1;
            }
        }
        // Llamada recursiva a la función para la siguiente columna en la misma fila
        llenarMatrizRecursivo(matriz, n, i, j+1);
    }

}
