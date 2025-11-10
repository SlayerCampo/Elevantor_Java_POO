public class Display {
    public static void mostrarMenuPisos(int total) {
        System.out.println("\n--- TABLERO DE PISOS ---");
        for (int i = 1; i <= total; i++) {
            System.out.print("[ " + i + " ] ");
        }
        System.out.println("\n-------------------------");
    }

    public static void mostrarPisoActual(int piso) {
        System.out.println(" Piso actual: " + piso);
    }
}
