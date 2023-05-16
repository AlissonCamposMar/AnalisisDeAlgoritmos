package seguimiento.programacionDinamica;

public class sucesionDeLucas {

    public static void main(String[] args){
        int n = 10;
        int [] arreglo = new int[11];
        sucesionLucas(n,arreglo);
    }

    public static int sucesionLucas(int n, int[] arreglo){
        if(n == 0){
            arreglo[n] = 2;
            return arreglo[n];
        } else if (n == 1){
            arreglo[n] = 1;
            return arreglo[n];
        } else if (n > 1){
            arreglo[n] = sucesionLucas(n-1, arreglo) + sucesionLucas(n-2, arreglo);
            return arreglo[n];
        }
        return arreglo[n];
    }
}
