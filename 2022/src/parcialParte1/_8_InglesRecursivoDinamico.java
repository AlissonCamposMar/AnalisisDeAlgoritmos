package parcialParte1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Alisson Campos M 1005087645
 * Johan Andrey Ortiz 1094880380
 *
 * Aquí se encuentran los métodos de arreglos, recursivo y de ArrayList
 */
public class _8_InglesRecursivoDinamico {

    public static void main(String[] args){
        ArrayList<BigInteger> arrayList1 = new ArrayList<>();
        arrayList1.add(BigInteger.valueOf(9));
        arrayList1.add(BigInteger.valueOf(9));
        arrayList1.add(BigInteger.valueOf(9));
        arrayList1.add(BigInteger.valueOf(9));
        arrayList1.add(BigInteger.valueOf(9));
        arrayList1.add(BigInteger.valueOf(9));
        arrayList1.add(BigInteger.valueOf(9));

        ArrayList<BigInteger> arrayList2 = new ArrayList<>();
        arrayList2.add(BigInteger.valueOf(9));
        arrayList2.add(BigInteger.valueOf(9));
        arrayList2.add(BigInteger.valueOf(9));
        arrayList2.add(BigInteger.valueOf(9));
        arrayList2.add(BigInteger.valueOf(9));
        arrayList2.add(BigInteger.valueOf(9));
        arrayList2.add(BigInteger.valueOf(9));

        System.out.println("Arreglo multiplicando");
        for(BigInteger l: arrayList1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (BigInteger h : arrayList2)
            System.out.print(h + " ");
        System.out.println();

        multiplicarArrayListAmericanoRecursivo(arrayList1, arrayList2);

    }

    private static void multiplicarArrayListAmericanoRecursivo(ArrayList<BigInteger> arrayList1, ArrayList<BigInteger> arrayList2) {

        int longitud = arrayList1.size() + arrayList2.size();
        ArrayList<BigInteger> resultado = new ArrayList<>(Collections.nCopies(longitud, null));

        int i = 0;
        int j = 0;
        int k = longitud - 1;

        for (int x = 0; x < resultado.size(); x++) {
            resultado.set(x, BigInteger.ZERO);
        }

        multiplicarRecursivo(arrayList1, arrayList2, resultado, i, j, k);
        imprimirResultado(resultado);
    }

    private static ArrayList<BigInteger> multiplicarRecursivo(ArrayList<BigInteger> arrayList1, ArrayList<BigInteger> arrayList2, ArrayList<BigInteger> resultado, int i, int j, int k) {

        if(i == arrayList2.size() - 1 && j == arrayList1.size()){

            if (k > 0){
                resultado.set(k - 1, resultado.get(k - 1).add(resultado.get(k).divide(BigInteger.TEN)));
                resultado.set(k, resultado.get(k).mod(BigInteger.TEN));
                k--;
                multiplicarRecursivo(arrayList1,arrayList2,resultado,i,j,k);
            } else {
                return resultado;
            }
        } else if (j == arrayList1.size() && i < arrayList2.size()-1) {

            j = 0;
            i++;

            multiplicarRecursivo(arrayList1,arrayList2,resultado,i,j,k);

        } else if (j < arrayList1.size()){
            resultado.set(i + j + 1, resultado.get(i + j + 1).add(arrayList1.get(j).multiply(arrayList2.get(i))));
            j++;
            multiplicarRecursivo(arrayList1,arrayList2,resultado,i,j,k);
        }

        return resultado;
    }



    private static void imprimirResultado(ArrayList<BigInteger> resultado) {
        System.out.println("Resultado");
        for (int i = 0; i< resultado.size(); i++){
            System.out.print(resultado.get(i) + " ");
        }
    }
}


