package parcialParte1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class _15_DivideVenceras2Estatico {

    public static void main(String[] args){
        //2x2
        BigInteger n0 = new BigInteger("93");
        BigInteger num0 = new BigInteger("43");

        //4x4
        BigInteger n1 = new BigInteger("9384");
        BigInteger num1 = new BigInteger("4321");

        //8x8
        BigInteger n2 = new BigInteger("93849383");
        BigInteger num2 = new BigInteger("43212456");

        //16x16
        BigInteger n3 = new BigInteger("9384938384738374");
        BigInteger num3 = new BigInteger("4321245679876543");

        //32x32
        BigInteger n4 = new BigInteger("93849383847383748372838374837372");
        BigInteger num4 = new BigInteger("43212456798765431234543224232344");

        //64x64
        BigInteger n5 = new BigInteger("9384938384738374837283837483737275950483832727273748484235577890");
        BigInteger num5 = new BigInteger("4321245679876543123454322423234456788763222222222222222222221234");

        //128x128
        BigInteger n6 = new BigInteger("93849383847383748372838374837372759504838327272737484842355778900987654321245679876543123454322423234456789384938384738374837283");
        BigInteger num6 = new BigInteger("43212456798765431234543224232344567887632222222222222222222212345678355778900987654321245679876543123454322423234456788763222222");

        //256x256
        BigInteger n7 = new BigInteger("9384938384738374837283837483737275950483832727273748484235577890098765432124567987654312345432242323445678938493838473837483728593849383847383748372838374837372759504838327272737484842355778900987654321245679876543123454322423234456789384938384738374837285");
        BigInteger num7 = new BigInteger("4321245679876543123454322423234456788763222222222222222222221234567835577890098765432124567987654312345432242323445678876322222222222222222222123456789012357789009876543212456798765431234543224232344567887632222222222222222222212345678928603836596003857473");

        List<BigInteger> lista1 = new ArrayList<>();
        lista1.add(n0);
        lista1.add(n1);
        lista1.add(n2);
        lista1.add(n3);
        lista1.add(n4);
        lista1.add(n5);
        lista1.add(n6);
        lista1.add(n7);

        List<BigInteger> lista2 = new ArrayList<>();
        lista2.add(num0);
        lista2.add(num1);
        lista2.add(num2);
        lista2.add(num3);
        lista2.add(num4);
        lista2.add(num5);
        lista2.add(num6);
        lista2.add(num7);

        for(int i=0; i<8; i++){
            System.out.println("----------");
            int[] arr1 = convertBigIntegerToArray(lista1.get(i));
            int [] arr2 = convertBigIntegerToArray(lista2.get(i));
            System.out.println(arr1.length+" X "+arr2.length);

            double startTime = System.nanoTime();
            BigInteger result = convertArrayToBigInteger(divideyVenceras2(arr1, arr2));
            double endTime = System.nanoTime();
            System.out.println("Tiempo: "+(endTime-startTime)/100_000);
            System.out.println("Resultado: "+result);
        }
    }

    private static final int IZQ = 0;
    private static final int DER = 1;

    //método para iniciar el algoritmo
    public static int[] divideyVenceras2(int vec1[], int vec2[]) {

        if ( vec1.length <= 100 || vec2.length <= 100 ) {
            return multi( vec1, vec2 );
        }
        int tam = tamanio (vec1, vec2);
        vec1 = completar (vec1, tam, IZQ);
        vec2 = completar (vec2, tam, IZQ);
        int w [] = splitArray ( vec1 , IZQ);
        int x [] = splitArray ( vec1 , DER);
        int y [] = splitArray ( vec2 , IZQ);
        int z [] = splitArray ( vec2 , DER);
        int m1 [] = divideyVenceras2(w, y);
        int m3 [] = divideyVenceras2(x, z);
        int r [] = divideyVenceras2(sumaArray( w, x ),sumaArray( y, z ));
        int m2 [] = restaArray( r, sumaArray( m1, m3 ));
        return sumaArray(sumaArray(completar(m1,m1.length+tam,DER),
                completar(m2,m2.length + tam/2, DER )) , m3);
    }

    //método para completar el array
    public static int[] completar(int vec[], int tam, int id) {
        int res[];
        if (tam > vec.length) {
            int cant = tam - vec.length;
            res = new int[tam];
            if (id == IZQ) {
                for (int i = 0; i < res.length; i++) {
                    if (i<cant) res[i] = 0;
                    else res[i] = vec [i - cant];
                }
                return res;
            }
            else {
                for (int i = 0; i < res.length; i++) {
                    if (i<vec.length) res[i] = vec [i];
                    else res[i] = 0;
                }
                return res;
            }
        }
        return vec;
    }

    //método para restar el array de ceros
    public static int[] restaArray(int vec[], int vec2[]) {
        int res[]=new int [vec.length];
        int k,j=vec2.length-1;
        int bvec = base ( vec ), bvec2 = base ( vec2 );
        for(int i=vec.length-1; i>=bvec; i--) {
            if(j>=bvec2) {
                if( vec[i] >= vec2[j])
                    res[i]= vec[i] - vec2[j];
                else {
                    k=i;
                    vec[k]+=10;
                    while( vec[k-1]==0 && k>bvec) {
                        vec[k-1]=9;
                        k--;
                    }
                    vec[k-1]--;
                    res[i]= vec[i] - vec2[j];
                }
                j--;
            }
            else
                res[i]=vec[i];
        }
        return res;
    }

    //mpetodo para obtener la base2
    public static int base(int v[]) {
        int pos=0;
        while (v [pos]==0 && pos < v.length -1) {
            pos++;
        }
        if(pos>2)
            pos--;
        return pos ;
    }


    //método para partir el array
    public static int[] splitArray(int vec[], int id) {
        int tam = vec.length;
        int res[]=new int[tam/2];
        if (id == IZQ) {
            for (int i = 0; i < tam/2; i++)
                res[i] = vec [i];
        } else {
            for (int i = tam/2; i <tam; i++)
                res[i-tam/2] = vec [i];
        }
        return res;
    }

    //método para sumar los arrays resultantes
    public static int[] sumaArray(int v1[], int v2[]) {
        int res[];
        int mayor[]=v1 ;
        int menor[]= v2 ;
        if (v2.length>v1.length) {
            mayor = v2;
            menor = v1;
        }
        res = new int [mayor.length+1];
        int j = menor.length - 1 ;
        for(int i = res.length-1; i>0; i--) {
            if( j >= 0) {
                int temp= mayor[i-1]+menor[j];
                res[i]+=temp;
                res[i-1] =res[i]/10;
                res[i]=res[i]%10;
                j--;
            }
            else {
                res[i]+=mayor[i-1];
                res[i-1] =res[i]/10;
                res[i]=res[i]%10;
            }
        }
        return res;
    }

    //método para definir el tamaño
    private static int tamanio(int[] vec1, int[] vec2) {
        int max = Math.max(vec1.length, vec2.length);
        int tam = 1;
        while (tam < max) {
            tam <<= 1;
        }
        return tam;
    }

    //método para solucionar el caso base
    private static int[] multi(int arreglo1[], int arreglo2[] ){
        int resultado[]= new int [arreglo1.length+ arreglo2.length];
        int k;
        int acarreo = 0;

        for (int i = arreglo2.length -1; i>=0; i--){

            //Verifica a qué tan lejos está del borde derecho del arreglo resultado
            k  = resultado.length - (arreglo2.length - i);
            //Recorre el arreglo multiplicando desde la última posición
            for (int j = arreglo1.length - 1; j >= 0; j--) {

                //Realiza la multiplicación y suma sobre el resultado anterior
                resultado[k] += arreglo1[j] * arreglo2[i] + acarreo ;
                if (resultado[k] >= 10) {
                    acarreo = resultado[k]/10;
                    resultado[k] = resultado[k]%10;
                } else {
                    acarreo = 0;
                }

                k--;
            }
            resultado[k]=acarreo;
            acarreo = 0;
        }
        return resultado;
    }


    public static int[] convertBigIntegerToArray(BigInteger number) {
        String numberString = number.toString();
        int[] array = new int[numberString.length()];

        for (int i = 0; i < numberString.length(); i++) {
            array[i] = Character.getNumericValue(numberString.charAt(i));
        }

        return array;
    }

    public static BigInteger convertArrayToBigInteger(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
        }

        return new BigInteger(stringBuilder.toString());
    }
}
