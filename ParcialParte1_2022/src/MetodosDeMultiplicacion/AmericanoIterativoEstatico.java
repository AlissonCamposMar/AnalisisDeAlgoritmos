package MetodosDeMultiplicacion;

public class AmericanoIterativoEstatico {

    public static void main(String[] args){
        int [] arr1 = {9,9,9,9,9,9,9};
        int [] arr2 = {9,9,9,9,9,9};


        System.out.println("Arreglo multiplicando");
        for(int l: arr1)
            System.out.print(l + " ");

        System.out.println("\nArreglo multiplicador");
        for (int h : arr2)
            System.out.print(h + " ");
        System.out.println();

        //multiplicarAmericano(arr1, arr2);
        //multiplicarArreglosAmericano(arr1, arr2);
        //multiplicarAmericanoArrayList(arr1, arr2);

    }
}
