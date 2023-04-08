package punto4_4;

public class matrizImpar {
    public static void main(String[] args) {
        int n = 5; // Tamaño de la matriz
        int[][] matriz = new int[n][n]; // Declaración de la matriz

        // Llenado de la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i < n / 3) {
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

        // Impresión de la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
