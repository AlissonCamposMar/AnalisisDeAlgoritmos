package SeguimientoRecursividad;

public class codigoE_11 {
    public static void main(String[] args) {

        String cod="33456583722";
        int comprobacion=cod.charAt(0)-48;
        String s1=cod.substring(1,6);
        String s2=cod.substring(6,11);
        int sumaS1=0;
        int sumaS2=0;
        int i=0;
        int sumaAux=0;
        int divisor = 2;
        //System.out.println(cod.substring(0,1));
        sumaS1=codigoBarras(s1,i,sumaAux);
        sumaS2=codigoBarras(s2,i,sumaAux);

        System.out.println(sumaS1);
        System.out.println(sumaS2);

        if(sumaS1>sumaS2) {
            sumaS2+=comprobacion;
            if(numeroPrimo(sumaS2, divisor)) {
                System.out.println("El código de barras E-11 es correcto");
            }else {
                System.out.println("El código de barras E-11 No es correcto");
            }
        }else {
            System.out.println("El código de barras E-11 No es correcto");
        }
    }
    private static int codigoBarras(String s,int i, int suma) {

        if(i>=s.length()) {
            return suma;
        }

        if(i<s.length()) {
            int numero=s.charAt(i)-48;
            if(numero%2==0) {
                suma+=numero*5;
            }else {
                suma+=numero*3;
            }
            return codigoBarras(s, i+1, suma);
        }
        return suma;
    }
    private static boolean numeroPrimo(int num, int divisor){
        if(num/2 < divisor){
            return true;
        } else {
            if(num%divisor==0){
                return false;
            } else {
                return numeroPrimo(num, divisor+1);
            }
        }
    }
}
