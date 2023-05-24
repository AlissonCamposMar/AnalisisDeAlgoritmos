package parcialParte1;

import java.math.BigInteger;

public class _11_EgipciaEstatico {


    public static void main(String[] args){
        BigInteger[] arr1 = {BigInteger.valueOf(9999999)};
        BigInteger[] arr2 = {BigInteger.valueOf(9999999)};



        System.out.println();


        System.out.println(multiplicacionEgipcia(arr1, arr2));

    }

    public static BigInteger multiplicacionEgipcia(BigInteger[] a, BigInteger[] b) {
        BigInteger result = BigInteger.ZERO;
        while (a[0].compareTo(BigInteger.ONE) >= 0) {
            if (a[0].mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                result = result.add(b[0]);
            }
            a[0] = a[0].divide(BigInteger.valueOf(2));
            b[0] = b[0].multiply(BigInteger.valueOf(2));
        }
        return result;
    }
}
