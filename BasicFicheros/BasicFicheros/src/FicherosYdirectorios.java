
import java.io.File;
import java.util.Date;

public class FicherosYdirectorios {
    public static void main(String[] args) { 
            File dir = new File("C:\\Users\\Leonor\\OneDrive\\Desktop");
            File f = new File(dir, "prueba.txt");
            System.out.println("f exists  =  " + f.exists());
            System.out.println("d exists  =  " + dir.exists());
            System.out.println("f isFile = " + f.isFile());
            System.out.println("d isFile =  " + dir.isFile());
            System.out.println("f isDirectory =  " + f.isDirectory());
            System.out.println("d isDirectory=  " + dir.isDirectory());
            System.out.println("f getParent=  " + f.getParent());
            System.out.println("f getName= " + f.getName());

            Date fecha = new Date (dir.lastModified());
            System.out.println(fecha);
            f.setLastModified(System.currentTimeMillis());
            Date fecha2 = new Date (f.lastModified());
            System.out.println(fecha2);
          
              /* System.out.println("Contenido de \"C:\\Users\":");
          
            File[] archivos = dir.listFiles();
            
            for (File f : archivos) {
                System.out.println(f);
            }*/      
    }
}