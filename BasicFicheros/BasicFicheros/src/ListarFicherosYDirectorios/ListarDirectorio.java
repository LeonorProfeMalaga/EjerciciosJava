
package ListarFicherosYDirectorios;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Programa que lista los ficheros y subdirectorios de un directorio
 * introducido por el usuario en Windows.
 * Para cada elemento muestra:
 * <ul>
 *  <li>Fecha de última modificación</li>
 *  <li>Tipo: Fichero o Directorio</li>
 *  <li>Nombre</li>
 *  <li>Tamaño en bytes</li>
 * </ul>
 * 
 * Permite pulsar "0" para salir y valida existencia, tipo y permisos.
 */
public class ListarDirectorio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ruta;
       int i = 0;

        try {
         
            do {
                i++;
                System.out.print("Introduce el path absoluto del directorio (0 para salir): ");
                ruta = sc.nextLine();

               if (ruta.equals("0")) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                File dir = new File(ruta);

                // Comprobar existencia y si es directorio
                if (!dir.exists()) {
                    System.out.println("El directorio no existe. Intenta de nuevo.");
                    continue;
                }
                if (!dir.isDirectory()) {
                    System.out.println("La ruta introducida no es un directorio. Intenta de nuevo.");
                    continue;
                }

                // Listar archivos y subdirectorios
                File[] archivos = dir.listFiles();
                if (archivos == null) {
                    System.out.println("No se tienen permisos para acceder a este directorio. Intenta otro.");
                    continue;
                }

                // Mostrar información de cada fichero/directorio
                System.out.println("Contenido de \"" + dir.getAbsolutePath() + "\":");
                for (File f : archivos) {
                    String tipo = f.isDirectory() ? "Directorio" : "Fichero";
                    long bytes = f.length();
                    System.out.println(" * " + tipo + ": " + f.getName() + " -> " + bytes + " bytes.");
                }
                // Se listó correctamente, salir del bucle
                break;
            } while (i < 5);

        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            sc.close(); // cerrar siempre Scanner
        }
    }
}
