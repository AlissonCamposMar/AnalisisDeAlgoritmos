package parcialParte1;


public class _10_HinduIterativoEstatico {

    public static void main(String[] args){
        int [] arr1 = {9,9,9,9,9,9,9,9,9};
        int [] arr2 = {9,9,9,9,9,9,9,9,9};

        System.out.println("Arreglo multiplicando");
        for(int l: arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (int h : arr2)
            System.out.print(h + " ");
        System.out.println();

        multiplicarIndu(arr1, arr2);

    }


    private static int[] multiplicarIndu(int[] arr1, int[] arr2) {
        int []resultado = new int[arr1.length+ arr2.length];
        int k;
        int [] acarreo = new int[resultado.length];

        System.out.print("\n");

        //Recorre el arreglo multiplicador desde la última posición
        for (int i = arr2.length -1; i>=0; i--){

            //Verifica a qué tan lejos está del borde derecho del arreglo resultado
            k  = resultado.length - (arr2.length - i);
            //Recorre el arreglo multiplicando desde la última posición
            for (int j = arr1.length - 1; j >= 0; j--) {

                //Realiza la multiplicación y suma sobre el resultado anterior
                resultado[k] += arr1[j] * arr2[i];

                /**Condición que verifica si el resultado es igual o mayor a 10
                 * Para indicar que se acumula en el acarreo y que queda almacenado en la posicion [k]
                 * Ejem: 24/10 = 2--->acarreo(lo que se va a sumar en la siguiente multiplicación)
                 * 24%10 = 4 ---> resultado[k]
                 */
                if(resultado[k]>=10){
                    acarreo[k-1] += resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                } else {
                    acarreo[k-1] = 0;
                }

                k--;
            }
        }
        for (int i = resultado.length-1; i>=0; i--){
            resultado[i] += acarreo[i];
            if(resultado[i]>=10){
                acarreo[i-1] += resultado[i]/10;
                resultado[i] = resultado[i]%10;
            }
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



