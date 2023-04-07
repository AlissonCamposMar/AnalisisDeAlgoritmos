package MetodosOrdenamiento;

public class _3_MetodoPorSeleccion {

    public static void porSeleccion(double[] arreglo) {
        int i, j, k;
        double menor;
        i = 0;

        System.out.println("\n\nMétodo por selección\n");

        while( i < arreglo.length - 1) {
            menor = arreglo [i];
            k = i;
            for( j = i+1; j < arreglo.length; j++) {
                if (arreglo [j] < menor ) {
                    menor = arreglo [j];
                    k = j;
                }
            }
            arreglo [k] = arreglo[i];
            arreglo [i] = menor;
            i++;
        }
        System.out.println("\nArreglo ordenado\n");
    }
}
