package MetodosOrdenamiento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class _7_MetodoBucketSort<T extends Number & Comparable<T>>{

    public static void BucketSort(double[] arreglo) {

        System.out.println("\nMétodo shellSort\n");

        if (arreglo == null || arreglo.length <= 1) {
            return;
        }

        // Encontrar el valor máximo del arreglo
        double maxValor = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > maxValor) {
                maxValor = arreglo[i];
            }
        }

        // Crear los buckets y distribuir los elementos en ellos
        int numBuckets = arreglo.length;
        List<Double>[] buckets = new List[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<Double>();
        }

        for (int i = 0; i < arreglo.length; i++) {
            int bucketIndex = (int) ((arreglo[i] / maxValor) * (numBuckets - 1));
            buckets[bucketIndex].add(arreglo[i]);
        }

        // Ordenar los buckets y combinar los elementos en el arreglo original
        int index = 0;
        for (int i = 0; i < numBuckets; i++) {
            List<Double> bucket = buckets[i];
            Collections.sort(bucket);
            for (double elemento : bucket) {
                arreglo[index++] = elemento;
            }
        }
    }
}
