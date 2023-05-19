package parcialParte1;

import java.util.ArrayList;

/**
 * Aquí se encuentran los métodos de arreglos, recursivo y de ArrayList
 */
public class AmericanoIterativoDinamico {
    public static void main(String[] args){
        int [] arr1 = {9,9,9,9,9,9,9};
        int [] arr2 = {9,9,9,9,9,9};


        System.out.println("Arreglo multiplicando");
        for(int l: arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (int h : arr2)
            System.out.print(h + " ");
        System.out.println();

        multiplicarAmericanoArrayList(arr1, arr2);

    }


    public static ArrayList<Integer> multiplicarAmericanoArrayList(int[] arr1, int[] arr2){
        ArrayList<Integer>resultado = new ArrayList<>();
        int k;
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

        //Recorre el arreglo multiplicador desde la última posición
        System.out.println("tamaño del arraylist: "+resultado.size());
        for (int i = arr2.length -1; i>=0; i--){

            //Verifica a qué tan lejos está del borde derecho de resultado
            k  = resultado.size() - (arr2.length - i);
            //Recorre el arreglo multiplicando desde la última posición
            for (int j = arr1.length - 1; j >= 0; j--) {

                //Realiza la multiplicación y suma sobre el resultado anterior
                resultado.set(k, arr1[j] * arr2[i] + acarreo + resultado.get(k));

                if(resultado.get(k)>=10){
                    acarreo = resultado.get(k)/10;
                    resultado.set(k, resultado.get(k)%10);
                } else {
                    acarreo = 0;
                }
                k--;
            }
            resultado.set(k, acarreo);
            //resultado[k]=acarreo;
            acarreo=0;
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


