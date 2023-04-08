package punto4_4;

public class matrizImparRecursivo {
    public static void main(String[] args) {
        int n = 5; // Tamaño de la matriz
        int[][] matriz = new int[n][n]; // Declaración de la matriz

        llenarMatrizRecursivo(matriz, n, 0, 0);
        imprimirMatriz(matriz, n, 0, 0);
    }
    private static void llenarMatrizRecursivo(int[][] matriz, int n, int i, int j) {
        // Base case: si se han completado todas las filas, terminar la función recursiva
        if (i == n) {
            return;
        }

        // Si se han completado todas las columnas en la fila actual, pasar a la siguiente fila
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

        // Recursivamente llamar a la función para la siguiente columna en la misma fila
        llenarMatrizRecursivo(matriz, n, i, j+1);
    }

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
}
