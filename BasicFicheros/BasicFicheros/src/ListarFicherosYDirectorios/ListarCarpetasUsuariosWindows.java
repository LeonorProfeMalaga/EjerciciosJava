
package ListarFicherosYDirectorios;
import java.io.File;
import java.text.SimpleDateFormat;
/**
 * Programa que lista los ficheros y subdirectorios del directorio "C:\Users" en Windows.
 * Para cada elemento muestra:
 * <ul>
 *  <li>Fecha de última modificación</li>
 *  <li>Tipo: Fichero o Directorio</li>
 *  <li>Nombre</li>
 *  <li>Tamaño en bytes</li>
 * </ul>
 * 
 */
public class ListarCarpetasUsuariosWindows {
    public static void main(String[] args) {              
        try {
           // Formato de fecha para mostrar la última modificación
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
           File dir = new File("C:\\Users");
           System.out.println("Contenido de \"C:\\Users\":");
            // Listar ficheros y subdirectorios
            File[] archivos = dir.listFiles();

            for (File f : archivos) {
                String tipo = f.isDirectory() ? "Directorio" : "Fichero";
                long tamano = f.length(); // tamaño en bytes
                String modificado = sdf.format(f.lastModified());

                    // Mostrar información en pantalla
                    System.out.println(" * ("+modificado+")"+tipo + ": "
                            + f.getName() + " -> " + tamano + " bytes." );
            }

        } catch (Exception e) {
            // Captura todas las excepciones y muestra el mensaje
            e.getStackTrace();
        }              
    }
}

