package parcialParte1;

public class HinduRecursivaEstatico {

    public static void main(String[] args){
        int [] arr1 = {9,9,9,9,9,9,9,9,9};
        int [] arr2 = {9,9,9,9,9,9,9,9,9};

        System.out.println("Arreglo multiplicando");
        for(int l: arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (int h : arr2)
            System.out.print(h + " ");
        System.out.println();

        multiplicarIndu(arr1, arr2);

    }

    private static int[] multiplicarIndu(int[] arr1, int[] arr2) {

        int[] resultado = new int[arr1.length+ arr2.length];
        int[] acarreo = new int[arr1.length + arr2.length];
        int i = arr2.length -1;
        int j = arr1.length - 1;

        multiplicarRecursivo(arr1, arr2, resultado, acarreo, i, j);
        imprimirResultado(resultado);
        return resultado;
    }

    private static int[] multiplicarRecursivo(int[] arr1, int[] arr2, int[] resultado,
                                              int[] acarreo, int i, int j) {
        if (i == arr2.length) {
            return resultado;
        }

        int k = resultado.length - (arr2.length - i);

        if (j >= 0) {
            resultado[k] += arr1[j] * arr2[i];

            if (resultado[k] >= 10) {
                acarreo[k - 1] += resultado[k] / 10;
                resultado[k] = resultado[k] % 10;
            } else {
                acarreo[k - 1] = 0;
            }

            return multiplicarRecursivo(arr1, arr2, resultado, acarreo, i, j - 1);
        }

        if (k > 0) {
            resultado[k] += acarreo[k - 1];

            if (resultado[k] >= 10) {
                acarreo[k - 1] += resultado[k] / 10;
                resultado[k] = resultado[k] % 10;
            } else {
                acarreo[k - 1] = 0;
            }

            return multiplicarRecursivo(arr1, arr2, resultado, acarreo, i + 1, arr2.length - 1);
        }

        return multiplicarRecursivo(arr1, arr2, resultado, acarreo, i + 1, arr2.length - 1);
    }

    private static void imprimirResultado(int[] resultado) {
        System.out.println("Resultado");
        for (int i = 0; i< resultado.length; i++){
            System.out.print(resultado[i] + " ");
        }
    }
}
