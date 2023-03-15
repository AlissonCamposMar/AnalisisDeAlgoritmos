package MetodosOrdenamiento;

public class _14_MetodoBinaryInsertionSort {
    public static void main(String[] args) {

        int arreglo[];
        int numElementos;
        long tiempoInicioEjecucion = System.nanoTime();

        numElementos = 410000;
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
        _14_MetodoBinaryInsertionSort ordenarArray = new _14_MetodoBinaryInsertionSort();
        ordenarArray.sort(arreglo);
        ordenarArray.imprimirNumOrdenados(arreglo);

        //new _14_MetodoBinaryInsertionSort().binaryInsercionSort(arreglo);
    }

    private static void sort(int[] arreglo) {
        boolean swapped = true;
        int start = 0;
        int end = arreglo.length;
        while (swapped == true) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (arreglo[i] > arreglo[i + 1]) {
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (arreglo[i] > arreglo[i + 1]) {
                    int temp = arreglo[i];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }

    private static void imprimirNumOrdenados(int[] arreglo) {
        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int i=0;i< arreglo.length;i++){
            System.out.print(" - " + arreglo[i]);
        }
    }
}
