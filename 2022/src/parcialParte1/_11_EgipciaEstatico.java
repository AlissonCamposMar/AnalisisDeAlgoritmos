package parcialParte1;

import java.math.BigInteger;

public class _11_EgipciaEstatico {


    public static void main(String[] args){
        BigInteger arr1 = BigInteger.valueOf(9999999);
        BigInteger arr2 = BigInteger.valueOf(9999999);



        System.out.println();


        System.out.println(multiplicacionEgipcia(arr1, arr2));

    }

    public static BigInteger multiplicacionEgipcia(BigInteger a, BigInteger b) {
        BigInteger result = BigInteger.ZERO;
        while (a.compareTo(BigInteger.ONE) >= 0) {
            if (a.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                result = result.add(b);
            }
            a = a.divide(BigInteger.valueOf(2));
            b = b.multiply(BigInteger.valueOf(2));
        }
        return result;
    }
}
