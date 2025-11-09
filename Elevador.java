public class Elevador {
    private boolean puertasAbiertas;
    private int pisoActual;

    public Elevador() {
        this.puertasAbiertas = false;
        this.pisoActual = 1; // Siempre inicia en el primer piso
    }

    public void abrirPuertas() {
        System.out.println("\n La puerta del ascensor se está abriendo...");
        esperar(2000);
        puertasAbiertas = true;
        System.out.println(" Puertas completamente abiertas.");
        preguntarEntrada();
    }

    private void preguntarEntrada() {
        System.out.println("\n¿Desea entrar al ascensor? (si / no)");
        java.util.Scanner input = new java.util.Scanner(System.in);
        String respuesta = input.nextLine().toLowerCase();

        if (respuesta.equals("si")) {
            System.out.println("🚶‍♂️ Entrando al ascensor...");
            esperar(1500);
            System.out.println(" Usted está dentro del ascensor.");




            // En la siguiente fase vendrá la elección de piso
        } else if (respuesta.equals("no")) {
            System.out.println(" Esperando 10 segundos antes de cerrar...");
            esperar(10000);
            cerrarPuertas();
        } else {
            System.out.println(" Respuesta no válida. Intente de nuevo.");
            preguntarEntrada();
        }
    }

    public void cerrarPuertas() {
        System.out.println("\n Ascensor cerrándose...");
        esperar(2000);
        puertasAbiertas = false;
        System.out.println(" Puertas cerradas.");
        System.out.println("\n Puede volver a 'oprimir boton para arriba' para llamar al ascensor nuevamente.");
    }

    private void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
