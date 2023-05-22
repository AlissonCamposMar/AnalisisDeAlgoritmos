package parcialParte1;

import java.util.ArrayList;

public class _6_InglesIterativoDinamico {

    public static void main(String[] args){
        int [] arr1 = {9,9,9,9,9,9,9,9,9};
        int [] arr2 = {9,9,9,9,9,9,9};


        System.out.println("Arreglo multiplicando");
        for(int l: arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (int h : arr2)
            System.out.print(h + " ");
        System.out.println();

        multiplicarInglesArrayList(arr1, arr2);

    }

    public static ArrayList<Integer> multiplicarInglesArrayList (int[] arr1, int[] arr2){

        ArrayList<Integer>resultado = new ArrayList<>();
        int k = 0;
        int acarreo = 0;
        int longitud = arr1.length + arr2.length;

        for(int i = 0; i< longitud; i++){
            resultado.add(0);
        }

        System.out.print("\n");

        if(arr1.length > arr2.length){
            int [] arrAux1 = arr1;
            arr1 = arr2;
            arr2 = arrAux1;
        }

        //Recorre el arreglo multiplicador desde la primera posición
        for (int i = 0; i<arr2.length; i++){
            k  = arr2.length - 1 + i;
            for (int j = arr1.length-1; j>=0; j--){

                resultado.set(k, arr1[j] * arr2[i] + acarreo + resultado.get(k));

                if(resultado.get(k)>=10){
                    acarreo = resultado.get(k)/10;
                    resultado.set(k, resultado.get(k)%10);
                } else {
                    acarreo = 0;
                }
                k--;
            }
            if(acarreo != 0){
                resultado.set(k, acarreo + resultado.get(k));
                // resultado[k] += acarreo;
                if(resultado.get(k)>=10){
                    acarreo = resultado.get(k)/10;
                    resultado.set(k, resultado.get(k)%10);
                    resultado.set(k-1, acarreo + resultado.get(k));
                    //resultado[k - 1] += acarreo;
                }
                acarreo = 0;
            }

        }
        imprimirResultadoArrayList(resultado);
        return resultado;
    }

    private static void imprimirResultadoArrayList(ArrayList<Integer> resultado) {
        System.out.println("Resultado");
        for (int i = 0; i< resultado.size(); i++){
            System.out.print(resultado.get(i) + " ");
        }
    }
}
