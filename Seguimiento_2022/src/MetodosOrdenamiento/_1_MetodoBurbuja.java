package MetodosOrdenamiento;

public class _1_MetodoBurbuja {

    /**
     *
     * @param arreglo
     */
    public static void Burbuja(double arreglo[]) {
        double aux; // Variable temporal para almacenar el valor actual de
                 // un elemento durante el intercambio
        int tam = arreglo.length; // Longitud de la matriz
        /**
         * Ordenado de forma creciente
         */
        System.out.println("\n\nMétodo burbuja\n");

        for( int j = 1 ; j < tam ; j++) {
            for( int i = 0 ; i < tam - 1 ; i++) {
                if ( arreglo[ i ] > arreglo[i+1] ) {
                    aux = arreglo[ i ];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i+1] = aux;
                }
            }
        }
        System.out.println("\nArreglo ordenado\n");
    }

}
