package MetodosOrdenamiento;

public class _13_MetodoGnomeSort {
    public static void GnomeSort(double[] arreglo) {
        System.out.println("\nMetodo GnomeSort");

        int index = 0;// Posición de inicio

        while (index < arreglo.length) {
            if (index == 0)
                index++;
            if (arreglo[index] >= arreglo[index - 1])
                index++;
            else {
                double temp = 0;
                temp = arreglo[index];
                arreglo[index] = arreglo[index - 1];
                arreglo[index - 1] = temp;
                index--;
            }
        }
    }

}
