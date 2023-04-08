package punto4_4;

public class matrizImpar {
    public static void main(String[] args) {
        int n = 5; // Tamaño de la matriz
        int[][] matriz = new int[n][n]; // Declaración de la matriz

        llenarMatriz(matriz, n);
        imprimirMatriz(matriz, n);

    }

    private static void imprimirMatriz(int[][] matriz, int n) {

        // Impresión de la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

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