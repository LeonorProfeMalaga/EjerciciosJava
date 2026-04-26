package CaracterACaracter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerCaracterACarracter {
    public static void main(String[] args){
        FileReader fr = null;
        try {
            fr = new FileReader("C:\\Users\\Leonor\\OneDrive\\Desktop\\prueba.txt");
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char)c);
            }          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
           try{
                fr.close();
                System.out.println(System.lineSeparator() + "!!FIN!!");
           }catch(IOException e){
               System.out.println("Problema al cerrar el fichero");
           }
        }
    }
}