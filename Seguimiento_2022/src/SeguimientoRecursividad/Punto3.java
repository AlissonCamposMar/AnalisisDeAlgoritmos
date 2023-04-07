package SeguimientoRecursividad;

import java.util.Scanner;

public class Punto3 {
    public static void main(String[] args) {

        System.out.println("Ingrese dimensión de la matriz: ");
        Scanner dato = new Scanner (System.in);
        String m= dato.next();
        int n= Integer.parseInt(m);

        int matriz [][]= new int [n][n];
        int i=0,j=0;
        //System.out.println(n);
        int matriz2[][]=dibujarMatriz(matriz, i, j);
    }
    private static int[][] dibujarMatriz(int[][] matriz, int i, int j) {

        if(i>=matriz.length) {
            return matriz;
        }
        if(j>=matriz[0].length) {
            j=0;
        }
        return matriz;
    }
}
