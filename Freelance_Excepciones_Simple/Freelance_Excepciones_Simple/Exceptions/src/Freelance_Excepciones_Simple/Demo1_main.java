package Freelance_Excepciones_Simple;

/**
 * La empresa "TuWeb" subcontrata Freelance para diversos proyectos A cada
 * freelance se le proporciona una serie de contraseñas únicas para acceso a los
 * recursos: correo, carpeta compartida, servidor de pruebas, servidor en
 * producción. Este programa permite a los Freelance conocer sus contraseñas y
 * su saldo mensual Y permite a los administradores dar de alta Freelance en el
 * sistema y listarlos ordenadamente mostrando el identificador que cada uno ha
 * de usar para consultar sus contraseñas y pagos mensuales. No hay control de
 * errores, debes de mejora el programa para que no falle.
 *
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.security.cert.CertificateException;

/**
 * para pruebas DNI: 12345678Z o 11111111H
 *
 */
public class Demo1_main {

    static ArrayList<FreeLance> lista = new ArrayList<>();

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        try {
            //No queremos que al cliente le aparezcan los mensajes de error.
            menuPrincipal(sc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //Siempre hay que cerrar el scanner.
            sc.close();
            System.out.println("Hasta pronto!!");
        }

    }

    private static void menuPrincipal(Scanner sc) throws CertificateException, MiException {

        int opcionInicio = -1;

        do {
            //Queremos que el bucle continúe ejecutándose aunque se produzcan excepciones
            System.out.println("--- Menú principal ---");
            System.out.println("¿Eres Freelance (1) o Administrador (2)? Salir (0)");
            try {
                opcionInicio = sc.nextInt();

                if (opcionInicio == 1) {
                    MenuFreelance.mostrar(sc, lista);
                } else if (opcionInicio == 2) {
                    MenuAdministrador.mostrar(sc, lista);
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Indoduzca 1 o 2.");
                sc.nextLine();//limpio buffer
            } 

            //catch (java.util.inputMismatchException)con mensaje:
            //(Opción invalidad, debes introducir un número(0,1 o 2))
            //Y limpiar buffer (sc.nextLine();)
            //otro catch para el resto de excepciones
            //Mostrar siempre "Volviendo al menú principal..." usar (finally)
            System.out.println("Volviendo al menú principal...");
        } while (opcionInicio != 0);

    }
}
