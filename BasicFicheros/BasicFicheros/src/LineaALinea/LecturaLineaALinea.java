package LineaALinea;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LecturaLineaALinea {

    public static void main(String[] args) {

        FileReader f = null;
        BufferedReader br = null;
        String linea;
        try {
            f = new FileReader("C:\\Users\\Leonor\\OneDrive\\Desktop\\prueba.txt");
            br = new BufferedReader(f);
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println("No se puedo leer el fichero");
        } finally {
            try {
                f.close();
                br.close();
            } catch (IOException e) {
                System.out.println(" Problemas al cerrar los Objetos Readers");
            }

        }
    }
}
