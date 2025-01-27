import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Parte1 {
    public static void main(String[] args) {
        File archivo = new File("src\\input1.txt");

        String medicion;
        int medicion_base;
        int aumentos = 0;
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            medicion_base = Integer.parseInt(leer.readLine());

            while ((medicion = leer.readLine()) != null){
                if (Integer.parseInt(medicion) > medicion_base){
                    aumentos++;
                }
                medicion_base = Integer.parseInt(medicion);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        System.out.println("TOTAL DE AUMENTOS: " + aumentos);
    }
}
