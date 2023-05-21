package parcialParte1;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Aquí se encuentran los métodos de arreglos, recursivo y de ArrayList
 */

/*
 * CON ERROR
 */
public class AmericanoRecursivoDinamico {

    public static void main(String[] args) {
        ArrayList<BigInteger> arr1 = new ArrayList<>();
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));

        ArrayList<BigInteger> arr2 = new ArrayList<>();
        arr2.add(BigInteger.valueOf(9));
        arr2.add(BigInteger.valueOf(9));
        arr2.add(BigInteger.valueOf(9));
        arr2.add(BigInteger.valueOf(9));
        arr2.add(BigInteger.valueOf(9));
        arr2.add(BigInteger.valueOf(9));
        arr2.add(BigInteger.valueOf(9));

        System.out.println("Arreglo multiplicando");
        for (BigInteger l : arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (BigInteger h : arr2)
            System.out.print(h + " ");
        System.out.println();

        multiplicarAmericanoArrayList(arr1, arr2);
    }

    public static ArrayList<BigInteger> multiplicarAmericanoArrayList(ArrayList<BigInteger> arr1,
                                                                      ArrayList<BigInteger> arr2) {

        ArrayList<BigInteger> resultado = new ArrayList<>();
        BigInteger acarreo = BigInteger.ZERO;
        BigInteger k = BigInteger.valueOf(resultado.size() - 1);
        int longitud = arr1.size() + arr2.size();

        for (int i = 0; i < longitud; i++) {
            resultado.add(BigInteger.ZERO);
        }

        System.out.print("\n");

        if (arr1.size() > arr2.size()) {
            ArrayList<BigInteger> arrAux1 = arr1;
            arr1 = arr2;
            arr2 = arrAux1;
        }

        System.out.println("Tamaño del ArrayList Resultado: " + resultado.size());
        multiplicacionAmericanoRecursivo(arr1, arr2, resultado, acarreo, k);

        imprimirResultadoArrayList(resultado);

        return resultado;
    }

    private static void multiplicacionAmericanoRecursivo(ArrayList<BigInteger> arr1, ArrayList<BigInteger> arr2,
                                             ArrayList<BigInteger> resultado, BigInteger acarreo,
                                             BigInteger k) {
        if (k.compareTo(BigInteger.ZERO) >= 0) {
            int i = arr2.size() - k.intValue() - 1;
            int j = arr1.size() - (resultado.size() - k.intValue()) - 1;

            if (j >= 0) {
                resultado.set(k.intValue(), arr1.get(j).multiply(arr2.get(i)).add(acarreo).add(resultado.get(k.intValue())));

                if (resultado.get(k.intValue()).compareTo(BigInteger.TEN) >= 0) {
                    acarreo = resultado.get(k.intValue()).divide(BigInteger.TEN);
                    resultado.set(k.intValue(), resultado.get(k.intValue()).mod(BigInteger.TEN));
                } else {
                    acarreo = BigInteger.ZERO;
                }
            } else {
                resultado.set(k.intValue(), acarreo);
                acarreo = BigInteger.ZERO;
            }

            k = k.subtract(BigInteger.ONE);

            multiplicacionAmericanoRecursivo(arr1, arr2, resultado, acarreo, k);
        }
    }

    private static void imprimirResultadoArrayList(ArrayList<BigInteger> resultado) {
        System.out.println("\nResultado:");
        for (BigInteger value : resultado) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
