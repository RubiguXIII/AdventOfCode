import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("src\\input.txt");

        String linea;
        int numElf = 1;
        int calorias = 0;
        HashMap<Integer, Integer> elfoCalorias = new HashMap<>();
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            while ((linea = leer.readLine()) != null){

                if (linea.isEmpty()){
                    elfoCalorias.put(numElf, calorias);
                    //System.out.println(calorias);
                    calorias = 0;
                    numElf++;
                } else {
                    calorias += Integer.parseInt(linea);
                }
            }
            //Último VALOR
            elfoCalorias.put(numElf, calorias);
            //System.out.println(calorias);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //PARTE 1º
        int valor_MAX = 0;
        for (int i = 1; i < numElf; i++) {
            if (elfoCalorias.get(i) > valor_MAX)
                valor_MAX = elfoCalorias.get(i);
        }
        System.out.println("VALOR CALORIAS ELFO CON MÁXIMAS: " + valor_MAX);
        //-----------------------------------------------------------

        //PARTE 2º
        int tresMaximos = 0;
        ArrayList<Integer> tablaCalorias = new ArrayList<>(elfoCalorias.values());
        Collections.sort(tablaCalorias, Collections.reverseOrder());

        for (int i = 0; i < 3; i++) {
            System.out.println(tablaCalorias.get(i));
            tresMaximos += tablaCalorias.get(i);
        }
        System.out.println("VALOR CALORIAS TRES ELFOS MAXIMOS: " + tresMaximos);
    }
}
