package MetodosOrdenamiento;

public class _11_MetodoHeapSort {

    public static void HeapSort(double arreglo[]){

        System.out.println("Método HeapSort");

        // 1. Construye un gran montón superior
        for(int i=arreglo.length/2-1;i>=0;i--){
            // Ajusta la estructura desde el primer nodo no hoja de abajo hacia arriba y de derecha a izquierda
            adjustHeap(arreglo,i,arreglo.length);
        }
        // 2. Ajusta la estructura del montón + intercambia los elementos superiores y finales del montón
        for(int j=arreglo.length-1;j>0;j--){
            swap (arreglo, 0, j); // Intercambia el elemento superior y el elemento final
            adjustHeap (arreglo, 0, j); // Reajustar el montón

        }
    }

    /**
     * Ajuste de la pila superior grande (solo el proceso de ajuste, construido sobre la base de la pila superior grande)
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(double[] arr,int i,int length){
        double temp = arr [i]; // Eliminar primero el elemento actual i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {// comenzando desde el hijo izquierdo de i, es decir, comenzando en 2i + 1
            if (k + 1 <length && arr [k] <arr [k + 1]) {// Si el niño izquierdo es más pequeño que el derecho, k apunta al niño derecho
                k++;
            }
            if (arr [k]> temp) {// Si el nodo hijo es más grande que el nodo padre, asigne el valor del nodo hijo al nodo padre (sin intercambio)
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr [i] = temp; // coloca el valor temporal en la posición final
    }

    public static void swap(double[] arr,int a ,int b){
        double temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
