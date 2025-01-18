import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        File archivo = new File("src\\input.txt");

        //Leer el archivo - Separar listas
        String linea;
        String[] partes;
        ArrayList<Integer> lista_Izquierda = new ArrayList<>();
        ArrayList<Integer> lista_Derecha = new ArrayList<>();
        try (BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            while ((linea = leer.readLine()) != null){
                partes = linea.split("\s+");
                lista_Izquierda.add(Integer.parseInt(partes[0]));
                lista_Derecha.add(Integer.parseInt(partes[1]));
            }
        } catch (Exception e) {
            System.err.println("Error al intentar leer el archivo!" + e.getMessage());
        }

        //Comparar parejas - Sacar distancia
        //int distancia = 0;
        //int diferencia;
        Collections.sort(lista_Izquierda);
        Collections.sort(lista_Derecha);

        /*for (int i = 0; i < lista_Izquierda.size(); i++) {
            diferencia = Math.abs(lista_Izquierda.get(i) - lista_Derecha.get(i));
            distancia += diferencia;
        }*/
        //----------------------------------------------------------------------------
        //Parte dos
        int mult = 0;
        int similitud = 0;
        for (int i = 0; i < lista_Izquierda.size(); i++) {
            for (int j = 0; j < lista_Derecha.size(); j++) {
                if (lista_Izquierda.get(i).equals(lista_Derecha.get(j))){
                    mult++;
                }
            }
            similitud += lista_Izquierda.get(i)*mult;
            mult = 0;
        }
        /*Mostrar listas
        System.out.println("LISTA IZQUIERDA");
        for (int numeros : lista_Izquierda){
            System.out.print(numeros);
        }
        System.out.println("\nLISTA DERECHA");
        for (int numeros : lista_Derecha){
            System.out.print(numeros);
        }*/

        //System.out.println("\nDISTANCIA TOTAL: " + distancia);
        System.out.println("\nSIMULITUD TOTAL: " + similitud);
    }
}
