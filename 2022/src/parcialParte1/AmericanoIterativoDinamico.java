package parcialParte1;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Aquí se encuentran los métodos de arreglos, recursivo y de ArrayList
 */
public class AmericanoIterativoDinamico {

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

        multiplicarAmericanoArrayList(arr1, arr2);

    }


    public static ArrayList<BigInteger> multiplicarAmericanoArrayList(BigInteger[] arr1, BigInteger[] arr2){
        ArrayList<BigInteger>resultado = new ArrayList<>();
        BigInteger k;
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

        //Recorre el arreglo multiplicador desde la última posición
        System.out.println("Tamanio del Arraylist Resultado: "+resultado.size());
        for (int i = arr2.length -1; i>=0; i--){

            //Verifica a qué tan lejos está del borde derecho de resultado
            k  = BigInteger.valueOf(resultado.size() - (arr2.length - i));
            //Recorre el arreglo multiplicando desde la última posición
            for (int j = arr1.length - 1; j >= 0; j--) {

                //Realiza la multiplicación y suma sobre el resultado anterior
                resultado.set(k.intValue(), arr1[j].multiply(arr2[i]).add(acarreo).add(resultado.get(k.intValue())));

                if(resultado.get(k.intValue()).compareTo(BigInteger.TEN) >= 0){
                    acarreo = resultado.get(k.intValue()).divide(BigInteger.TEN);
                    resultado.set(k.intValue(), resultado.get(k.intValue()).mod(BigInteger.TEN));
                } else {
                    acarreo = BigInteger.ZERO;
                }
                k = k.subtract(BigInteger.ONE);
            }
            resultado.set(k.intValue(), acarreo);
            //resultado[k]=acarreo;
            acarreo = BigInteger.ZERO;
        }
        imprimirResultadoArrayList(resultado);
        return resultado;
    }

    private static void imprimirResultadoArrayList(ArrayList<BigInteger> resultado) {
        System.out.println("\nResultado:");
        for (BigInteger value : resultado) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}


