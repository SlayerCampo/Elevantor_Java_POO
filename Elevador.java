public class Elevador {
    private int pisoActual;
    private int totalPisos;
    private Puertas puertas;
    private Direccion direccion;

    public Elevador(int totalPisos) {
        this.totalPisos = totalPisos;
        this.pisoActual = 1; // el ascensor siempre inicia en el primer piso
        this.puertas = new Puertas();
        this.direccion = Direccion.QUIETO;
    }

    public Puertas getPuertas() {
        return puertas;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void llamarAscensor(Pisos piso) {
        System.out.println(" Botón presionado (" + piso.getNombreBoton() + ")");
        System.out.println("Ascensor llegando al piso " + piso.getNumero() + "...");
        piso.apagarBotones();
    }

    public void moverA(int destino) {
        if (destino == pisoActual) {
            System.out.println("Ya estás en el piso " + destino);
            return;
        }

        direccion = destino > pisoActual ? Direccion.SUBIENDO : Direccion.BAJANDO;
        System.out.println("🚪 Puertas cerradas.");
        System.out.println(direccion == Direccion.SUBIENDO ? "⬆ Subiendo..." : "⬇ Bajando...");

        int paso = direccion == Direccion.SUBIENDO ? 1 : -1;
        while (pisoActual != destino) {
            pisoActual += paso;
            Display.mostrarPisoActual(pisoActual);
            try {
                Thread.sleep(1000); // velocidad de movimiento
            } catch (InterruptedException e) {}
        }

        System.out.println("📍 Llegaste al piso " + pisoActual + ".");
        direccion = Direccion.QUIETO;
    }
}
