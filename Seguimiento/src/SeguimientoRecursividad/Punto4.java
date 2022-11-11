package SeguimientoRecursividad;

import java.util.ArrayList;

public class Punto4 {

    public static void main(String[] args) {

        String matriz[][]= { { "2016", "4233", "201" },
                { "20", "4233", "0" }};


        ArrayList<String> arr= new ArrayList<>();
        arr=polidivisible(matriz,0, 0,arr);

        for(int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
    private static ArrayList<String> polidivisible(String[][] matriz, int i, int j, ArrayList<String> arr) {

        if(i>=matriz.length) {
            return arr;
        }
        if(j>=matriz[0].length) {

            return polidivisible(matriz, i+1, 0, arr);
        }

        if(i<matriz.length) {
            String n=matriz[i][j];

            if(esPolidivisible(n,0,false)) {
                arr.add(n);
                return polidivisible(matriz, i, j+1, arr);
            }else {
                return polidivisible(matriz, i, j+1, arr);
            }

        }
        return arr;
    }

    public static boolean esPolidivisible(String numeroCadena,int i, boolean centinela) {

        if(i>=numeroCadena.length()) {

            return centinela;
        }else {

            String temp=numeroCadena.substring(0, i+1);
            int numero=Integer.parseInt(temp);

            if(numero!=0  && numero%temp.length()==0) {
                centinela = true;
                return esPolidivisible(numeroCadena, i+1, centinela);
            }else {
                centinela= false;
                return centinela;
            }
        }
    }
}
