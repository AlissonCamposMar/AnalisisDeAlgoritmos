package parcialParte1;

import java.math.BigInteger;

public class _10_HinduRecursivaEstatico {

    public static void main(String[] args) {
        BigInteger[] arr1 = { BigInteger.valueOf(9),
                BigInteger.valueOf(9), BigInteger.valueOf(9),
                BigInteger.valueOf(9), BigInteger.valueOf(9),
                BigInteger.valueOf(9), BigInteger.valueOf(9)};

        BigInteger[] arr2 = { BigInteger.valueOf(9),
                BigInteger.valueOf(9), BigInteger.valueOf(9),
                BigInteger.valueOf(9), BigInteger.valueOf(9),
                BigInteger.valueOf(9), BigInteger.valueOf(9)};

        System.out.println("Arreglo multiplicando");
        for(BigInteger l: arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (BigInteger h : arr2)
            System.out.print(h + " ");
        System.out.println();

        System.out.println("\nResultado");
        multiplicarIndu(arr1, arr2);
    }

    private static void multiplicarIndu(BigInteger[] arr1, BigInteger[] arr2) {
        BigInteger[] resultado = new BigInteger[arr1.length + arr2.length];
        BigInteger[] acarreo = new BigInteger[resultado.length];

        for (int index = 0; index < resultado.length; index++) {
            resultado[index] = BigInteger.ZERO;
            acarreo[index] = BigInteger.ZERO;
        }

        multiplicarRecursivo(arr1, arr2, resultado, acarreo, arr2.length - 1, resultado.length - 1);
        ajustarAcarreo(resultado, acarreo);
        imprimirArreglo(resultado);
    }

    private static void multiplicarRecursivo(BigInteger[] arr1, BigInteger[] arr2, BigInteger[] resultado, BigInteger[] acarreo, int i, int k) {
        if (i >= 0) {
            k = resultado.length - (arr2.length - i);

            for (int j = arr1.length - 1; j >= 0; j--) {
                resultado[k] = resultado[k].add(arr1[j].multiply(arr2[i]));

                if (resultado[i].compareTo(BigInteger.TEN) >= 0) {
                    acarreo[k-1] = acarreo[k-1].add(resultado[k].divide(BigInteger.TEN));
                    resultado[k] = resultado[k].mod(BigInteger.TEN);
                } else {
                    acarreo[k - 1] = BigInteger.ZERO;
                }

                k--;
            }

            multiplicarRecursivo(arr1, arr2, resultado, acarreo, i - 1, k);
        }
    }

    private static void ajustarAcarreo(BigInteger[] resultado, BigInteger[] acarreo) {
        for (int i = resultado.length - 1; i >= 0; i--) {
            resultado[i] = resultado[i].add(acarreo[i]);;

            if (resultado[i].compareTo(BigInteger.TEN) >= 0) {
                acarreo[i-1] = acarreo[i-1].add(resultado[i].divide(BigInteger.TEN));
                resultado[i] = resultado[i].mod(BigInteger.TEN);
            }
        }
    }

    private static void imprimirArreglo(BigInteger[] arr) {
        for (BigInteger i : arr) {
            System.out.print(i + " ");
        }
    }
}
