package punto4_2;

public class numKaprecarRecursivo {
    public static void main(String[] args) {
        int numero = 703;
        boolean esKaprekarRecursivo;
        long tiempoEjecucionRecursivo, startTime, endTime;

        startTime = System.nanoTime();
        esKaprekarRecursivo = numeroKaprekarRecursivo(numero, 0, 0, 0);
        endTime = System.nanoTime();
        tiempoEjecucionRecursivo = endTime - startTime;
        System.out.println("Tiempo recursivo: "+tiempoEjecucionRecursivo+" Nanosegundos");

        if (esKaprekarRecursivo == true) {
            System.out.println("Sí es Kaprekar");
        }else{
            System.out.println("No es Kaprekar");
        }
    }
    private static boolean numeroKaprekarRecursivo(int numero, int potencia, int aux, int numeroDigitos) {
        long square = (long) numero * numero;
        String strSquare = String.valueOf(square);

        // Si el número de dígitos es impar, agregamos un 0 al principio
        if (strSquare.length() % 2 != 0) {
            strSquare = "0" + strSquare;
        }

        return numeroKaprekarRecursivoAux(strSquare, numero);
    }

    private static boolean numeroKaprekarRecursivoAux(String strSquare, int numero) {
        if (strSquare.length() <= 1) {
            return false;
        } else {
            // Dividimos la cadena en dos partes iguales en el punto medio
            int midpoint = strSquare.length() / 2;
            String strLeft = strSquare.substring(0, midpoint);
            String strRight = strSquare.substring(midpoint);

            // Convertimos las dos partes en números enteros
            int left = Integer.parseInt(strLeft);
            int right = Integer.parseInt(strRight);

            // Verificamos si la suma es igual al número original
            if (left + right == numero) {
                return true;
            } else {
                return numeroKaprekarRecursivoAux(strLeft, numero) || numeroKaprekarRecursivoAux(strRight, numero);
            }
        }
    }
}