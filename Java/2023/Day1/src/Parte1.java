import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Parte1 {
    public static void main(String[] args) {
        File archivo = new File("src\\input.txt");

        String linea;
        String numero = "";
        ArrayList<String> numeros = new ArrayList<>();
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            while ((linea = leer.readLine()) != null){
                for (int i = 0; i < linea.length(); i++) {
                    if (!String.valueOf(linea.charAt(i)).matches("[a-zA-Z]")){
                        numero += String.valueOf(linea.charAt(i));
                    }
                }
                numeros.add(numero);
                numero = "";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        int calibracion = 0;
        for(String num : numeros){
            num = String.valueOf(num.charAt(0)) + String.valueOf(num.charAt(num.length()-1));
            calibracion += Integer.parseInt(num);
        }
        System.out.println("CALIBRACIÓN: " + calibracion);
    }
}
