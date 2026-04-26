package LineaALinea;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Traductor {

    public static void main(String[] args) {

        BufferedReader brDic = null;
        BufferedReader brOrigen = null;
        BufferedWriter bw = null;
        String linea;

        try {
            // Crear directorio
            File directorio = new File("C:\\Users\\Leonor\\OneDrive\\Desktop\\NuevoDirectorio");
            File diccionario = new File(directorio, "diccionario.txt");
            File origen = new File(directorio, "prueba2.txt");
            File destino = new File(directorio, "pruebaEnglish.txt");

            // CONTAR LÍNEAS DEL DICCIONARIO
            int tamaño = contarLineas(diccionario, brDic);
            //ARRAYS
            String[] arrayEspañol = new String[tamaño];
            String[] arrayIngles = new String[tamaño];
            //LEER DICCIONARIO
            brDic = new BufferedReader(new FileReader(diccionario));
            int i = 0;
            while ((linea = brDic.readLine()) != null) {
                String[] partes = linea.split("----->");
                arrayEspañol[i] = partes[0];
                arrayIngles[i] = partes[1];
                i++;
            }
            brDic.close();
            // 🔹 LEER TEXTO Y TRADUCIR
            brOrigen = new BufferedReader(new FileReader(origen));
            bw = new BufferedWriter(new FileWriter(destino));
            //recoro el fichero Original
            while ((linea = brOrigen.readLine()) != null) {
                String traduccion = "";
                String[] palabras = linea.split(" ");

                for (String p : palabras) {
                    boolean encontrada = false;
                    for (i = 0; i < arrayEspañol.length; i++) {
                    // Si se encuentra la palabra la
                    //remplazo por la palabra en ingles 
                        if (p.equals(arrayEspañol[i])) {
                            traduccion += arrayIngles[i] + " ";
                            System.out.println(arrayIngles[i]);
                            encontrada = true;
                            break;
                        }
                    }
                    // Si no se encuentra, 
                    //dejamos la palabra original
                    if (!encontrada) {
                        traduccion += p + " ";
                        System.out.println(p);
                    }
                }

                bw.write(traduccion.trim());
                bw.newLine();
            }
            System.out.println("Traducción realizada correctamente");

        } catch (Exception e) {
            System.out.println("Error en el proceso" + e.toString());
        } finally {
            try {
                brDic.close();
                brOrigen.close();
                bw.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar");
            }
        }
    }

    public static int contarLineas(File fichero, BufferedReader br) {
        int contador = 0;
        try {
            br = new BufferedReader(new FileReader(fichero));
            String linea;
            while ((linea = br.readLine()) != null) {
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al contar líneas");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar");
            }
        }
        return contador;
    }
}
