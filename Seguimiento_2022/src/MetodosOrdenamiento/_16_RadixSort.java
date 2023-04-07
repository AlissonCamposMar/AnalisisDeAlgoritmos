package MetodosOrdenamiento;

public class _16_RadixSort {
    /**
     * Método que implementa el algoritmo Radix Sort para ordenar un arreglo de números dobles en orden ascendente.
     *
     * @param arreglo el arreglo de números dobles a ordenar
     */
    public static void RadixSort(double[] arreglo){

        System.out.println("Método RadixSort");

        if (arreglo.length <= 1) {
            return; // Caso base: el arreglo ya está ordenado
        }

        double maximo = getMaximo(arreglo); // Encontrar el máximo valor en el arreglo

        // Realizar el ordenamiento por cada dígito, desde el dígito menos significativo hasta el más significativo
        for (double exp = 1; maximo / exp > 0; exp *= 10) {
            countingSort(arreglo, exp); // Ordenar el arreglo utilizando Counting Sort con el dígito actual
        }
    }

    /**
     * Método auxiliar que encuentra el valor máximo en un arreglo de números dobles.
     *
     * @param arreglo el arreglo de números dobles
     * @return el valor máximo en el arreglo
     */
    private static double getMaximo(double[] arreglo) {
        double maximo = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > maximo) {
                maximo = arreglo[i];
            }
        }
        return maximo;
    }

    /**
     * Método auxiliar que implementa el algoritmo Counting Sort para ordenar un arreglo de números dobles
     * en función de un dígito específico en el rango [0, 9].
     *
     * @param arreglo el arreglo de números dobles a ordenar
     * @param exp el dígito por el cual ordenar el arreglo
     */
    private static void countingSort(double[] arreglo, double exp) {
        int[] contador = new int[10]; // Contador para cada dígito
        double[] resultado = new double[arreglo.length]; // Arreglo para el resultado final

        // Contar la frecuencia de cada dígito en el arreglo
        for (int i = 0; i < arreglo.length; i++) {
            int digito = (int) ((arreglo[i] / exp) % 10);
            contador[digito]++;
        }

        // Modificar el contador para que cada elemento represente la posición final del dígito correspondiente
        for (int i = 1; i < 10; i++) {
            contador[i] += contador[i - 1];
        }

        // Construir el arreglo ordenado por el dígito actual
        for (int i = arreglo.length - 1; i >= 0; i--) {
            int digito = (int) ((arreglo[i] / exp) % 10);
            resultado[contador[digito] - 1] = arreglo[i];
            contador[digito]--;
        }

        // Copiar el resultado al arreglo original
        System.arraycopy(resultado, 0, arreglo, 0, arreglo.length);
    }
}
