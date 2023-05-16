package seguimiento.MetodosOrdenamiento;

import static seguimiento.MetodosOrdenamiento._11_MetodoHeapSort.HeapSort;
import static seguimiento.MetodosOrdenamiento._13_MetodoGnomeSort.GnomeSort;

public class Matriz {
    public static void main(String[] args) {

        calculoTiempoEjecucionMetodos();

    }

    public static void calculoTiempoEjecucionMetodos(){

        int tam = 11400;
        double[] arreglo = ingresarNumeros(tam);

        System.out.println("\nTamanio del arreglo es: " + tam + "\n");


        long tiempoInicioEjecucion, tiempoFinEjecucion, totalTiempoEjecucion;
        double segundos;

        //1 Metodo Burbuja
        tiempoInicioEjecucion = System.nanoTime();
        _1_MetodoBurbuja.Burbuja(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //2 Metodo BurbujaDobleDireccion
        tiempoInicioEjecucion = System.nanoTime();
        _2_MetodoBurbujaDobleDireccion.BurbujaDobleDireccion(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //3 Metodo PorSeleccion
        tiempoInicioEjecucion = System.nanoTime();
        _3_MetodoPorSeleccion.porSeleccion(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //4 Método porInseccion
        tiempoInicioEjecucion = System.nanoTime();
        _4_MetodoPorInsercion.porInsercion(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //5 Método InsertionSortRecursive
        tiempoInicioEjecucion = System.nanoTime();
        _5_MetodoRecursivoInsertionSort.InsertionSortRecursive(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //6 Método shellSort
        tiempoInicioEjecucion = System.nanoTime();
        _6_MetodoShellSort.shellSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //7 Método BucketSort
        tiempoInicioEjecucion = System.nanoTime();
        _7_MetodoBucketSort.BucketSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //8 Método MergeSort
        tiempoInicioEjecucion = System.nanoTime();
        _8_MetodoMergeSort.MergeSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //9 Método QuickSort
        tiempoInicioEjecucion = System.nanoTime();
        _9_MetodoQuickSort.QuickSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //10 Método StoogeSort
        tiempoInicioEjecucion = System.nanoTime();
        _10_MetodoStoogeSort.StoogeSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //11 Método HeapSort
        tiempoInicioEjecucion = System.nanoTime();
        HeapSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //12 Método BitonicSort
        tiempoInicioEjecucion = System.nanoTime();
        _12_MetodoBitonicSort.BitonicSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //13 Método GnomeSort
        tiempoInicioEjecucion = System.nanoTime();
        GnomeSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //14 Método BinaryInsertionSort
        tiempoInicioEjecucion = System.nanoTime();
        _14_MetodoBinaryInsertionSort.BinaryInsertionSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //15 Método StrandSort
        tiempoInicioEjecucion = System.nanoTime();
        _15_MetodoStrandSort.StrandSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //16 Método RadixSort
        tiempoInicioEjecucion = System.nanoTime();
        _16_RadixSort.RadixSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

    }

    /**
     * @return el arreglo con valores aleatorios
     */
    public static double[] ingresarNumeros(int tam){

        double[] arregloAux = new double[tam];
        for(int i= 0; i < tam;i++){
            arregloAux[i] = (int) (Math.random()* arregloAux.length);
        }
        return arregloAux;
    }

}
