package MetodosOrdenamiento;

public class StoogeSort {
    public static void main(String[] args) {

        int arreglo[];
        int numElementos;
        long tiempoInicioEjecucion = System.nanoTime();

        numElementos = 350000;
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
        stoogeSort(arreglo,0,0);
    }

    private static void stoogeSort(int[] arreglo, int i, int j) {
        if (i>=j)
            return;
        if (arreglo[i]>arreglo[j]){
            int aux = arreglo[i];
            arreglo[i]=arreglo[j];
            arreglo[j]=aux;
        }

        if (j-1+1>2){
            int t = (j-1+1)/3;

            stoogeSort(arreglo, i, j-t);
            stoogeSort(arreglo, i+j, j);
            stoogeSort(arreglo, i, j-t);
        }

        imprimirNumOrdenados(arreglo);
    }

    private static void imprimirNumOrdenados(int[] arreglo) {

        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int k=0;k< arreglo.length;k++){
            System.out.print(" - " + arreglo[k]);
        }

        /**
         * Ordenado de forma decreciente
         */
        System.out.println("\nArreglo ordenado de forma decreciente\n");
        for( int j = arreglo.length-1 ; j >= 0 ; j--) {
            System.out.print(" - " + arreglo[j]);
        }
    }
}
