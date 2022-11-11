package MetodosOrdenamiento;

public class MetodoSellShort {
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
        shellSort(arreglo);
    }

    public static void shellSort(int a[]) {
        for (int incr = a.length/2; incr>0; incr/= 2 ) {
            for (int i = incr ; i < a.length ; i++ ) {
                int j = i - incr;
                while (j >= 0) {
                    if (a[j] > a[j + incr]) {
                        int T = a[ j ];
                        a[ j ] = a[j+incr];
                        a[j+incr] = T;
                        j -= incr;
                    } else {
                        j = -1;
                    }
                }
            }
        }
        imprimirNumOrdenados(a);
    }

    private static void imprimirNumOrdenados(int[] arreglo) {

        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int i=0;i< arreglo.length;i++){
            System.out.print(" - " + arreglo[i]);
        }
    }
}
