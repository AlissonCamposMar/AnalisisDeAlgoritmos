package MetodosOrdenamiento;

public class MetodoRecursivoInsertionSort {
    public static void main(String[] args) {

        int arreglo[];
        int numElementos;
        long tiempoInicioEjecucion = System.nanoTime();

        //numElementos = 410000;
        numElementos = 11000;
        //System.out.println("Hello world!");

        System.out.println("\nTamanio del arreglo es: " + numElementos + "\n");

        arreglo = new int[numElementos];

        ingresarNumeros(arreglo);

        long tiempoFinEjecucion = System.nanoTime();
        long totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        double segundos = (double) totalTiempoEjecucion/1000000000.0;

        System.out.println("\nTiempo de ejecución en segundos: " + segundos);
    }

    public static void ingresarNumeros(int arreglo[]){
        for(int i= 0; i<arreglo.length;i++){
            arreglo[i] = (int) (Math.random()* arreglo.length);
        }
        //insertionSort(arreglo);
        insertionSortRecursive(arreglo, arreglo.length);
    }

    private static void insertionSort(int[] arreglo) {
        for(int incr = arreglo.length/2 ; incr>0 ; incr/=2){
            for (int i = incr ; i < arreglo.length ; i++){
                int j = i - incr;
                while (j >= 0){
                    if(arreglo[j] > arreglo[j + incr]){
                        int T = arreglo[j];
                        arreglo[j] = arreglo[j+incr];
                        arreglo[j+incr] = T;
                        j -= incr;
                    } else {
                        j = -1;
                    }
                }
            }
        }
        imprimirNumOrdenados(arreglo);
    }

    private static void insertionSortRecursive(int arreglo[], int tamArr){

        //Caso Base
        if (tamArr <= 1)
            return;

        //Ordenar los primeros n-1 elementos
        insertionSortRecursive(arreglo, tamArr-1);

        // Inserta el último elemento en su posición correcta
        // en una matriz ordenada.
        int ultimo = arreglo[tamArr-1];
        int j = tamArr-2;

        /* Mover elementos de arreglo[0..i-1], que son
        mayor que la llave, a una posición por delante
        de su puesto actual*/
        while (j >= 0 && arreglo[j] > ultimo){
            arreglo[j+1] = arreglo[j];
            j--;
        }
        arreglo[j+1] = ultimo;

        imprimirNumOrdenados(arreglo);
    }

    private static void imprimirNumOrdenados(int[] arreglo) {
        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int k=0;k< arreglo.length;k++){
            System.out.print(" - " + arreglo[k]);
        }
    }
}
