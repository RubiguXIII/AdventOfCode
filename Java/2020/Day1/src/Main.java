import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("src\\input.txt");

        String linea;
        ArrayList<Integer> gastos = new ArrayList<>();
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            while ((linea = leer.readLine()) != null){
                gastos.add(Integer.parseInt(linea));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int resultado;
        salirBucles:
        for (int i = 0; i < gastos.size(); i++) {
            for (int j = 0; j < gastos.size()-1; j++) {
                for (int k = 0; k < gastos.size(); k++) {
                    if (gastos.get(i) + gastos.get(j) + gastos.get(k) == 2020){
                        resultado = gastos.get(i) * gastos.get(j) * gastos.get(k);
                        System.out.println(gastos.get(i) + "x" + gastos.get(j) + "x" + gastos.get(k) + " RESULTADO: " + resultado);
                        break salirBucles;
                    }
                }
            }
        }
    }
}
