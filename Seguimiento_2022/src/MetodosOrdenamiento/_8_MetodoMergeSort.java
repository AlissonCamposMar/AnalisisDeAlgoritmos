package MetodosOrdenamiento;

public class _8_MetodoMergeSort {

    public static void MergeSort(double[] arreglo){
        System.out.println("\nMétodo MergeSort\n");
        mergeSort(arreglo);
    }
    public static double[] mergeSort(double[] arreglo) {

        if (arreglo == null)
            return arreglo;

        if (arreglo.length > 1){
            int mid = arreglo.length/2;

            //Dividir la parte izquierda
            double[] left = new double[mid];
            for (int i = 0 ; i < mid ; i++){
                left[i] = arreglo[i];
            }

            //Dividir la parte derecha
            double[] right = new double[arreglo.length - mid];
            for (int i = mid ; i < arreglo.length ; i++){
                right[i - mid] = arreglo[i];
            }
            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Combinar matrices izquierda y derecha
            while(i < left.length && j < right.length) {
                if(left[i] < right[j]) {
                    arreglo[k] = left[i];
                    i++;
                }
                else {
                    arreglo[k] = right[j];
                    j++;
                }
                k++;
            }

            // Recoge los elementos restantes
            while(i < left.length) {
                arreglo[k] = left[i];
                i++;
                k++;
            }
            while(j < right.length) {
                arreglo[k] = right[j];
                j++;
                k++;
            }
        }
        return arreglo;

    }

}
