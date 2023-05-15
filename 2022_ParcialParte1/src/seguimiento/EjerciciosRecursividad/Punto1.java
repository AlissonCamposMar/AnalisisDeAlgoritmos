package seguimiento.EjerciciosRecursividad;

import java.util.Scanner;

/**
 * Alisson Campos M 1005087645
 * Johan Andrey Ortiz 1094880380
 *
 * Punto1 del documento ejercicios recursivos
 */
public class Punto1 {

    /**
     * Un número perfecto es igual a la suma de sus divisores, exceptuando él mismo. Así, 6 es un
     * número perfecto porque sus divisores propios son 1, 2 y 3; y 6 = 1 + 2 + 3. Por ejemplo, los
     * divisores de 12 son: 1, 2, 3, 4, 6 y 12; sin embargo, para ver si el 12 es un número perfecto, no
     * hay que considerar al propio número, es decir, solo tenemos en cuenta los divisores propios de
     * 12: 1, 2, 3, 4 y 6, cuya suma es 16 y, por tanto, no es número perfecto. Escriba un algoritmo
     * recursivo que determine si un número es o no perfecto.
     */

    public static void main(String[] arg){
        int num;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un número");
        num = sc.nextInt();

        verificarNumPerfecto(num);

        System.out.println(verificarNumPerfecto(num));
    }

    public static String verificarNumPerfecto(int num) {
        int div = 1;
        int suma = sumarDivisores(num, div);
        String res = "";

        if (suma == num) {
            res = "Es un número perfecto";
        } else {
            res = "No es un número perfecto";
        }
        return res;
    }

    private static int sumarDivisores(int num, int div) {
        int res = 0;

        if (div > (num/2)){
            res = 0;
        } else {
            int aux = 0;
            if (num % div == 0){
                aux = div;
            }
            res = aux + sumarDivisores(num, div+1);
        }
        return res;
    }
}
