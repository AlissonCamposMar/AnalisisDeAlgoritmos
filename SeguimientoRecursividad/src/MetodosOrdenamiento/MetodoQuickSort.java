package MetodosOrdenamiento;

public class MetodoQuickSort {
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
        imprimirNumOrdenados(quickSort(arreglo, 0, arreglo.length-1));
    }

    // Una función de utilidad para intercambiar dos elementos
    static void swap(int[] arreglo, int i, int j) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    /* Esta función toma el último elemento como pivote, coloca
        el elemento de pivote en su posición correcta en ordenado
        matriz, y coloca todos los más pequeños (más pequeños que el pivote)
        a la izquierda del pivote y todos los elementos mayores a la derecha
        de pivote */
    private static int particion(int[] arreglo, int bajo, int alto){

        //pivote
        int pivot = arreglo[alto];

        // Índice del elemento más pequeño y
        // indica la posición correcta
        // del pivote encontrado hasta ahora
        int i = (bajo - 1);

        for (int j = bajo; j <= alto - 1; j++) {

            // Si el elemento actual es más pequeño
            // que el pivote
            if (arreglo[j] < pivot) {

                // Incremento índice de
                // elemento más pequeño
                i++;
                swap(arreglo, i, j);
            }
        }
        swap(arreglo, i + 1, alto);
        return (i + 1);
    }


    /* La función principal que implementa QuickSort
                   arreglo[] --> Matriz a ordenar,
                   bajo --> Índice inicial,
                   alta --> índice final
    */
    public static int[] quickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto){
            // pi es índice de partición, arr[p]
            // ahora está en el lugar correcto
            int pi = particion(arreglo, bajo, alto);

            // ordenar por separado los elementos anteriores
            // partición y después de la partición
            quickSort(arreglo, bajo, pi - 1);
            quickSort(arreglo, pi + 1, alto);
        }

        return arreglo;
    }

    private static void imprimirNumOrdenados(int[] arreglo) {
        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int i=0;i< arreglo.length;i++){
            System.out.print(" - " + arreglo[i]);
        }
    }
}
