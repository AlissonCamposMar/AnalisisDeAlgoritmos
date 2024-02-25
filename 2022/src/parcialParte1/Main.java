package parcialParte1;

import java.math.BigInteger;
import java.util.Random;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger[] array = {BigInteger.valueOf(123), BigInteger.valueOf(456), BigInteger.valueOf(789)};
        BigInteger result = convertArrayToBigInteger(array);
        System.out.println(result);
    }

    public static BigInteger convertArrayToBigInteger(BigInteger[] array) {
        StringBuilder sb = new StringBuilder();

        for (BigInteger num : array) {
            sb.append(num.toString());
        }

        return new BigInteger(sb.toString());
    }
}
