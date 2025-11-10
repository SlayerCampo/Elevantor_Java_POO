public class Puertas {
    private boolean abiertas = false;

    public void abrirPuertas() {
        System.out.println(" Puertas abriéndose...");
        abiertas = true;
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {}
        System.out.println("Puertas abiertas.");
    }

    public void cerrarPuertas() {
        System.out.println(" Puertas cerrándose...");
        abiertas = false;
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {}
        System.out.println("Puertas cerradas.");
    }

    public boolean estanAbiertas() {
        return abiertas;
    }
}
