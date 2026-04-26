
package Freelance_Excepciones_Simple;
import java.security.cert.CertificateException;
import java.time.LocalDateTime;
/**
 * Clase que representa a una Persona, extiende la clase abstracta SerVivo.
 * Sobreescrive los metodos: moverse y toString. 
 * Hereda de SerVivo getId, getComidaFavorita, getEspecie, getAñoNacimiento
 * ademas de equals y compareto que le permite ser ordenado, 
 * es decir utilizar Array.sort(personas)
 * Incluye el metodo saludo
 */
public class Persona{

    // Atributos
    protected String nombre;      // protected, accesible en subclases
    protected String dni;
    protected int añoNacimiento;

     /**
     * Constructor de Persona
     * @param nombre Nombre del padre
     * @param añoNacimiento año de Nacimiento
     * @param dni comida favorita
     * @throws CertificateException Si la letra no coincide.
     */
 
    public Persona(String nombre, int añoNacimiento, String dni) throws CertificateException {
        this.nombre = nombre;
        this.añoNacimiento = añoNacimiento;
        Persona.validarDNI(dni);
        this.dni = dni;
    }
   /**
     * Método que devuelve un saludo personalizado.
     * El método es protegido, por lo que es accesible dentro del paquete
     * y por clases que hereden de Persona.
     *
     * @return Cadena con el saludo, por ejemplo: "Hola, soy "+ nombre.
     */
    protected String saludo() {
        return "Hola, soy " + nombre;
    }
    
/**
 * Valida un DNI comprobando que la letra corresponde con el número.
 * ejem (08982597S)
 * @param DNI Cadena que representa el DNI (8 números seguidos de una letra).
 * @throws CertificateException Si la letra no coincide.
 */    
 
private static void validarDNI (String DNI) throws CertificateException
{
    //Lanza tambien StringIndexOutOfBoundsException 
    //Cuando el usuaruo introduce un DNI faltandole algun digito
    int DNIsinletra = Integer.parseInt(DNI.substring(0,8));
    String letra = DNI.substring(8, 9).toUpperCase();
    
    String[] letras = {
    "T","R","W","A","G","M","Y","F","P","D","X","B",
    "N","J","Z","S","Q","V","H","L","C","K","E"
    };
    int resto = DNIsinletra % 23;

    if (!letra.equals(letras[resto])) {
        throw new CertificateException("DNI erróneo");
    }
}
    /**
     * Representación en cadena de la persona en formato tipo JSON.
     *
     * @return Cadena con los atributos: nombre, año de nacimiento y comida favorita.
     */
    @Override
    public String toString() {
        
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ",añoNacimiento='" + this.añoNacimiento+ '\'' +
                '}';
    }

}
