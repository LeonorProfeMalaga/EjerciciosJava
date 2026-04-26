package EscribirEnFichero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que crea un fichero llamado "PruebaEscritura.txt" en el directorio 
 * por defecto del programa y escribe una línea con la fecha y el nombre 
 * del usuario del sistema operativo.
 * 
 * <p>
 * La clase realiza las siguientes acciones:
 * <ul>
 *   <li>Crea el fichero si no existe.</li>
 *   <li>Añade al fichero una línea con el formato:
 *       <pre>dd/MM/yyyy HH:mm:ss_usuario</pre></li>
 *   <li>Gestiona la escritura con {@link FileWriter} en modo append.</li>
 *   <li>Captura posibles excepciones {@link IOException}.</li>
 * </ul>
 * </p>
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrearFicheroPrueba {
    public static void main(String[] args) {
        PrintWriter printLinea = null;
        File fichero = new File("PruebaEscritura.txt");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String linea = sdf.format(new Date()) + 
                "_" + System.getProperty("user.name");
        try {
            fichero.createNewFile();
            System.out.println("El fichero se encuentra en: " 
                    + fichero.getAbsolutePath());
            // Abrir para añadir líneas
            printLinea = new PrintWriter(new FileWriter(fichero, true));
            // Escribir línea con salto de línea
            printLinea.println(linea);
            System.out.println("Se añadió la línea: " + linea);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar PrintWriter de forma segura
            if (printLinea != null) {
                printLinea.close();
            }
        }
    }
}
