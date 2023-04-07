package MetodosDeMultiplicacion;

import java.util.ArrayList;

/**
 * Alisson Campos M 1005087645
 * Johan Andrey Ortiz 1094880380
 *
 * Aquí se encuentran los métodos de arreglos, recursivo y de ArrayList
 */
public class MultiplicacionInglesa {
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

        //multiplicarArreglosIngles(arr1, arr2);
        //multiplicarIngles(arr1, arr2);
        multiplicarInglesArrayList(arr1, arr2);

    }

    //Este método evita que en la ejecución se desborde
    //Si el valor que hay en el arreglo 1 es mayor al valor del arreglo 2 entonces se intercambian
    //Es utilizado en el método recursivo
    public static int[] multiplicarArreglosIngles(int[] arr1, int[] arr2){
     int []resultado = new int[arr1.length+ arr2.length];

     if(arr1.length > arr2.length){
         int [] arrAux1 = arr1;
         arr1 = arr2;
         arr2 = arrAux1;
     }

     int acarreo = 0;
     int i= 0;
     int j= arr1.length-1;
     int k = arr2.length - 1 + i;

     multiplicacionInglesRecursivo(arr1, arr2, resultado, acarreo, i, j, k);
     imprimirResultado(resultado);
     return resultado;
 }

    private static int[] multiplicarIngles(int[] arr1, int[] arr2) {

        int[] resultado = new int[arr1.length+ arr2.length];
        int k = 0;
        int acarreo = 0;

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

                resultado[k] += arr1[j] * arr2[i] + acarreo;

                if(resultado[k]>=10){
                    acarreo = resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                } else {
                    acarreo = 0;
                }
                k--;
            }
            if(acarreo != 0){
                resultado[k] += acarreo;
                if(resultado[k]>=10){
                    acarreo = resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                    resultado[k - 1] += acarreo;
                }
                acarreo = 0;
            }

        }
        imprimirResultado(resultado);
        return resultado;
    }

    private static int[] multiplicacionInglesRecursivo(int[] arr1, int[] arr2, int[] resultado, int acarreo, int i, int j, int k) {
        int h= arr2.length - 1;

        if(i==h && j==0){
            resultado[k] += arr1[j] * arr2[i] + acarreo;

            if(resultado[k]>=10){
                acarreo = resultado[k]/10;
                resultado[k] = resultado[k]%10;
            } else {
                acarreo = 0;
            }
            k--;
            if(acarreo != 0){
                resultado[k] += acarreo;
                if(resultado[k]>=10){
                    acarreo = resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                    resultado[k - 1] += acarreo;
                }
                //acarreo = 0;
            }
            //resultado[k]=acarreo;
            //System.out.println(arr1[j] + "," + arr2[i]);
            return resultado;

        } else if (j==0) {
            //System.out.println(arr1[j] + "," + arr2[i]);
            //Está en la posición j=0 e i= cualquier valor del arr1 (For anidado)
            resultado[k] += arr1[j] * arr2[i] + acarreo;
            if(resultado[k]>=10){
                acarreo = resultado[k]/10;
                resultado[k] = resultado[k]%10;
            } else {
                acarreo = 0;
            }
            k--;

            //resultado[k] = acarreo;
            if(acarreo != 0){
                resultado[k] += acarreo;
                if(resultado[k]>=10){
                    acarreo = resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                    resultado[k - 1] += acarreo;
                }
                acarreo = 0;
            }
            i++;
            j = arr1.length - 1;
            k  = arr2.length - 1 + i;
            multiplicacionInglesRecursivo(arr1,arr2,resultado,acarreo,i,j,k);

        } else {
            //System.out.println(arr1[j] + "," + arr2[i]);

            resultado[k] += arr1[j] * arr2[i] + acarreo;
            if(resultado[k]>=10){
                acarreo = resultado[k]/10;
                resultado[k] = resultado[k]%10;
            } else {
                acarreo = 0;
            }
            k--;
            j--;
            multiplicacionInglesRecursivo(arr1,arr2,resultado,acarreo,i,j,k);
        }
        return resultado;
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

    private static void imprimirResultado(int[] resultado) {
        System.out.println("Resultado");
        for (int i = 0; i< resultado.length; i++){
            System.out.print(resultado[i] + " ");
        }
    }
}


