package parcialParte1;

import java.math.BigInteger;
import java.util.Arrays;

public class _9_RusaIEstatica {

    /*public static void main(String[] args){
        BigInteger arr1 = BigInteger.valueOf(9999999);
        BigInteger arr2 = BigInteger.valueOf(9999999);



        System.out.println();
        System.out.println(rusoEstatico(arr1, arr2));

    }
    private static BigInteger dos = new BigInteger("2");
    public static BigInteger rusoEstatico(BigInteger n, BigInteger m) {
        if (m.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        } else if (m.equals(BigInteger.ONE)) {
            return n;
        } else {
            if (m.remainder(dos).equals(BigInteger.ZERO)) {
                return rusoEstatico(n.multiply(dos), m.divide(dos));
            } else {
                return rusoEstatico(n.multiply(dos), m.divide(dos)).add(n);
            }
        }
    }*/

    public static void main(String[] args) {
        BigInteger[] arr1 = {BigInteger.valueOf(9999999)};
        BigInteger[] arr2 = {BigInteger.valueOf(9999999)};

        System.out.println();
        System.out.println(Arrays.toString(rusoEstatico(arr1, arr2)));
    }

    private static BigInteger dos = new BigInteger("2");

    public static BigInteger[] rusoEstatico(BigInteger[] n, BigInteger[] m) {
        if (m[0].equals(BigInteger.ZERO)) {
            return new BigInteger[]{BigInteger.ZERO};
        } else if (m[0].equals(BigInteger.ONE)) {
            return n;
        } else {
            if (m[0].remainder(dos).equals(BigInteger.ZERO)) {
                BigInteger[] result = rusoEstatico(doubleArray(n), divideArray(m));
                return result;
            } else {
                BigInteger[] result = rusoEstatico(doubleArray(n), divideArray(m));
                return addArrays(result, n);
            }
        }
    }

    private static BigInteger[] doubleArray(BigInteger[] arr) {
        BigInteger[] doubled = new BigInteger[arr.length];
        for (int i = 0; i < arr.length; i++) {
            doubled[i] = arr[i].multiply(dos);
        }
        return doubled;
    }

    private static BigInteger[] divideArray(BigInteger[] arr) {
        BigInteger[] divided = new BigInteger[arr.length];
        for (int i = 0; i < arr.length; i++) {
            divided[i] = arr[i].divide(dos);
        }
        return divided;
    }

    private static BigInteger[] addArrays(BigInteger[] arr1, BigInteger[] arr2) {
        BigInteger[] sum = new BigInteger[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            sum[i] = arr1[i].add(arr2[i]);
        }
        return sum;
    }


}
