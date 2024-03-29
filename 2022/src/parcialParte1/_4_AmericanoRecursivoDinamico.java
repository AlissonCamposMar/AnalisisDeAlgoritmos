package parcialParte1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class _4_AmericanoRecursivoDinamico {

    public static void main(String[] args) {
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

        multiplicarArrayListRecursivo(arrayList1, arrayList2);
    }

    private static void multiplicarArrayListRecursivo(ArrayList<BigInteger> arrayList1, ArrayList<BigInteger> arrayList2) {

        int longitud = arrayList1.size() + arrayList2.size();
        ArrayList<BigInteger> resultado = new ArrayList<>(Collections.nCopies(longitud, null));

        if (arrayList1.size() > arrayList2.size()) {
            ArrayList <BigInteger> arrAux1 = arrayList1;
            arrayList1 = arrayList2;
            arrayList2 = arrAux1;
        }

        BigInteger acarreo = BigInteger.ZERO;
        int i = arrayList2.size() - 1;
        int j = arrayList1.size() - 1;
        int k = resultado.size() - 1;

        for (int index = 0; index < longitud; index++) {
            resultado.set(index, BigInteger.ZERO);
        }

        multiplicacionAmericanoRecursivo(arrayList1, arrayList2, resultado, acarreo, i, j, k);
        imprimirResultado(resultado);
    }

    private static void multiplicacionAmericanoRecursivo(ArrayList<BigInteger> arrayList1, ArrayList<BigInteger> arrayList2, ArrayList<BigInteger> resultado, BigInteger acarreo, int i, int j, int k) {

        if(i==0 && j==0) {
            resultado.set(k, resultado.get(k).add(arrayList1.get(j).multiply(arrayList2.get(i))).add(acarreo));

            if (resultado.get(k).compareTo(BigInteger.TEN) >= 0) {
                acarreo = resultado.get(k).divide(BigInteger.TEN);
                resultado.set(k, resultado.get(k).mod(BigInteger.TEN));
            } else {
                acarreo = BigInteger.ZERO;
            }
            k--;
            resultado.set(k, acarreo);
            //System.out.println(arr1[j] + "," + arr2[i]);

        } else if (j == 0) {
            //System.out.println(arr1[j] + "," + arr2[i]);

            //Está en la posición j=0 e i= cualquier valor del arr1 (For anidado)
            resultado.set(k, resultado.get(k).add(arrayList1.get(j).multiply(arrayList2.get(i))).add(acarreo));

            if(resultado.get(k).compareTo(BigInteger.TEN) >= 0){
                acarreo = resultado.get(k).divide(BigInteger.TEN);
                resultado.set(k, resultado.get(k).mod(BigInteger.TEN));
            } else {
                acarreo = BigInteger.ZERO;
            }
            k--;

            //Termina el segundo for e itera el arr2 (primer for)
            resultado.set(k, acarreo);
            acarreo = BigInteger.ZERO;
            i--;
            j = arrayList1.size() - 1;
            k = resultado.size() - (arrayList2.size() - i);
            multiplicacionAmericanoRecursivo(arrayList1,arrayList2,resultado,acarreo,i,j,k);
        } else {
            //System.out.println(arr1[j] + "," + arr2[i]);

            resultado.set(k, resultado.get(k).add(arrayList1.get(j).multiply(arrayList2.get(i))).add(acarreo));

            if(resultado.get(k).compareTo(BigInteger.TEN) >= 0){
                acarreo = resultado.get(k).divide(BigInteger.TEN);
                resultado.set(k, resultado.get(k).mod(BigInteger.TEN));
            } else {
                acarreo = BigInteger.ZERO;
            }
            k--;
            j--;
            multiplicacionAmericanoRecursivo(arrayList1,arrayList2,resultado,acarreo,i,j,k);

        }
    }

    private static void imprimirResultado(ArrayList<BigInteger> resultado) {
        System.out.println("Resultado");
        for (int i = 0; i< resultado.size(); i++){
            System.out.print(resultado.get(i) + " ");
        }
    }

}