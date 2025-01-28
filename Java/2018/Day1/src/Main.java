import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("src\\input.txt");

        String frecuencia;
        int frecuenciaTotal = 0;
        ArrayList<Integer> frecuencias = new ArrayList<>();
        HashMap<Integer, Integer> repeticiones = new HashMap<>();
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            while ((frecuencia = leer.readLine()) != null){
                frecuenciaTotal += Integer.parseInt(frecuencia);
                frecuencias.add(frecuenciaTotal);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Almacenar frecuencias y posicion primera donde se han repetido
        for (int i = 0; i < frecuencias.size(); i++) {
            for (int j = 0; j < frecuencias.size(); j++) {
                if (frecuencias.get(i) == frecuencias.get(j)){
                    repeticiones.put(frecuencias.get(i), j);
                }
            }
        }

        //Método que busqué la clave con el valor más pequeño
        int frecuenciaREP = claveValorMasPeque(repeticiones);

        for (int frec : frecuencias){
            System.out.println(frec);
        }

        System.out.println("FRECUENCIA RESULTANTE: " + frecuenciaTotal);
        //System.out.println("PRIMERA FRECUENCIA EN REPETIRSE DOS VECES: " + frecuenciaREP);
    }
    private static int claveValorMasPeque(HashMap<Integer, Integer> repeticiones) {
        int frecuenciaRep = 0;
        int indiceMinimo = Integer.MAX_VALUE;

        for (HashMap.Entry<Integer, Integer> entry : repeticiones.entrySet()) {
            int valor = entry.getValue();
            if (valor != -1 && valor < indiceMinimo) {
                indiceMinimo = valor;
                frecuenciaRep = entry.getKey();
            }
        }
        return frecuenciaRep;
    }
}

