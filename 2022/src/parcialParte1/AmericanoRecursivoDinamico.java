package parcialParte1;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Aquí se encuentran los métodos de arreglos, recursivo y de ArrayList
 */
public class AmericanoRecursivoDinamico {

    public static void main(String[] args) {

        ArrayList <BigInteger> arr1 = new ArrayList<>();
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));

        ArrayList <BigInteger> arr2 = new ArrayList<>();
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));
        arr1.add(BigInteger.valueOf(9));

        System.out.println("Arreglo multiplicando");
        for (BigInteger l : arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (BigInteger h : arr2)
            System.out.print(h + " ");
        System.out.println();

        ArrayList<BigInteger> resultado = multiplicarAmericanoArrayList(arr1, arr2);
        imprimirResultadoArrayList(resultado);

    }

    public static ArrayList<BigInteger> multiplicarAmericanoArrayList(ArrayList<BigInteger> arr1, ArrayList<BigInteger> arr2){
        ArrayList<BigInteger> resultado = new ArrayList<>();
        int longitud = arr1.size() + arr2.size();

        for(int i = 0; i < longitud; i++){
            resultado.add(BigInteger.ZERO);
        }

        if(arr1.size() > arr2.size()){
            ArrayList<BigInteger> arrAux1 = arr1;
            arr1 = arr2;
            arr2 = arrAux1;
        }

        multiplicarRecursivo(arr1, arr2, resultado, BigInteger.ZERO, longitud - 1);

        return resultado;
    }

    private static void multiplicarRecursivo(ArrayList<BigInteger> arr1, ArrayList<BigInteger> arr2, ArrayList<BigInteger> resultado, BigInteger acarreo, int pos){
        if(pos < 0){
            resultado.set(0, acarreo);
            return;
        }

        BigInteger k = BigInteger.valueOf(resultado.size() - (arr2.size() - pos));

        for(int j = arr1.size() - 1; j >= 0; j--){
            resultado.set(k.intValue(), arr1.get(j).multiply(arr2.get(pos)).add(acarreo).add(resultado.get(k.intValue())));

            if(resultado.get(k.intValue()).compareTo(BigInteger.TEN) >= 0){
                acarreo = resultado.get(k.intValue()).divide(BigInteger.TEN);
                resultado.set(k.intValue(), resultado.get(k.intValue()).mod(BigInteger.TEN));
            } else {
                acarreo = BigInteger.ZERO;
            }

            k = k.subtract(BigInteger.ONE);
        }

        resultado.set(k.intValue(), acarreo);
        multiplicarRecursivo(arr1, arr2, resultado, BigInteger.ZERO, pos - 1);
    }

    private static void imprimirResultadoArrayList(ArrayList<BigInteger> resultado) {
        System.out.println("\nResultado:");
        for (BigInteger value : resultado) {
            System.out.print(value + " ");
        }
        System.out.println();
    }



}


