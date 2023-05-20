package parcialParte1;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Aquí se encuentran los métodos de arreglos, recursivo y de ArrayList
 */
public class AmericanoRecursivoDinamico {

    public static void main(String[] args) {

        BigInteger[] arr1 = {BigInteger.valueOf(9), BigInteger.valueOf(9),
                BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9),
                BigInteger.valueOf(9), BigInteger.valueOf(9)};

        BigInteger[] arr2 = {BigInteger.valueOf(9), BigInteger.valueOf(9),
                BigInteger.valueOf(9), BigInteger.valueOf(9), BigInteger.valueOf(9),
                BigInteger.valueOf(9), BigInteger.valueOf(9)};

        System.out.println("Arreglo multiplicando");
        for (BigInteger l : arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (BigInteger h : arr2)
            System.out.print(h + " ");
        System.out.println();

        ArrayList<BigInteger> resultado = new ArrayList<>();

        imprimirResultadoArrayList(resultado);
    }



    private static void imprimirResultadoArrayList(ArrayList<BigInteger> resultado) {
        System.out.println("\nResultado:");
        for (BigInteger value : resultado) {
            System.out.print(value + " ");
        }
        System.out.println();
    }



}


