package MetodosOrdenamiento;

public class MetodoMergeSort {
    public static void main(String[] args) {

        int arreglo[];
        int numElementos;
        long tiempoInicioEjecucion = System.nanoTime();

        numElementos = 10;
        //System.out.println("Hello world!");

        System.out.println("\nTamanio del arreglo es: " + numElementos + "\n");

        arreglo = new int[numElementos];

        ingresarNumeros(arreglo, numElementos);

        long tiempoFinEjecucion = System.nanoTime();
        long totalTiempoEjecucion = tiempoFinEjecucion - tiempoInicioEjecucion;
        double segundos = (double) totalTiempoEjecucion/1000000000.0;

        System.out.println("\nTiempo de ejecución en segundos: " + segundos);
    }

    public static void ingresarNumeros(int arreglo[], int numElementos){
        for(int i= 0; i<numElementos;i++){
            arreglo[i] = (int) (Math.random()*numElementos);
        }
        int n = arreglo.length;
        sort(arreglo,0,n-1);
    }

    public static void sort (int[] arreglo, int izq, int der){
        //Encuentra el punto medio del vector.
        if (izq < der){
            int m  = (izq + der)/2;

            //Divide la primera y segunda mitad (llamada recursiva).
            sort(arreglo, izq, m);
            sort(arreglo, m+1, der);

            //Une las mitades.
            merge(arreglo, izq, m, der);
        }

    }

    private static void merge(int[] arreglo, int izq, int m, int der) {
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = m - izq + 1;
        int n2 = der - m;

        //Vectores temporales
        int izqArray[] = new int[n1];
        int derArrray [] = new int[n2];

        //Copia los datos a los arrays temporales.
        for (int i = 0; i < n1; i++){
            izqArray[i] = arreglo[izq+i];
        }
        for (int j = 0; j<n2; j++){
            derArrray[j] = arreglo[m+j+1];
        }
        /**
         * Une los vectorestemporales.
         */

        //Indices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;

        //Indice inicial del sub-vector arreglo[].
        int k = izq;

        //Ordenamiento.
        while (i < n1 && j < n2){
            if(izqArray[i] <= derArrray[j]){
                arreglo[k] = izqArray[i];
                i++;
            } else {
                arreglo[k] = derArrray[j];
                j++;
            }
            k++;
        }//fin del while.

        /**
         * Si quedan elementos por ordenar
         */
        //Copiar los elementos restantes de izqArray[]
        while (i < n1){
            arreglo[k] = izqArray[i];
            i++;
            k++;
        }

        //Copia los elementos restantes de derArray[].
        while (i < n2){
            arreglo[k] = derArrray[j];
            j++;
            k++;
        }
        imprimirNumOrdenados(arreglo);
    }

    private static void imprimirNumOrdenados(int[] arreglo) {

        System.out.println("\nArreglo ordenado de forma creciente\n");
        for(int k=0;k< arreglo.length;k++){
            System.out.print(" - " + arreglo[k]);
        }

        /**
         * Ordenado de forma decreciente
         */
        System.out.println("\nArreglo ordenado de forma decreciente\n");
        for( int j = arreglo.length-1 ; j >= 0 ; j--) {
            System.out.print(" - " + arreglo[j]);
        }
    }
}
