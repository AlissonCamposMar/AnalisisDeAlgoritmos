package parcialParte1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class _14_DivideVenceras1Estatico {

    public static void main(String[] args){
        BigInteger arr1 = BigInteger.valueOf(9999999);
        BigInteger arr2 = BigInteger.valueOf(9999999);



        System.out.println();


        System.out.println(dv1Multiplicacion(arr1, arr2));

    }


    // ---------------------------- Divide y vencer�s 1 (est�tico) -------------------------
    public static BigInteger dv1Multiplicacion(BigInteger x, BigInteger y) {
        // Verificar si los n�meros tienen un solo d�gito
        if (x.compareTo(BigInteger.TEN) < 0 || y.compareTo(BigInteger.TEN) < 0) {
            return x.multiply(y);
        }

        // Obtener el tama�o de los n�meros
        int n = Math.max(x.bitLength(), y.bitLength());

        // Dividir los n�meros en dos mitades
        int m = n / 2;
        BigInteger a = x.shiftRight(m);
        BigInteger b = x.subtract(a.shiftLeft(m));
        BigInteger c = y.shiftRight(m);
        BigInteger d = y.subtract(c.shiftLeft(m));

        // Calcular las tres multiplicaciones necesarias
        BigInteger ac = dv1Multiplicacion(a, c);
        BigInteger bd = dv1Multiplicacion(b, d);
        BigInteger abcd = dv1Multiplicacion(a.add(b), c.add(d));

        // Calcular el resultado final
        return ac.shiftLeft(2 * m).add(abcd.subtract(ac).subtract(bd).shiftLeft(m)).add(bd);
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
