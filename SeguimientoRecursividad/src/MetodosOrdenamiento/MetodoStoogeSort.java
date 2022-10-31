package MetodosOrdenamiento;

public class MetodoStoogeSort {
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
        imprimirNumOrdenados(stoogeSort(arreglo,0,0));
    }

    private static int[] stoogeSort(int[] arreglo, int l, int h) {
        if (l >= h)
            return arreglo;

        // Si el primer elemento es más pequeño
        // que el último, cámbialos
        if (arreglo[l] > arreglo[h]){
            int auxt = arreglo[l];
            arreglo[l] = arreglo[h];
            arreglo[h] = auxt;
        }

        // Si hay más de 2 elementos en
        // la matriz
        if (h - l + 1 > 2){
            int auxt = (h - l + 1) / 3;

            // Ordenar recursivamente los primeros 2/3 elementos
            stoogeSort(arreglo, l, h-auxt);

            // Ordenar recursivamente los últimos 2/3 elementos
            stoogeSort(arreglo, l + auxt, h);

            // Ordenar recursivamente los primeros 2/3 elementos
            // otra vez para confirmar
            stoogeSort(arreglo, l, h - auxt);
        }
        return arreglo;
    }

    private static void imprimirNumOrdenados(int[] arreglo) {

        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int k=0;k< arreglo.length;k++){
            System.out.print(" - " + arreglo[k]);
        }
    }
}
