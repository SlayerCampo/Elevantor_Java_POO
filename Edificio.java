import java.util.Scanner;

public class Edificio {
    private int totalPisos;
    private Elevador elevador;
    private Pisos[] pisos;
    private Scanner sc;

    public Edificio(int totalPisos) {
        this.totalPisos = totalPisos;
        this.pisos = new Pisos[totalPisos];
        for (int i = 0; i < totalPisos; i++) {
            pisos[i] = new Pisos(i + 1, totalPisos);
        }
        this.elevador = new Elevador(totalPisos);
        this.sc = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("\nUsted está en el primer piso.");
        System.out.println("Frente a un ascensor cerrado. Por favor, oprima el botón para usar el ascensor.");

        while (true) {
            Pisos pisoActual = pisos[elevador.getPisoActual() - 1];
            pisoActual.mostrarOpciones();
            String accion = sc.nextLine().toLowerCase();

            if (accion.contains("subir") || accion.contains("bajar")) {
                elevador.llamarAscensor(pisoActual);
                manejarAscensor();
            } else {
                System.out.println("Comando no reconocido. Escriba 'subir' o 'bajar'.");
            }
        }
    }

    private void manejarAscensor() {
        Puertas puertas = elevador.getPuertas();

        puertas.abrirPuertas();
        System.out.println("¿Entrar en el ascensor? (si/no)");
        String decision = sc.nextLine().toLowerCase();

        if (decision.equals("no")) {
            esperarYCerrar(puertas);
            return;
        }

        System.out.println("Entrando al ascensor...");
        puertas.cerrarPuertas();

        while (true) {
            Display.mostrarMenuPisos(totalPisos);
            System.out.print("Seleccione el número del piso al que desea ir: ");
            int destino = sc.nextInt();
            sc.nextLine();

            if (destino < 1 || destino > totalPisos) {
                System.out.println(" Ese piso no existe.");
                continue;
            }

            System.out.println("¿Desea cerrar la puerta ahora? (si/no)");
            String cerrar = sc.nextLine().toLowerCase();
            if (cerrar.equals("no")) {
                esperarYCerrar(puertas);
            } else {
                puertas.cerrarPuertas();
            }

            elevador.moverA(destino);
            puertas.abrirPuertas();

            System.out.println("¿Desea salir del ascensor? (si/no)");
            String salir = sc.nextLine().toLowerCase();
            if (salir.equals("si")) {
                System.out.println("Saliendo del ascensor...");
                break;
            } else {
                System.out.println("Permaneciendo dentro del ascensor...");
            }
        }
    }

    private void esperarYCerrar(Puertas puertas) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        puertas.cerrarPuertas();
    }
}
