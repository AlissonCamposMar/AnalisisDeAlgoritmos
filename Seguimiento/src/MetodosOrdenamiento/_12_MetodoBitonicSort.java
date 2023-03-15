package MetodosOrdenamiento;

public class _12_MetodoBitonicSort {
    public static void main(String[] args) {

        int arreglo[];
        int numElementos;
        long tiempoInicioEjecucion = System.nanoTime();

        numElementos = 2;
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
        sort(arreglo, arreglo.length, 1);

        imprimirNumOrdenados(arreglo);
    }

    public static void sort(int arreglo[], int N, int up){
        bitonicSort(arreglo, 0, N, up);
    }

    public static void bitonicSort(int[] arreglo, int bajo, int cnt, int dir) {
        if (cnt > 1){
            int k = cnt/2;

            bitonicSort(arreglo, bajo, k, 1);
            bitonicSort(arreglo, bajo + k, k, 0);
            bitonicSort(arreglo, bajo, cnt, dir);
        }
    }


    public static void imprimirNumOrdenados(int[] arreglo) {
        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int k=0;k< arreglo.length;k++){
            System.out.print(" - " + arreglo[k]);
        }
    }
}
