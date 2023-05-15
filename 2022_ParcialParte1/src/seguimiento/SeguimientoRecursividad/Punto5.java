package seguimiento.SeguimientoRecursividad;

public class Punto5 {
    public static void main(String[] args) {

        String h="Carlos (el hermano de Juan (mi mejor amigo) que regresa a la Argentina el día 20) ir a esperarlo al aeropuerto";

        String n=eliminarComentarios(h,"",0,0,0,false);
        System.out.println(n);

    }

    private static String eliminarComentarios(String m, String texto, int i, int posInicial, int posFinal, boolean inicial) {

        if(i>=m.length()) {
            texto=m.substring(posInicial, posFinal+1);
            System.out.println(posInicial+" ,"+posFinal);
            return m.replace(texto, "");
        }else {
            String x=m.substring(i,i+1);

            if(x.equals("(") && inicial==false) {
                inicial=true;
                posInicial=i;

                return eliminarComentarios(m, texto, i+1, posInicial, posFinal, inicial);
            }
            if(x.equals(")") ) {

                posFinal=i;

                return eliminarComentarios(m, texto, i+1, posInicial, posFinal, inicial);
            }
        }
        return  eliminarComentarios(m, texto, i+1, posInicial, posFinal, inicial);
    }
}
