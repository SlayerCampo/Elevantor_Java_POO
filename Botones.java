public class Botones {
    private String tipo;
    private boolean encendido = false;

    public Botones(String tipo) {
        this.tipo = tipo;
    }

    public void presionar() {
        encendido = true;
        System.out.println(" Botón de " + tipo + " encendido.");
        reproducirSonido();
    }

    public void apagar() {
        encendido = false;
        System.out.println("💤 Botón de " + tipo + " apagado.");
    }

    public boolean isEncendido() {
        return encendido;
    }

    private void reproducirSonido() {
        System.out.println(" *Sonido de botón*");
    }
}
