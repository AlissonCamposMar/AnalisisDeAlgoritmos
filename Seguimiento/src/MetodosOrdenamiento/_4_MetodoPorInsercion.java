package MetodosOrdenamiento;

public class _4_MetodoPorInsercion {

    public static void porInsercion( double arreglo[] ) {

        /*int i;
        double llave;
        System.out.println("\n\n Metodo por inserción\n");
        for ( int j = 1 ; j < arreglo.length ; j++ ) {
            llave = arreglo[ j ];
            i = j - 1;
            while( i >= 0 && arreglo[ i ] > llave ) {
                arreglo[i + 1] = arreglo[ i ];
                i--;
            }
            arreglo[i + 1] = llave;
        }
        System.out.println("\nArreglo ordenado\n");*/
        System.out.println("\n\n Metodo por inserción");
        int n = arreglo.length;
        for (int i = 1; i < n; ++i) {
            double key = arreglo[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arreglo[j] > key) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = key;
        }
    }
}
