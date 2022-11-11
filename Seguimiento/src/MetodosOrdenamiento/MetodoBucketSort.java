package MetodosOrdenamiento;

import java.util.Collections;
import java.util.Vector;

public class MetodoBucketSort <T extends Number & Comparable<T>>{
    // Driver code
    public static void main(String[] args) {

        float arreglo[];
        int numElementos;
        long tiempoInicioEjecucion = System.nanoTime();

        //numElementos = 410000;
        numElementos = 2;
        //System.out.println("Hello world!");

        System.out.println("\nTamanio del arreglo es: " + numElementos + "\n");

        arreglo = new float[numElementos];

        ingresarNumeros(arreglo);

        long tiempoFinEjecucion = System.nanoTime();
        long totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        double segundos = (double) totalTiempoEjecucion/1000000000.0;

        System.out.println("\nTiempo de ejecución en segundos: " + segundos);
    }

    public static void ingresarNumeros(float arreglo[]){
        for(int i= 0; i<arreglo.length;i++){
            arreglo[i] = (float) (Math.random()* arreglo.length);
        }
        imprimirNumOrdenados(BucketSort(arreglo, arreglo.length));
    }

    private static float[] BucketSort(float[] arreglo, int tamArr) {
        if(tamArr <= 0)
            return arreglo;
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[tamArr];

        for (int i = 0 ; i < tamArr ; i++){
            buckets[i] = new Vector<Float>();
        }

        for (int i = 0; i < tamArr; i++) {
            float idx = arreglo[i] * tamArr;
            buckets[(int)idx].add(arreglo[i]);
        }

        for (int i = 0; i < tamArr; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < tamArr; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arreglo[index++] = buckets[i].get(j);
            }
        }

        imprimirNumOrdenados(arreglo);
        return arreglo;
    }

    private static void imprimirNumOrdenados(float[] arreglo) {

        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int i=0;i< arreglo.length;i++){
            System.out.print(" - " + arreglo[i]);
        }
    }
}
