package MetodosOrdenamiento;

public class MetodoBurbujaDobleDireccion {
    public static void main(String[] args) {

        int arreglo[];
        int numElementos;
        long tiempoInicioEjecucion = System.nanoTime();

        numElementos = 150000;
        //numElementos = (int) (Math.random()*150000);
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
        shakerSort(arreglo);
    }

    public static void shakerSort( int x[ ] ) {
        int aux, primero = 1, ultimo = x.length - 1, dir = x.length - 1;
        while ( ultimo >= primero ) {
            for( int i = ultimo ; i >= primero ; i--) {
                if ( x [i - 1] > x[ i ] ) {
                    aux = x[i - 1];
                    x[i - 1] = x[ i ];
                    x[ i ] = aux;
                    dir = i;
                }
            }
            primero = dir + 1;
            for( int i = primero ; i <= ultimo; i++ ) {
                if ( x [i - 1] > x[ i ] ) {
                    aux = x[i - 1];
                    x[i - 1] = x[ i ];
                    x[ i ] = aux;
                    dir = i;
                }
            }
            ultimo = dir - 1;
        }
        imprimirNumOrdenados(x);
    }

    private static void imprimirNumOrdenados(int[] arreglo) {

        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int i=0;i< arreglo.length;i++){
            System.out.print(" - " + arreglo[i]);
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
