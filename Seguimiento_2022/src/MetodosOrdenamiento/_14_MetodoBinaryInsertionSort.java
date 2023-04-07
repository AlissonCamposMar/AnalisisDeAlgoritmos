package MetodosOrdenamiento;

public class _14_MetodoBinaryInsertionSort {
    public static void BinaryInsertionSort(double[] arreglo) {
        int tam = arreglo.length;
        System.out.println("Método BinaryInsertionSort");
        insertionSort(arreglo, tam);
    }

    static void insertionSort(double[] arreglo, int n) {
        int i, loc, j, k;
        double selected;

        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = arreglo[i];

            // find location where selected should be inserted
            loc = binarySearch(arreglo, selected, 0, j);

            // Move all elements after location to create space
            while (j >= loc) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = selected;
        }
    }

    static int binarySearch(double[] arreglo, double selected, int low, int j) {
        while (low <= j) {
            int mid = low + (j - low) / 2;
            if (j == arreglo[mid])
                return mid + 1;
            else if (selected > arreglo[mid])
                low = mid + 1;
            else
                j = mid - 1;
        }

        return low;
    }
}
