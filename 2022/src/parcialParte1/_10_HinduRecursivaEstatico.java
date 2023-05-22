package parcialParte1;

public class _10_HinduRecursivaEstatico {

    public static void main(String[] args) {
        int[] arr1 = {9,9,9,9,9,9,9,9,9};
        int[] arr2 = {9,9,9,9,9,9,9,9,9};

        System.out.println("Arreglo multiplicando");
        imprimirArreglo(arr1);

        System.out.println("\nArreglo multiplicador");
        imprimirArreglo(arr2);
        System.out.println();

        int[] resultado = multiplicarIndu(arr1, arr2);

        System.out.println("\nResultado");
        imprimirArreglo(resultado);
    }

    private static int[] multiplicarIndu(int[] arr1, int[] arr2) {
        int[] resultado = new int[arr1.length + arr2.length];
        int[] acarreo = new int[resultado.length];

        multiplicarRecursivo(arr1, arr2, resultado, acarreo, arr2.length - 1, resultado.length - 1);

        ajustarAcarreo(resultado, acarreo);

        return resultado;
    }

    private static void multiplicarRecursivo(int[] arr1, int[] arr2, int[] resultado, int[] acarreo, int i, int k) {
        if (i >= 0) {
            k = resultado.length - (arr2.length - i);

            for (int j = arr1.length - 1; j >= 0; j--) {
                resultado[k] += arr1[j] * arr2[i];

                if (resultado[k] >= 10) {
                    acarreo[k - 1] += resultado[k] / 10;
                    resultado[k] = resultado[k] % 10;
                } else {
                    acarreo[k - 1] = 0;
                }

                k--;
            }

            multiplicarRecursivo(arr1, arr2, resultado, acarreo, i - 1, k);
        }
    }

    private static void ajustarAcarreo(int[] resultado, int[] acarreo) {
        for (int i = resultado.length - 1; i >= 0; i--) {
            resultado[i] += acarreo[i];

            if (resultado[i] >= 10) {
                acarreo[i - 1] += resultado[i] / 10;
                resultado[i] = resultado[i] % 10;
            }
        }
    }

    private static void imprimirArreglo(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
