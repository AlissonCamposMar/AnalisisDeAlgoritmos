package punto4_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class numPolidivisible {

        /**
         * @param n
         * Método que comprueba si un número es polidivisible
         */
        public static boolean isPolyDivisible(int n) {
            String x = Integer.toString(n); //el valor recibido por parámetro se convierte a String y se almacena en la variable x...
            int divisor = x.length();       //...el tamaño del string se almacena en la variable int divisor que servirá como contador...
                                            //....para ir desde el último dígito hasta el primero

            while (n > 0) { // Mientras queden dígitos por comprobar...
                if (n % divisor != 0) {// Si el dígito actual no es divisible por su posición...
                    return false; // ...el número no es polidivisible, devolvemos false.
                }
                n /= 10; // Pasamos al siguiente dígito dividiendo n entre 10.
                divisor--; //Decrementa el contador para el siguiente dígito
            }
            return true; //sí todo lo anterior fue exitoso entonces retornara true
        }

        // Método para encontrar números polidivisibles en una matriz
        public static int[] findPolyDivisibleNumbers(int[][] matrix) {
            List<Integer> resultList = new ArrayList<>();
            for (int[] row : matrix) {
                for (int num : row) {
                    if (num > 0 && isPolyDivisible(num)) { // Agregamos una condición adicional para excluir el cero y números negativos
                        resultList.add(num);
                    }
                }
            }
            int[] resultArray = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                resultArray[i] = resultList.get(i);
            }
            return resultArray;
        }

        // Ejemplo de uso
        public static void main(String[] args) {
            int[][] matrix = {{123, 24, 36}, {80, 42, 63}, {2016}};
            int[] polyDivisibleNumbers = findPolyDivisibleNumbers(matrix);
            System.out.println(Arrays.toString(polyDivisibleNumbers));
        }

}
