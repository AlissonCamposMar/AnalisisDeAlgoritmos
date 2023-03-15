package MetodosOrdenamiento;

public class _13_MetodoGnomeSort {

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
        for(int i= 0; i <arreglo.length;i++){
            arreglo[i] = (int) (Math.random()* arreglo.length);
        }
        gnomeSort(arreglo, arreglo.length);
    }

    private static void gnomeSort(int[] arreglo, int length) {

        int index = 0;

        while (index < length) {
            if (index == 0)
                index++;
            if (arreglo[index] >= arreglo[index - 1])
                index++;
            else {
                int temp = 0;
                temp = arreglo[index];
                arreglo[index] = arreglo[index - 1];
                arreglo[index - 1] = temp;
                index--;
            }
        }

        imprimirNumOrdenados(arreglo);
    }

    private static void imprimirNumOrdenados(int[] arreglo) {

        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int k=0;k< arreglo.length;k++){
            System.out.print(" - " + arreglo[k]);
        }

    }
}
