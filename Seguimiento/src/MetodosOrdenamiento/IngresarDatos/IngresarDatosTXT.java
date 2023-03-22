package MetodosOrdenamiento.IngresarDatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class IngresarDatosTXT {
    public static void escribirArchivo(int tam, int min, int max, String nombreArchivo) {

        // Genera un arreglo de tamaño "tam" con números aleatorios
        int[] arr = new int[tam];
        Random rand = new Random();
        for (int i = 0; i < tam; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }

        // Escribe el arreglo en un archivo de texto
        try {
            FileWriter writer = new FileWriter(new File(nombreArchivo));
            for (int i = 0; i < tam; i++) {
                writer.write(String.valueOf(arr[i]));
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        int tam = 50000;
        escribirArchivo(tam,0, 1000, "Seguimiento/src/MetodosOrdenamiento/IngresarDatos/arreglo.txt");

    }
}
