package parcialParte1;

public class InglesIterativoEstatico {

    public static void main(String[] args){
        int [] arr1 = {9,9,9,9,9,9,9,9,9};
        int [] arr2 = {9,9,9,9,9,9,9};


        System.out.println("Arreglo multiplicando");
        for(int l: arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (int h : arr2)
            System.out.print(h + " ");
        System.out.println();

        multiplicaInglesa(arr1, arr2);

    }

    public static int[] multiplicaInglesa (int[] arreglo1, int[] arreglo2) {

        int tam = arreglo1.length + arreglo2.length;
        int[] resultado = new int [tam];

        for (int i=0; i< arreglo2.length; i++) {
            for(int j=0; j< arreglo1.length; j++)
            {
                resultado[i+j+1]+= arreglo1[j]* arreglo2[i];

            }

        }
        for (int k=tam-1; k>0; k--) {

            resultado[k-1]+= resultado[k]/10;
            resultado [k]%=10;

        }

        imprimirResultado(resultado);
        return resultado;

    }

    private static void imprimirResultado(int[] resultado) {
        System.out.println("Resultado");
        for (int i = 0; i< resultado.length; i++){
            System.out.print(resultado[i] + " ");
        }
    }
}
