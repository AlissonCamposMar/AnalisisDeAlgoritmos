package parcialParte1;

import java.math.BigInteger;
import java.util.ArrayList;

public class AmericanoRecursivoDinamico {

    public static void main(String[] args){
        BigInteger[] arr1 = {BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9)};
        BigInteger[] arr2 = {BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9)};

        System.out.println("Arreglo multiplicando");
        for(BigInteger l: arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (BigInteger h : arr2)
            System.out.print(h + " ");
        System.out.println();

        ArrayList<BigInteger> resultado = new ArrayList<>();
        multiplicarAmericanoArrayList(arr1, arr2, resultado);
    }

    public static ArrayList<BigInteger> multiplicarAmericanoArrayList(BigInteger[] arr1, BigInteger[] arr2, ArrayList<BigInteger> resultado) {

        BigInteger k = BigInteger.ZERO;
        BigInteger acarreo = BigInteger.ZERO;
        int longitud = arr1.length + arr2.length;

        for(int i = 0; i< longitud; i++){
            resultado.add(BigInteger.ZERO);
        }

        System.out.print("\n");

        if(arr1.length > arr2.length){
            BigInteger[] arrAux1 = arr1;
            arr1 = arr2;
            arr2 = arrAux1;
        }

        multiplicarRecursivo(arr1, arr2, resultado, arr2.length - 1, k, acarreo);

        imprimirResultadoArrayList(resultado);
        return resultado;
    }

    public static void multiplicarRecursivo(BigInteger[] arr1, BigInteger[] arr2,
                                            ArrayList<BigInteger> resultado, int i, BigInteger k, BigInteger acarreo) {
        if (i >= 0) {
            k = BigInteger.valueOf(resultado.size() - (arr2.length - i));

            multiplicarRecursivo(arr1, arr2, resultado, i - 1, k, acarreo);

            for (int j = arr1.length - 1; j >= 0; j--) {
                resultado.set(k.intValue(), arr1[j].multiply(arr2[i]).add(acarreo).add(resultado.get(k.intValue())));
                if (resultado.get(k.intValue()).compareTo(BigInteger.TEN) >= 0) {
                    acarreo = resultado.get(k.intValue()).divide(BigInteger.TEN);
                    resultado.set(k.intValue(), resultado.get(k.intValue()).mod(BigInteger.TEN));
                } else {
                    acarreo = BigInteger.ZERO;
                }
                k = k.subtract(BigInteger.ONE);
            }
            resultado.set(k.intValue(), acarreo);
            acarreo = BigInteger.ZERO;
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
