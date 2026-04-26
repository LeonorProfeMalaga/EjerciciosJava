package LineaALinea;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class CopiarFichero {

    public static void main(String[] args) {

        FileReader f = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        String linea;

        try {
            // Crear directorio
            File directorio = new File("C:\\Users\\Leonor\\Desktop\\NuevoDirectorio");
            File nuevoFichero = new File(directorio,"prueba2.txt");
            if (!directorio.exists()) {
                directorio.mkdir();
            }
          
            // Abrir archivo origen
            f = new FileReader("C:\\Users\\Leonor\\OneDrive\\Desktop\\prueba.txt");
            br = new BufferedReader(f);

            // Crear archivo destino
            bw = new BufferedWriter(
                    new FileWriter(nuevoFichero));

            // Leer y copiar línea a línea
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                bw.write(linea);
                bw.newLine(); // mantener saltos de línea
            }

            System.out.println("Copia realizada correctamente");

        } catch (Exception e) {
            System.out.println("No se pudo leer o copiar el fichero");
        } finally {
            try {
                if (f != null) f.close();
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println("Problemas al cerrar los objetos");
            }
        }
    }
}
