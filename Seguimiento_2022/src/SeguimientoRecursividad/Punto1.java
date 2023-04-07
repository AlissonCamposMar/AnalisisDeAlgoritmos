package SeguimientoRecursividad;

public class Punto1 {

    public static void main(String[] args) {

        String matriz[][]=	{
                {"sien", "encima", "mapa"},
                {"pata", "tapa", "papa"},
                {"pato", "toma", "mama"},
        };

        boolean centi=recursividad(matriz);
        System.out.println(centi);

    }

    private static boolean recursividad(String[][] matriz) {
        int con=0;
        String zzz="";
        String z="";
        boolean centi=true;
        for(int i=0; i<matriz.length;i++ ) {
            for(int j=0; j<matriz[0].length;j++ ) {
                if(j==matriz[0].length-1) {
                    if(z.equals(matriz[i][j].substring(0,2))) {
                        String xxx=matriz[i][j];
                        int www=xxx.length();
                        zzz=xxx.substring(www-2,www);
                        con++;
                    }else if(zzz.equals(matriz[i][j].substring(0,2))) {
                        String xxx=matriz[i][j];
                        int www=xxx.length();
                        zzz=xxx.substring(www-2,www);
                        con++;
                    }
                }else if(i==0) {
                    String x=matriz[i][j];
                    int w=x.length();
                    z=x.substring(w-2,w);

                    if(z.equals(matriz[i][j+1].substring(0,2))) {
                        con++;
                    }
                }else
                if(zzz.equals(matriz[i][j].substring(0,2))) {
                    String xxx=matriz[i][j];
                    int www=xxx.length();
                    zzz=xxx.substring(www-2,www);
                    con++;
                }
            }
        }
        if(con!=(matriz.length*matriz[0].length)) {
            centi=false;
        }
        return centi;
        //System.out.println(con);
    }
}
