package CaracterACaracter;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirCaracterACaracter {
    public static void main(String[] args) {
           FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\Users\\Leonor\\OneDrive\\Desktop\\prueba.txt", true);
            String linea1 = "Primera línea";
            String salto = System.lineSeparator(); 
            String linea2 = "Segunda línea";
            String total = linea1 + salto + linea2;

            for (int i = 0; i < total.length(); i++) {
                fw.write(total.charAt(i));
            }

        } catch (Exception e) {
            System.out.println("Error escritura: " + e.getMessage());
        }finally{
            try{
           fw.close();
            }catch(IOException e){
                System.out.println("Problemas al cerra el fichero"+ e.getMessage());
            }
        }
    }
}