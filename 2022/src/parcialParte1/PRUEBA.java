package parcialParte1;

import java.math.BigInteger;
import java.util.Random;

public class PRUEBA {
    public static void main(String[] args) {
        BigInteger[] array = {BigInteger.valueOf(123), BigInteger.valueOf(456), BigInteger.valueOf(789)};
        BigInteger result = convertArrayToBigInteger(array);
        System.out.println("El resultado es: " + result);
    }

    public static BigInteger convertArrayToBigInteger(BigInteger[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (BigInteger element : array) {
            stringBuilder.append(element.toString());
        }
        return new BigInteger(stringBuilder.toString());
    }
}
