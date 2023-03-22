package MetodosOrdenamiento;

public class _9_MetodoQuickSort {

    // Una función de utilidad para intercambiar dos elementos
    static void swap(double[] arreglo, int i, int j) {
        double temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    /* Esta función toma el último elemento como pivote, coloca
        el elemento de pivote en su posición correcta en ordenado
        matriz, y coloca todos los más pequeños (más pequeños que el pivote)
        a la izquierda del pivote y todos los elementos mayores a la derecha
        de pivote */
    private static int particion(double[] arreglo, int bajo, int alto){

        //pivote
        double pivot = arreglo[alto];

        // Índice del elemento más pequeño y
        // indica la posición correcta
        // del pivote encontrado hasta ahora
        int pivotIndex = bajo - 1;

        for (int i = bajo; i < alto; i++) {

            // Si el elemento actual es más pequeño
            // que el pivote
            if (arreglo[i] < pivot) {

                // Incremento índice de
                // elemento más pequeño
                pivotIndex++;
                swap(arreglo, i, pivotIndex);
            }
        }

        pivotIndex++;
        swap(arreglo, pivotIndex, alto);

        return pivotIndex;
    }


    /* La función principal que implementa QuickSort
                   arreglo[] --> Matriz a ordenar,
                   bajo --> Índice inicial,
                   alta --> índice final
    */
    public static void quickSort(double[] arreglo, int bajo, int alto) {
        if (bajo < alto){
            // pi es índice de partición, arr[p]
            // ahora está en el lugar correcto
            int pivote = particion(arreglo, bajo, alto);

            // ordenar por separado los elementos anteriores
            // partición y después de la partición
            quickSort(arreglo, bajo, pivote - 1);
            quickSort(arreglo, pivote + 1, alto);
        }
    }

    public static void QuickSort(double[] arreglo){
        System.out.println("Método Quicksort");
        quickSort(arreglo,0, arreglo.length-1);
    }
}
