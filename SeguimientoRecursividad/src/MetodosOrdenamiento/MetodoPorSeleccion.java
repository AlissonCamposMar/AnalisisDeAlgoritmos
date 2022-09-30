package MetodosOrdenamiento;

public class MetodoPorSeleccion {
    public static void main(String[] args) {

        int arreglo[];
        int numElementos;
        long tiempoInicioEjecucion = System.nanoTime();

        numElementos = 300000;
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
        seleccion(arreglo);
    }

    private static void seleccion(int[] arreglo) {
        int i, j, k, menor;
        i = 0;
        while( i < arreglo.length - 1) {
            menor = arreglo [i];
            k = i;
            for( j = i+1; j < arreglo.length; j++) {
                if (arreglo [j] < menor ) {

                    menor = arreglo [j];
                    k = j;
                }
            }
            arreglo [k] = arreglo[i];
            arreglo [i] = menor;
            i++;
        }
        imprimirNumOrdenados(arreglo);
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
