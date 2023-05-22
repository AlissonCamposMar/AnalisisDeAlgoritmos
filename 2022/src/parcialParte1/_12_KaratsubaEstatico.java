package parcialParte1;

import java.math.BigInteger;

public class _12_KaratsubaEstatico {

    public static void main(String[] args){
        BigInteger arr1 = BigInteger.valueOf(9999999);
        BigInteger arr2 = BigInteger.valueOf(9999999);



        System.out.println();


        System.out.println(karatsuba(arr1, arr2));

    }
    /**
     * Función para multiplicar dos números por el método Karatsuba
     * @param u multiplicando
     * @param v multiplicador
     * @return resultado multiplicación
     */
    public static BigInteger karatsuba(BigInteger u, BigInteger v) {
        int posiciones = Math.max(u.bitLength(), v.bitLength());
        //Para n menor que mil, es más eficiente la multiplicación normal.
        if (posiciones <= 1000) {
            return u.multiply(v);
        }
        posiciones = posiciones / 2;
        /*
         * Repartimos en trocitos:
         * u = w * 2^n + x
         * v = y * 2^n + z
         */
        BigInteger w = u.shiftRight(posiciones);
        BigInteger x = u.subtract(w.shiftLeft(posiciones));
        BigInteger y = v.shiftRight(posiciones);
        BigInteger z = v.subtract(y.shiftLeft(posiciones));
        // Calculamos los resultados parciales
        BigInteger p = karatsuba(w, y); //p=w*y
        BigInteger q = karatsuba(x, z); //q=x*z
        BigInteger r = karatsuba(x.add(w), z.add(y)); //r=(x+w)*(z+y)
        BigInteger z1 = r.subtract(p).subtract(q); //r-p-q
        // Se juntan los resultados parciales para obtener el resultado global.
        return p.shiftLeft(2 * posiciones).add(z1.shiftLeft(posiciones)).add(q);
    }

}


