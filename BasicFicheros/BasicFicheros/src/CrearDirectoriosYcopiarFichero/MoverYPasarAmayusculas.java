package CrearDirectoriosYcopiarFichero;

import java.io.*;
import java.util.Scanner;

/**
 * Programa que:
 * <ul>
 *   <li>Lee el path de un nuevo directorio y lo crea.</li>
 *   <li>Lee el path de un fichero existente y copia su contenido en mayúsculas al
 *       nuevo directorio usando BufferedReader y PrintWriter.</li>
 *   <li>Elimina el fichero original.</li>
 * </ul>
 */
public class MoverYPasarAmayusculas {

    public static void main(String[] args) {
        File nuevoDir = null;
        File archivoOrigen = null;
        Scanner sc = new Scanner(System.in);
        String filePath;
        boolean nuevoDirExiste = false;
        boolean archivoOrigenExiste = false;
        int i = 0;

        try {
            // 1. Intentamos un máximo de 5 veces obtener un path del directorio a crear 
            while (i < 5) {
                i++;
                System.out.print("Introduce el path del nuevo directorio a crear: ");
                String dirPath = sc.nextLine();
                nuevoDir = new File(dirPath);

                if (!nuevoDir.exists()) {
                    if (nuevoDir.mkdirs()) {
                        System.out.println("Directorio creado: " + nuevoDir.getAbsolutePath());
                        nuevoDirExiste = true;
                        break;
                    } else {
                        System.out.println("No se pudo crear el directorio, revise los permisos del usuario e inténtelo de nuevo.");
                    }
                } else {
                    System.out.println("El directorio ya existe: " + nuevoDir.getAbsolutePath());
                    nuevoDirExiste = true;
                    break;
                }
            }

            if (nuevoDirExiste) {                   
                // 2. Intentamos un máximo de 5 veces obtener el path del fichero a copiar          
                i = 0;
                while (i < 5) {
                    i++;
                    System.out.print("Introduce el path del fichero a copiar en el directorio: ");
                    filePath = sc.nextLine();
                    archivoOrigen = new File(filePath);

                    if (archivoOrigen.exists() && archivoOrigen.isFile() && archivoOrigen.canRead()) {
                        System.out.println("Se copiará el contenido de: " + archivoOrigen.getAbsolutePath() +
                                " en mayúsculas en: " + nuevoDir.getAbsolutePath());
                        archivoOrigenExiste = true;
                        break;
                    } else {
                        System.out.println("El fichero no existe, no es un fichero válido o no tenemos permisos suficientes para leerlo. Inténtelo de nuevo.");
                    }
                }

                if (archivoOrigenExiste) {
                    // 3. Crear objeto File para el nuevo fichero
                    File archivoDestino = new File(nuevoDir, archivoOrigen.getName());

                    // 4. Leer línea por línea y escribir en mayúsculas usando PrintWriter
                    BufferedReader br = new BufferedReader(new FileReader(archivoOrigen));
                    PrintWriter pw = new PrintWriter(new FileWriter(archivoDestino));

                    String linea;
                    while ((linea = br.readLine()) != null) {
                        pw.println(linea.toUpperCase()); 
                    }
                    //5. Cerramos los buffers
                    br.close();
                    pw.close();

                    System.out.println("Fichero copiado en mayúsculas a: " + archivoDestino.getAbsolutePath());

                    // 6. Eliminar fichero original
                    if (archivoOrigen.delete()) {
                        System.out.println("Fichero original eliminado: " + archivoOrigen.getAbsolutePath());
                    } else {
                        System.out.println("No se pudo eliminar el fichero original.");
                    }
                }            
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
