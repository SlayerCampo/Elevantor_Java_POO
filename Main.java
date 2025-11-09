import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(" Bienvenido al sistema de simulación del ascensor UCC ");
        System.out.print("Por favor, indique cuántos pisos tiene el edificio: ");
        int totalPisos = input.nextInt();
        input.nextLine(); // limpiar el buffer

        // Edificio
        Edificio edificio = new Edificio(totalPisos);

        edificio.iniciarSimulacion();

        input.close();
    }
}
