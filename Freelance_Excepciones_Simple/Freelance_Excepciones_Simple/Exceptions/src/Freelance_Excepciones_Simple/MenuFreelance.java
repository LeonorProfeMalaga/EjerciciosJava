package Freelance_Excepciones_Simple;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que gestiona el menú de los usuarios Freelance.
 *
 * Permite a un Freelance:
 * <ul>
 * <li>Consultar sus contraseñas</li>
 * <li>Calcular su salario mensual</li>
 * <li>Volver al menú principal</li>
 * </ul>
 *
 * Esta clase contiene errores intencionados (como accesos fuera de rango o
 * referencias nulas) para que los alumnos practiquen el manejo de excepciones.
 */
public class MenuFreelance {

    /**
     * Muestra el menú de Freelance y gestiona las opciones elegidas.
     *
     * @param sc Objeto Scanner para leer datos por teclado
     * @param lista Lista de Freelance disponibles
     *
     * Nota: Este método puede lanzar excepciones como:
     * <ul>
     * <li>NullPointerException</li>
     * <li>IndexOutOfBoundsException</li>
     * <li>ArithmeticException</li>
     * </ul>
     * pero no se controlan para fines didácticos.
     */
    public static void mostrar(Scanner sc, ArrayList<FreeLance> lista) {
        System.out.println("---1-Menú Freelance ---");
        // Solicita la posición del Freelance en la lista
        System.out.println("Introduzca su Id:");
        //Tratar: InputMismatchException|IndexOutOfBoundsException.  
        //System.out.println("No se encuentra el Id introduccido.");
        //sc.nextLine();
        int pos = sc.nextInt();
        FreeLance f = lista.get(pos);

        int opcion;

        do {
            System.out.println("----Menú Freelance ---para id:" + pos);
            System.out.println("1. Ver contraseña");
            System.out.println("2. Calcular mensualidad");
            System.out.println("3. Volver al inicio");
            // Controlar java.util.InputMismatchException.
            //imprime !! Debes introducir un número válido¡¡
            opcion = sc.nextInt();
            submenu(opcion, sc, f);

        } while (opcion != 3);
    }

    private static void submenu(int opcion, Scanner sc, FreeLance f) {
        switch (opcion) {

            case 1 -> {
                System.out.println("¿Qué contraseña quieres ver?");
                System.out.println("0. Correo");
                System.out.println("1. Carpeta compartida");
                System.out.println("2. Servidor pruebas");
                System.out.println("3. Servidor Producción");
                // Controlar java.util.InputMismatchException.
                //imprime "!! Debes introducir un número válido¡¡".
                //y IndexOutOfBoundsExceptio
                //imprime "No tiene contraseña asignada, solicitela".
                int c = sc.nextInt();
                if (c != 0 && c != 1 && c != 2 && c != 3) {
                    System.out.println("Opción invalida:" + c);
                    System.out.println("¿Qué contraseña quieres ver?");
                    System.out.println("0. Correo");
                    System.out.println("1. Carpeta compartida");
                    System.out.println("2. Servidor pruebas");
                    System.out.println("3. Servidor Producción");
                    c = sc.nextInt();
                }
                System.out.println("Contraseña: " + f.getContraseña(c));
            }

            case 2 -> {
                System.out.println("¿En cuántos meses harás el proyecto?");
                //Controlar java.util.InputMismatchException
                //además si introduce un número <= 0 , remplazar por 1.
                int meses = sc.nextInt();

                // Puede provocar ArithmeticException o regresar "Infinito"
                // por división entre cero - Solucionar sin usar excepciones.
                // No siempre usar excepciones es la mejor opción
                System.out.println("Cobrarás al mes: " + f.mensualidad(meses));
            }
        }
    }
}
