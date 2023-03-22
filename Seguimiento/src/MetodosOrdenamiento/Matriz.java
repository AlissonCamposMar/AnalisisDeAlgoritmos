package MetodosOrdenamiento;

import static MetodosOrdenamiento._10_MetodoStoogeSort.StoogeSort;
import static MetodosOrdenamiento._10_MetodoStoogeSort.stoogeSort;
import static MetodosOrdenamiento._11_MetodoHeapSort.HeapSort;
import static MetodosOrdenamiento._12_MetodoBitonicSort.*;
import static MetodosOrdenamiento._13_MetodoGnomeSort.GnomeSort;
import static MetodosOrdenamiento._14_MetodoBinaryInsertionSort.BinaryInsertionSort;
import static MetodosOrdenamiento._15_MetodoStrandSort.StrandSort;
import static MetodosOrdenamiento._16_RadixSort.RadixSort;
import static MetodosOrdenamiento._1_MetodoBurbuja.Burbuja;
import static MetodosOrdenamiento._2_MetodoBurbujaDobleDireccion.BurbujaDobleDireccion;
import static MetodosOrdenamiento._3_MetodoPorSeleccion.porSeleccion;
import static MetodosOrdenamiento._4_MetodoPorInsercion.porInsercion;
import static MetodosOrdenamiento._5_MetodoRecursivoInsertionSort.InsertionSortRecursive;
import static MetodosOrdenamiento._6_MetodoShellSort.shellSort;
import static MetodosOrdenamiento._7_MetodoBucketSort.BucketSort;
import static MetodosOrdenamiento._8_MetodoMergeSort.MergeSort;
import static MetodosOrdenamiento._9_MetodoQuickSort.QuickSort;

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
        Burbuja(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //2 Metodo BurbujaDobleDireccion
        tiempoInicioEjecucion = System.nanoTime();
        BurbujaDobleDireccion(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //3 Metodo PorSeleccion
        tiempoInicioEjecucion = System.nanoTime();
        porSeleccion(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //4 Método porInseccion
        tiempoInicioEjecucion = System.nanoTime();
        porInsercion(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //5 Método InsertionSortRecursive
        tiempoInicioEjecucion = System.nanoTime();
        InsertionSortRecursive(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //6 Método shellSort
        tiempoInicioEjecucion = System.nanoTime();
        shellSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //7 Método BucketSort
        tiempoInicioEjecucion = System.nanoTime();
        BucketSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //8 Método MergeSort
        tiempoInicioEjecucion = System.nanoTime();
        MergeSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //9 Método QuickSort
        tiempoInicioEjecucion = System.nanoTime();
        QuickSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //10 Método StoogeSort
        tiempoInicioEjecucion = System.nanoTime();
        StoogeSort(arreglo);
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
        BitonicSort(arreglo);
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
        BinaryInsertionSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //15 Método StrandSort
        tiempoInicioEjecucion = System.nanoTime();
        StrandSort(arreglo);
        tiempoFinEjecucion = System.nanoTime();
        totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        segundos = (double) totalTiempoEjecucion/1000000000.0;
        System.out.println("\nTiempo de ejecución en segundos: " + segundos);

        //16 Método RadixSort
        tiempoInicioEjecucion = System.nanoTime();
        RadixSort(arreglo);
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
