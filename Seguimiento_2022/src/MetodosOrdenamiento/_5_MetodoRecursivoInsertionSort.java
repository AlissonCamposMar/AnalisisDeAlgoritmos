package MetodosOrdenamiento;

public class _5_MetodoRecursivoInsertionSort {

    public static void InsertionSortRecursive(double arreglo[]){
        System.out.println("Método insertionSortRecursive");
        InsercionRecursiva(arreglo, arreglo.length);
    }
    public static void InsercionRecursiva(double arreglo[], int tamArr){

        //Caso Base
        if (tamArr <= 1)
            return;

        //Ordenar los primeros n-1 elementos
        InsercionRecursiva(arreglo, tamArr-1);

        // Inserta el último elemento en su posición correcta
        // en una matriz ordenada.
        double ultimo = arreglo[tamArr-1];
        int i = tamArr-2;

        /* Mover elementos de arreglo[0..i-1], que son
        mayor que la llave, a una posición por delante
        de su puesto actual*/
        while (i >= 0 && arreglo[i] > ultimo){
            arreglo[i+1] = arreglo[i];
            i--;
        }
        arreglo[i+1] = ultimo;

    }
}
