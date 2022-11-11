package EjerciciosRecursividad;

/**
 * Alisson Campos M 1005087645
 * Johan Andrey Ortiz 1094880380
 *
 * Punto2 del documento ejercicios recursivos
 */

public class Punto2 {
    /**
     * Escriba un método recursivo que retorne el menor elemento de un arreglo unidimensional de
     * enteros.
     */

    public static void main (String[] args){
        int []arr = {110,-180,400,1000};

        System.out.println("Números del arreglo");
        for(int l: arr)
            System.out.print(l + " ");

        //menorElementoArreglo(arr);
        //System.out.println("\nEl número menor del arreglo es: " + menorNumArreglo(arr, 0));
        System.out.println("\nEl número menor del arreglo es: " + menorNumArregloRecursivo(arr, 0));
    }

    private static int menorNumArreglo(int[] arr, int i) {
        int menor = arr[i];
        //for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if(menor>arr[j]){
                    menor = arr[j];
                }
            //}
        }
        return menor;
    }

    private static int menorNumArregloRecursivo(int[] arr, int i) {
        int ultPos = arr.length - 1;
        int menor;
        int aux;
        if (i == ultPos) {
            return menor = arr[i];
        } else {
            menor = menorNumArregloRecursivo(arr, i+1);
            if (arr[i] < menor){
                aux = arr[i];
            } else {
                aux = menor;
            }
        }
        return aux;
    }
}
