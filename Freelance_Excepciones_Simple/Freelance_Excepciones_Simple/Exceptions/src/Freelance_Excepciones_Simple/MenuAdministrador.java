package Freelance_Excepciones_Simple;

import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Clase que gestiona el menú del Administrador.
 *
 * Permite realizar las siguientes acciones:
 * <ul>
 * <li>Listar todos los Freelance dados de alta</li>
 * <li>Dar de alta un nuevo Freelance</li>
 * <li>Volver al menú principal</li>
 * </ul>
 *
 * Todos los métodos son estáticos porque no es necesario crear objetos de esta
 * clase.
 */
public class MenuAdministrador {

    /**
     * Muestra el menú de administrador y gestiona las opciones elegidas.
     *
     * @param sc Objeto Scanner para leer datos por teclado.
     * @param lista Lista de objetos FreeLance almacenados en memoria.
     * @throws CertificateException Se lanza si el DNI introducido no es válido.
     */
    public static void mostrar(Scanner sc, ArrayList<FreeLance> lista) throws CertificateException, MiException {
        int opcion;

        do {
            System.out.println("---2-Menú Administrador ---");
            System.out.println("1. Listar Freelance");
            System.out.println("2. Dar de alta Freelance");
            System.out.println("3. Volver al inicio");
            // Maneja por un lado la excepción java.util.InputMismatchException
            // con mensaje !! Debes introducir un número válido¡¡
            // Y por otro las excepcione personalizadas que crees 
            // mostrando e.getMessage()+ "No se pudo almacenar el registro. Intentelo de nuevo."
            
            opcion = sc.nextInt();
            submenu(opcion, sc, lista);
        } while (opcion != 3);
    }

    private static void submenu(int opcion, Scanner sc, ArrayList<FreeLance> lista) throws CertificateException, MiException {
        switch (opcion) {
            case 1 -> {
                // Ordena la lista usando el método compareTo de SerVivo
                lista.sort(null);
                // Muestra todos los Freelance
                int i = 0;
                for (FreeLance f : lista) {
                    System.out.println("idFreeLance=" + i + "," + f);
                    i++;
                }
            }

            case 2 -> {
                //inicializo variables
                int año = 1995;
                double coste = 10000;

                sc.nextLine();//Limpio Buffer
                // --------------Solicitud de datos al usuario----------------
                System.out.print("1-Nombre:");
                String nombre = sc.nextLine();

                System.out.print("2-Año nacimiento:");
                // Controlar excepcion InputMismatchException
                //Lanzar excepción personalizada
                //mensaje "Introduzca el año con números, ejem: 1996."
                año = sc.nextInt();
                int añoActual = LocalDate.now().getYear();
                
                if (año > (añoActual - 18) || año < (añoActual - 68)) {
                    //Lanzar excepción personalizada,
                    throw new MiException("------------Tiene : " + (añoActual - año) + "años , no puede trabajar con nosotros., el rango acceptado es de (18 a 68) años.------------");
                    
                }
                sc.nextLine();//Limpio Buffer
                System.out.print("3-DNI:");
                String dni = sc.nextLine();

                System.out.print("4-Coste proyecto:");
                // Controlar excepcion InputMismatchException
                //Lanzar excepción personalizada
                //mensaje "Introduzca un números entre 300 y 80000000")
                coste = sc.nextDouble();
                if (coste > 80000000 || coste < 300) {                   
                   //Lanzar excepción personalizada
                    System.out.println("El coste del proyecto debe de estar entre 300 y 80000000");
                    break;
                }
                sc.nextLine();//Limpio Buffer
                System.out.print("5-Nombre del proyecto:");
                String nickProyecto = sc.nextLine();
  
                System.out.print("6-Número de contraseñas:");
                 // Controlar excepcion InputMismatchException 
                 //y que introduzacan un número entre 0 y 4
                //Lanzar excepción personalizada
                //mensaje "Introduzca un números entre 0 y 4")
                int n = sc.nextInt();
                // Creación del array de contraseñas
                String[] contraseñas = new String[n];
                sc.nextLine();
                for (int i = 0; i < n; i++) {
                    switch (i) {
                        case 0 -> {
                            System.out.print(" - Contraseña del correo:");
                            contraseñas[i] = sc.nextLine();
                            break;
                        }
                        case 1 -> {
                            System.out.print(" - Contraseña carpeta compartida:");
                            contraseñas[i] = sc.nextLine();
                            break;
                        }
                        case 2 -> {
                            System.out.print(" - Contraseña servidor pruebas:");
                            contraseñas[i] = sc.nextLine();
                            break;
                        }
                        case 3 -> {
                            System.out.print(" - Contraseña servidor producción:");
                            contraseñas[i] = sc.nextLine();
                            break;
                        }
                    }
                }
                // Añado Freelance al array
                // En posteriores versiones utilizaremos ficheros
                // Para garantizar la persistencia de los datos.

                //Controlando las excepciones: StringIndexOutOfBoundsException |NumberFormatException|CertificateException
                // que lanza la función de comprobar DNI
                //mensaje "El DNI no cumple con el formato de DNI Español (8 números + Letra correspondiente). 
                try{
                lista.add(new FreeLance(nombre, año, dni, contraseñas, coste, nickProyecto));
                }catch(StringIndexOutOfBoundsException |NumberFormatException|CertificateException e){
                    throw new MiException("El DNI no cumple con el formato de DNI Español (8 números + Letra correspondiente)");
                
                }
                
            }
        }
    }
}
