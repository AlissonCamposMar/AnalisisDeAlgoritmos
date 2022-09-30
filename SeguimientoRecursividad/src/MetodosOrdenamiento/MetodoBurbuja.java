package MetodosOrdenamiento;

public class MetodoBurbuja {
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
        burbuja(arreglo);
    }

    /**
     *
     * @param arreglo
     */
    public static void burbuja(int arreglo[]) {

        int aux;
        /**
         * Ordenado de forma creciente
         */
        for( int j = 1 ; j < arreglo.length ; j++) {
            for( int i = 0 ; i<arreglo.length-1 ; i++) {
                if ( arreglo[ i ] > arreglo[i+1] ) {
                    aux = arreglo[ i ];
                    arreglo[i] = arreglo[i + 1];
                    arreglo[i+1] = aux;

                }
            }
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
