import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Parte2 {
    public static void main(String[] args) {
        File archivo = new File("src\\input2.txt");

        ArrayList<Integer> lineas = new ArrayList<>();

        try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = leer.readLine()) != null) {
                lineas.add(Integer.parseInt(linea));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int trio;
        int aumentos = 0;
        int trioBase = lineas.get(0) + lineas.get(1) + lineas.get(2);
        for (int i = 1; i < lineas.size() - 2; i++) {
            trio = lineas.get(i) + lineas.get(i + 1) + lineas.get(i + 2);

            if (trio > trioBase){
                aumentos++;
            }
            trioBase = trio;
        }


        System.out.println("TOTAL DE AUMENTOS: " + aumentos);
    }
}
