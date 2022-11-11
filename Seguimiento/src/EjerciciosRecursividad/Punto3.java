package EjerciciosRecursividad;

import java.util.Scanner;

public class Punto3 {
    /**
     * Determinar si un número entero positivo es primo o no lo es.
     */

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int numero = sc.nextInt();
        System.out.printf("%nEl numero %d ", numero);
        System.out.print(numeroPrimo(numero, 2)?"es un número primo.":"no es un número primo.");


    }
    private static boolean numeroPrimo(int num, int divisor){
        if(num/2 < divisor){
            return true;
        } else {
            if(num%divisor==0){
                return false;
            } else {
                return numeroPrimo(num, divisor+1);
            }
        }
    }
}
