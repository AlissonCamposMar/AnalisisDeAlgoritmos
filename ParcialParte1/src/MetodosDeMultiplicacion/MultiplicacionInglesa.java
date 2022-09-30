package MetodosDeMultiplicacion;

public class MultiplicacionInglesa {
    public static void main(String[] args){
        int [] arr1 = {1,5,3,0,1};
        int [] arr2 = {1,3,5,6,0};
        int []resultado = new int[arr1.length+ arr2.length];
        int acarreo = 0;
        int i= 0;
        int j= arr1.length-1;
        int k = arr2.length + i;

        System.out.println("Arreglo multiplicando");
        for(int l: arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (int h : arr2)
            System.out.print(h + " ");
        System.out.println();

        //multiplicarIngles(arr1, arr2);
        multiplicacionInglesRecursivo(arr1, arr2,resultado, acarreo, i,j,k);
        imprimirResultado(resultado);
    }

    private static void imprimirResultado(int[] resultado) {
        System.out.println("Resultado");
        for (int i = 0; i< resultado.length; i++){
            System.out.print(resultado[i] + " ");
        }
    }

    private static void multiplicarIngles(int[] arr1, int[] arr2) {

        int[] resultado = new int[arr1.length+ arr2.length];
        int k = 0;
        int acarreo = 0;

        System.out.print("\n");


        //Recorre el arreglo multiplicador desde la primera posición
        for (int i = 0; i<arr2.length; i++){
            k  = arr2.length + i;
            for (int j = arr1.length-1; j>=0; j--){

                resultado[k] += arr1[j] * arr2[i] + acarreo;

                if(resultado[k]>=10){
                    acarreo = resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                } else {
                    acarreo = 0;
                }
                k--;
            }
            if(acarreo != 0){
                resultado[k] += acarreo;
                if(resultado[k]>=10){
                    acarreo = resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                    resultado[k - 1] += acarreo;
                }
                acarreo = 0;
            }

        }
        System.out.println("Pruebas de lectura de los arreglos desde la ultima posición hasta la primera");
        for (int i = 0; i< resultado.length; i++){
            System.out.print(resultado[i] + " ");
        }
    }

    private static int[] multiplicacionInglesRecursivo(int[] arr1, int[] arr2, int[] resultado, int acarreo, int i, int j, int k) {
        int h= arr2.length - 1;

        if(i==h && j==0){
            resultado[k] += arr1[j] * arr2[i] + acarreo;

            if(resultado[k]>=10){
                acarreo = resultado[k]/10;
                resultado[k] = resultado[k]%10;
            } else {
                acarreo = 0;
            }
            k--;
            if(acarreo != 0){
                resultado[k] += acarreo;
                if(resultado[k]>=10){
                    acarreo = resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                    resultado[k - 1] += acarreo;
                }
                acarreo = 0;
            }
            //resultado[k]=acarreo;
            //System.out.println(arr1[j] + "," + arr2[i]);
            return resultado;

        } else if (j==0) {
            //System.out.println(arr1[j] + "," + arr2[i]);
            //Está en la posición j=0 e i= cualquier valor del arr1 (For anidado)
            resultado[k] += arr1[j] * arr2[i] + acarreo;
            if(resultado[k]>=10){
                acarreo = resultado[k]/10;
                resultado[k] = resultado[k]%10;
            } else {
                acarreo = 0;
            }
            k--;

            //resultado[k] = acarreo;
            if(acarreo != 0){
                resultado[k] += acarreo;
                if(resultado[k]>=10){
                    acarreo = resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                    resultado[k - 1] += acarreo;
                }
                acarreo = 0;
            }
            i++;
            j = arr1.length - 1;
            k  = arr2.length + i;
            multiplicacionInglesRecursivo(arr1,arr2,resultado,acarreo,i,j,k);

        } else {
            //System.out.println(arr1[j] + "," + arr2[i]);

            resultado[k] += arr1[j] * arr2[i] + acarreo;
            if(resultado[k]>=10){
                acarreo = resultado[k]/10;
                resultado[k] = resultado[k]%10;
            } else {
                acarreo = 0;
            }
            k--;
            j--;
            multiplicacionInglesRecursivo(arr1,arr2,resultado,acarreo,i,j,k);
        }
        return resultado;
    }

}


