package MetodosOrdenamiento;

public class _1_MetodoBurbuja {
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
        System.out.println("\nArreglo\n");
        imprimirNum(arreglo);
        burbuja(arreglo);
    }

    /**
     *
     * @param arreglo
     */
    public static void burbuja(int arreglo[]) {
        int aux;
        int tam = arreglo.length;
        /**
         * Ordenado de forma creciente
         */
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
        imprimirNum(arreglo);
    }

    private static void imprimirNum(int[] arreglo) {

        for(int k=0;k< arreglo.length;k++){
            System.out.print(" - " + arreglo[k]);
        }

    }

}
