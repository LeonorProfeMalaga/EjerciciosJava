package Freelance_Excepciones_Simple;

import java.security.cert.CertificateException;
import java.time.LocalDateTime;

/**
 * Clase mal diseñada para provocar excepciones no controladas
 */

public class FreeLance extends Persona {
    private String[] contraseñas;
    private double costeProyecto;
    private String idProyecto;
    /**
     * Constructor
     *
     * @param nombre
     * @param añoNacimiento
     * @param dni
     * @param contraseñas
     * @param costeProyecto
     * @param nombreProyecto
     * @throws CertificateException si el DNI es incorrecto
     */
    public FreeLance(String nombre, int añoNacimiento,
            String dni, String[] contraseñas, double costeProyecto, String nombreProyecto)
            throws CertificateException {

        super(nombre, añoNacimiento,dni);
        this.contraseñas = contraseñas;
        this.costeProyecto = costeProyecto;
        this.idProyecto = this.generarIdentificador(nombreProyecto);
    }

    public double mensualidad(int meses) {
        // Si meses= 0 causa ArithmeticException.
        return this.costeProyecto / meses;
    }

    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }

    public String[] getContraseñas() {
        return contraseñas;
    }

    public double getCosteProyecto() {
        return costeProyecto;
    }

    /**
     * Actualiza una contraseña.
     *
     * @param post, posición dentro del array de contraseñas.
     * @param contraseña, nueva contraseña para esa posición.
 *
     */
    public void updateContraseña(int post, String contraseña) {
        // Si post no existe causa IndexOutOfBoundsException
        this.contraseñas[post] = contraseña;
    }
     /**
 * Genera un identificador único basado en un nick proporcionado y 
 * un numero aleatorío con semilla basada en 
 * la fecha-hora:minutos:segundos del sistema operativo.
 * El número aleatorio estará comprendido entre 0 y 99.999.999.
 *
 * @param nick El nombre o alias del usuario que se utilizará como prefijo del identificador.
 * @return Un String que representa el identificador generado en formato {@nick_numero}.
 */
    private String generarIdentificador(String nick) {
        // Obtener la fecha y hora actual
        LocalDateTime ahora = LocalDateTime.now();
        // Crear una semilla basada en la combinación de usuario, fecha/hora
        long semilla = (ahora.toString()).hashCode();
        // Inicializar Random con la semilla
        java.util.Random random = new java.util.Random(semilla);
        // Generar un identificador aleatorio
        int idAleatorio = random.nextInt(100000000); //número entre 0 y 99999999

        return nick + "_" + idAleatorio;
    }

    /**
     * Regresa el contenido de una contraseña que se encuentre en la posición
     * del array indicada.
     *
     * @param post, posición dentro del array de contraseñas.
     * @retun String la contraseña en la posición indicada.
     */
    public String getContraseña(int post) {
        // Si post no existe causa IndexOutOfBoundsException
        return contraseñas[post];
    }

    public void setCosteProyecto(double costeProyecto) {
        this.costeProyecto = costeProyecto;
    }

    /**
     * Representación del Freelance en formato tipo JSON
     */
    @Override
    public String toString() {
        return "FreeLance{"
                + "idproyecto=" + this.idProyecto + '\''
                + ", nombre='" + this.nombre + '\''
                + ", DNI=" + this.dni + '\''
                + ", idProyecto='" + this.idProyecto + '\''
                + '}';
    }
}
