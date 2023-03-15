package MetodosOrdenamiento;

public class _8_MetodoMergeSort {
    public static void main(String[] args) {

        int arreglo[];
        int numElementos;
        long tiempoInicioEjecucion = System.nanoTime();

        numElementos = 410000;
        //System.out.println("Hello world!");

        System.out.println("\nTamanio del arreglo es: " + numElementos + "\n");

        arreglo = new int[numElementos];

        ingresarNumeros(arreglo, numElementos);

        long tiempoFinEjecucion = System.nanoTime();
        long totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        double segundos = (double) totalTiempoEjecucion/1000000000.0;

        System.out.println("\nTiempo de ejecución en segundos: " + segundos);
    }

    public static void ingresarNumeros(int arreglo[], int numElementos){
        for(int i= 0; i<numElementos;i++){
            arreglo[i] = (int) (Math.random()*numElementos);
        }
        imprimirNumOrdenados(mergeSort(arreglo));
    }

    private static int[] mergeSort(int[] arreglo) {
        if (arreglo == null)
            return arreglo;

        if (arreglo.length > 1){
            int mid = arreglo.length/2;

            //Dividir la parte izquierda
            int[] left = new int[mid];
            for (int i = 0 ; i < mid ; i++){
                left[i] = arreglo[i];
            }

            //Dividir la parte derecha
            int[] right = new int[arreglo.length - mid];
            for (int i = mid ; i < arreglo.length ; i++){
                right[i - mid] = arreglo[i];
            }
            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Combinar matrices izquierda y derecha
            while(i < left.length && j < right.length) {
                if(left[i] < right[j]) {
                    arreglo[k] = left[i];
                    i++;
                }
                else {
                    arreglo[k] = right[j];
                    j++;
                }
                k++;
            }

            // Recoge los elementos restantes
            while(i < left.length) {
                arreglo[k] = left[i];
                i++;
                k++;
            }
            while(j < right.length) {
                arreglo[k] = right[j];
                j++;
                k++;
            }
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
