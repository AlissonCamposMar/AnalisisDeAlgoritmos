package MetodosOrdenamiento;

public class _12_MetodoBitonicSort {


    public static void BitonicSort(double arreglo[]){

        bitonicSort(arreglo, 0, arreglo.length, 1);
    }

    public static void bitonicSort(double[] arreglo, int low, int longitud, int up) {
        if (longitud > 1){
            int medio = longitud/2;

            // Ordenar la secuencia en orden ascendente o descendente
            bitonicSort(arreglo, low, medio, 1);
            bitonicSort(arreglo, low + medio, medio, 0);

            // Combinar las dos secuencias para formar una secuencia bitónica
            bitonicMerge(arreglo, low, longitud, up);
        }
    }

    public static void bitonicMerge(double[] arreglo, int low, int longitud, int up) {
        if (longitud > 1) {
            int medio = longitud / 2;
            for (int i = low; i < low + medio; i++) {
                compararIntercambiar(arreglo, i, i + medio, up);
            }
            bitonicMerge(arreglo, low, medio, up);
            bitonicMerge(arreglo, low + medio, medio, up);
        }
    }

    public static void compararIntercambiar(double[] arreglo, int i, int j, int up) {
        if ((arreglo[i] > arreglo[j] && up == 1) || (arreglo[i] < arreglo[j] && up == 0)){
            // Intercambiar los elementos
            double temp = arreglo[i];
            arreglo[i] = arreglo[j];
            arreglo[j] = temp;
        }
    }

}
