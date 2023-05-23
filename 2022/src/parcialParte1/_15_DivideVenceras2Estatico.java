package parcialParte1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class _15_DivideVenceras2Estatico {

    public static void main(String[] args){
        BigInteger arr1 = BigInteger.valueOf(9999999);
        BigInteger arr2 = BigInteger.valueOf(9999999);



        System.out.println();


        System.out.println(dv2Multiplicacion(arr1, arr2));

    }

    // ---------------------------- Divide y vencer�s 2 (est�tico) -------------------------
    public static BigInteger dv2Multiplicacion(BigInteger x, BigInteger y) {
        int n = Math.max(x.bitLength(), y.bitLength());
        if (n <= 2000) { // Caso base: n�meros peque�os
            return x.multiply(y);
        }

        // Igualar la cantidad de dígitos a la potencia de dos más cercana
        n = (n / 2) + (n % 2);

        // Dividir los números en mitades
        BigInteger tenPowN = BigInteger.TEN.pow(n);
        BigInteger a = x.divide(tenPowN);
        BigInteger b = x.mod(tenPowN);
        BigInteger c = y.divide(tenPowN);
        BigInteger d = y.mod(tenPowN);

        // Calcular las multiplicaciones intermedias
        BigInteger ac = dv2Multiplicacion(a, c);
        BigInteger bd = dv2Multiplicacion(b, d);
        BigInteger adPlusBc = dv2Multiplicacion(a.add(b), c.add(d)).subtract(ac).subtract(bd);

        // Calcular el resultado final
        return ac.multiply(tenPowN.pow(2)).add(adPlusBc.multiply(tenPowN)).add(bd);

    }


}
