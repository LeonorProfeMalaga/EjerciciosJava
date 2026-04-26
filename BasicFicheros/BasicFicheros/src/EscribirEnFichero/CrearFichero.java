package EscribirEnFichero;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Programa que crea o utiliza un fichero indicado por el usuario
 * y permite añadir líneas hasta escribir ":q" o alcanzar 500 caracteres.
 */
public class CrearFichero {

    public static void main(String[] args) {
        PrintWriter printLinea = null;
        File fichero;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String linea;
        String nombre;

        try {
            // 1. Pedir nombre del fichero y gestionar si existe
            while (true) {
                System.out.print("Introduce el nombre del fichero: ");
                nombre = sc.nextLine();
                fichero = new File(nombre);

                if (fichero.exists()) {
                    System.out.print("El fichero ya existe. ¿Desea añadir texto (A) o pulse otra tecla para indicar otro nombre? ");
                    String opcion = sc.nextLine();
                    if (opcion.equalsIgnoreCase("A")) {
                        break; // usar el fichero existente
                    }
                } else {
                    fichero.createNewFile();
                    System.out.println("Fichero creado.");
                    break; // crear fichero y salir del bucle
                }
            }

            System.out.println("El fichero se encuentra en: " + fichero.getAbsolutePath());

            // 2. Abrir fichero para añadir líneas
            printLinea = new PrintWriter(new FileWriter(fichero, true));

            // Primera línea en cada ejecución indica fecha de inserción y nombre del usuario
            linea = sdf.format(new Date()) + "_" + System.getProperty("user.name");
            printLinea.println(linea);

            int totalCaracteres = 0;

            // 3. Bucle do-while para añadir líneas hasta ":q" o 500 caracteres
            do {
                System.out.print("Introduce texto (presione 'Enter'':''q''Enter' para salir): ");
                linea = sc.nextLine();

                // Salida
                if (linea.equals(":q")) {
                    break;
                }

                // Control de 500 caracteres
                if (totalCaracteres + linea.length() > 500) {
                    System.out.println("No podemos guardar el texto, el fichero no puede tener más de 500 caracteres.");
                    break;
                }
                // Escribir línea
                printLinea.println(linea);
                totalCaracteres += linea.length();

                System.out.println("Línea añadida.");
            } while (true);

            System.out.println("Fin del programa.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar PrintWriter
            if (printLinea != null) {
                printLinea.close();
            }
            sc.close();
        }
    }
}