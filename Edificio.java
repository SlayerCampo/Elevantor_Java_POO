import java.util.Scanner;

public class Edificio {
    private int totalPisos;
    private Elevador elevador;

    public Edificio(int totalPisos) {
        this.totalPisos = totalPisos;
        this.elevador = new Elevador();
    }

    public void iniciarSimulacion() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n Bienvenido al edificio UCC.");
        System.out.println("Usted está en el primer piso.");
        System.out.println("Frente a usted hay un ascensor con las puertas cerradas.");
        System.out.println("Por favor, escriba 'oprimir boton para arriba' para llamar al ascensor.");

        String accion = input.nextLine().toLowerCase();

        // Validar comando
        while (!accion.equals("oprimir boton para arriba")) {
            System.out.println(" Comando no reconocido. Escriba exactamente 'oprimir boton para arriba'.");
            accion = input.nextLine().toLowerCase();
        }

        System.out.println("\n Botón de subida presionado...");
        System.out.println("( Luz del botón encendida y sonido 'clic')");
        elevador.abrirPuertas();
    }
}
