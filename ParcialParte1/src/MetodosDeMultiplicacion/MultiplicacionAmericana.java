package MetodosDeMultiplicacion;

import java.util.ArrayList;

/**
 * Alisson Campos M 1005087645
 * Johan Andrey Ortiz 1094880380
 *
 * Aquí se encuentran los métodos de arreglos, recursivo y de ArrayList
 */
public class MultiplicacionAmericana {
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

        //multiplicarAmericano(arr1, arr2);
        //multiplicarArreglosAmericano(arr1, arr2);
        multiplicarAmericanoArrayList(arr1, arr2);

    }

    //Este método evita que en la ejecución se desborde
    //Si el valor que hay en el arreglo 1 es mayor al valor del arreglo 2 entonces se intercambian
    //Es utilizado en el método recursivo
    private static int[] multiplicarArreglosAmericano(int[] arr1, int[] arr2) {
        int []resultado = new int[arr1.length+ arr2.length];

        if(arr1.length > arr2.length){
            int [] arrAux1 = arr1;
            arr1 = arr2;
            arr2 = arrAux1;
        }

        int acarreo = 0;
        int i = arr2.length-1;
        int j = arr1.length-1;
        int k = resultado.length-1;


        multiplicacionAmericanoRecursivo(arr1, arr2, resultado, acarreo, i, j, k);
        imprimirResultado(resultado);
        return resultado;

    }

    private static int[] multiplicarAmericano(int[] arr1, int[] arr2) {
        int []resultado = new int[arr1.length+ arr2.length];
        int k;
        int acarreo = 0;

        System.out.print("\n");

        if(arr1.length > arr2.length){
            int [] arrAux1 = arr1;
            arr1 = arr2;
            arr2 = arrAux1;
        }
        //Recorre el arreglo multiplicador desde la última posición
        for (int i = arr2.length -1; i>=0; i--){

            //Verifica a qué tan lejos está del borde derecho del arreglo resultado
            k  = resultado.length - (arr2.length - i);
            //Recorre el arreglo multiplicando desde la última posición
            for (int j = arr1.length - 1; j >= 0; j--) {

                //Realiza la multiplicación y suma sobre el resultado anterior
                resultado[k] += arr1[j] * arr2[i] + acarreo;

                /**Condición que verifica si el resultado es igual o mayor a 10
                 * Para indicar que se acumula en el acarreo y que queda almacenado en la posicion [k]
                 * Ejem: 24/10 = 2--->acarreo(lo que se va a sumar en la siguiente multiplicación)
                 * 24%10 = 4 ---> resultado[k]
                 */
                if(resultado[k]>=10){
                    acarreo = resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                } else {
                    acarreo = 0;
                }

                k--;
            }
            resultado[k]=acarreo;
            acarreo=0;
        }
        imprimirResultado(resultado);
        return resultado;
    }

    public static  int[] multiplicacionAmericanoRecursivo(int[] arr1, int[] arr2, int[] resultado, int acarreo, int i, int j, int k){

        if(i==0 && j==0) {
            resultado[k] += arr1[j] * arr2[i] + acarreo;
            if (resultado[k] >= 10) {
                acarreo = resultado[k] / 10;
                resultado[k] = resultado[k] % 10;
            } else {
                acarreo = 0;
            }
            k--;
            resultado[k]=acarreo;
            //System.out.println(arr1[j] + "," + arr2[i]);
            return resultado;
        } else if (j == 0) {
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

            //Termina el segundo for e itera el arr2 (primer for)
            resultado[k] = acarreo;
            acarreo = 0;
            i--;
            j = arr1.length-1;
            k = resultado.length - (arr2.length - i);
            multiplicacionAmericanoRecursivo(arr1,arr2,resultado,acarreo,i,j,k);
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
            multiplicacionAmericanoRecursivo(arr1,arr2,resultado,acarreo,i,j,k);

        }

        return resultado;
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

    private static void imprimirResultado(int[] resultado) {
        System.out.println("Resultado");
        for (int i = 0; i< resultado.length; i++){
            System.out.print(resultado[i] + " ");
        }
    }


}


