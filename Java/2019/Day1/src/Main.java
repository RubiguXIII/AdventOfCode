import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("src\\input.txt");

        String linea;
        double masa;
        double totalCombustible = 0;

        try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
            while ((linea = leer.readLine()) != null) {
                masa = Double.parseDouble(linea);
                totalCombustible += calcularCombustible(masa);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("TOTAL DE COMBUSTIBLE: " + totalCombustible);
    }

    private static double calcularCombustible(double masa) {
        double operacion = Math.floor(masa / 3) - 2;
        if (operacion > 0) {
            return operacion + calcularCombustible(operacion);
        }
        return 0;
    }
}
