package parcialParte1;

import java.math.BigInteger;

public class _9_RusaIEstatica {

    public static void main(String[] args){
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
    }

}
