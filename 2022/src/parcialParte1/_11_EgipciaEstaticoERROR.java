package parcialParte1;

public class _11_EgipciaEstaticoERROR {


    public static void main(String[] args){
        int arr1 = 9999999;
        int arr2 = 9999999;



        System.out.println();


        System.out.println(multiplicacionEgipcia(arr1, arr2));

    }

    public static int multiplicacionEgipcia(int num1, int num2) {
        int producto = 0;

        while (num1 >= 1) {
            if (num1 % 2 == 1) {
                producto += num2;
            }
            num1 = num1 / 2;
            num2 = num2 * 2;
        }

        return producto;
    }
}
