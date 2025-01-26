import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parte2 {
    public static void main(String[] args) {
        File archivo = new File("src\\input2.txt");

        String linea;
        String numPalabra = "";
        String numero = "";
        ArrayList<String> numeros = new ArrayList<>();
        Pattern patron = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|[1-9])");
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            while ((linea = leer.readLine()) != null){
                Matcher matcher = patron.matcher(linea);
                while (matcher.find()){
                    numPalabra = matcher.group();
                    switch (numPalabra){
                        case "one":
                            numero += "1";
                            break;
                        case "two":
                            numero += "2";
                            break;
                        case "three":
                            numero += "3";
                            break;
                        case "four":
                            numero += "4";
                            break;
                        case "five":
                            numero += "5";
                            break;
                        case "six":
                            numero += "6";
                            break;
                        case "seven":
                            numero += "7";
                            break;
                        case "eight":
                            numero += "8";
                            break;
                        case "nine":
                            numero += "9";
                            break;
                        default://Para el caso de que sea un DÍGITO
                            numero += numPalabra;
                            break;
                    }
                    //System.out.print(numPalabra);
                }
                numeros.add(numero);
                //System.out.println(numero);
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
