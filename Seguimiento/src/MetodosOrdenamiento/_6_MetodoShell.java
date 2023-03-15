package MetodosOrdenamiento;

public class _6_MetodoShell {
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
        imprimirNumOrdenados(arreglo);
        shell(arreglo);
    }

    public static void shell(int a[]) {
        int salto, aux, i;
        boolean cambios;

        for (salto = a.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {   // Mientras se intercambie algún elemento
                cambios = false;
                for (i = salto; i < a.length; i++)   // se da una pasada
                {
                    if (a[i - salto] > a[i]) {       // y si están desordenados
                        aux = a[i];                  // se reordenan
                        a[i] = a[i - salto];
                        a[i - salto] = aux;
                        cambios = true;              // y se marca como cambio.
                    }
                }
            }
        }
        System.out.println("\nArreglo ordenado de forma creciente\n");
        imprimirNumOrdenados(a);
    }

    private static void imprimirNumOrdenados(int[] arreglo) {

        for(int i=0;i< arreglo.length;i++){
            System.out.print(" - " + arreglo[i]);
        }
    }
}
