package seguimiento.relacionDeRecurrencia.programacionDinamica.taller;

public class punto1 {

    public static void main(String[] args){
        int n = 10;
        int [] arreglo = new int[11];
        System.out.println(sumatoria(n,arreglo));
    }

    public static int sumatoria(int n, int[] arreglo){
        if(n == 0){
            arreglo[n] = 3;
            return arreglo[n];
        } else if (n == 1){
            arreglo[n] = 2;
            return arreglo[n];
        } else if (n > 1){
            arreglo[n] = sumatoria(n-1, arreglo) + sumatoria(n-2, arreglo);
            return arreglo[n];
        }
        return arreglo[n];
    }
}
