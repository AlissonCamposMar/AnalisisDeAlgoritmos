package MetodosOrdenamiento;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import static java.util.Objects.hash;

public class MetodoBucketSort <T extends Number & Comparable<T>>{
    static void bucketSort(float arr[], int n)
    {
        if (n <= 0)
            return;

        // 1) Create n empty buckets
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<Float>();
        }

        // 2) Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            float idx = arr[i] * n;
            buckets[(int)idx].add(arr[i]);
        }

        // 3) Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    // Driver code
    public static void main(String args[])
    {
        float arr[] = { (float)0.897, (float)0.565,
                (float)0.656, (float)0.1234,
                (float)0.665, (float)0.3434 };

        long tiempoInicioEjecucion = System.nanoTime();

        System.out.println("La matriz sin ordenar es ");
        for (float el : arr) {
            System.out.print(el + " ");
        }

        int n = arr.length;
        bucketSort(arr, n);

        System.out.println("\nLa matriz ordenada es ");
        for (float el : arr) {
            System.out.print(el + " ");
        }

        long tiempoFinEjecucion = System.nanoTime();
        long totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        double segundos = (double) totalTiempoEjecucion/1000000000.0;

        System.out.println("\nTiempo de ejecución en segundos: " + segundos);
    }
}
