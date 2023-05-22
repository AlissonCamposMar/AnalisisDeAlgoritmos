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
        // Dividir x e y en dos partes iguales
        BigInteger[] partesX = dividirEnPartes(x);
        BigInteger[] partesY = dividirEnPartes(y);
        BigInteger a = partesX[0], b = partesX[1];
        BigInteger c = partesY[0], d = partesY[1];
        // Calcular los cuatro productos parciales
        BigInteger ac = dv2Multiplicacion(a, c);
        BigInteger bd = dv2Multiplicacion(b, d);
        BigInteger suma = dv2Multiplicacion(a.add(b), c.add(d));
        BigInteger adbc = suma.subtract(ac).subtract(bd);
        // Calcular el resultado final
        BigInteger resultado = ac.multiply(BigInteger.TEN.pow(2 * n))
                .add(adbc.multiply(BigInteger.TEN.pow(n)))
                .add(bd);
        return resultado;
    }

    // Divide un n�mero en dos partes iguales (redondeo hacia abajo)
    private static BigInteger[] dividirEnPartes(BigInteger x) {
        int n = x.bitLength() / 2;
        BigInteger a = x.shiftRight(n);
        BigInteger b = x.subtract(a.shiftLeft(n));
        return new BigInteger[] {a, b};
    }


    public static BigInteger readFileToBigInteger(String filePath) {
        BigInteger result = null;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                line = reader.readLine();
            }

            String fileContent = stringBuilder.toString();
            result = new BigInteger(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

}
