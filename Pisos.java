public class Pisos {
    private int numero;
    private Botones botonArriba;
    private Botones botonAbajo;

    public Pisos(int numero, int totalPisos) {
        this.numero = numero;

        if (numero == 1) {
            botonArriba = new Botones("Subir");
        } else if (numero == totalPisos) {
            botonAbajo = new Botones("Bajar");
        } else {
            botonArriba = new Botones("Subir");
            botonAbajo = new Botones("Bajar");
        }
    }

    public void mostrarOpciones() {
        System.out.println("Piso " + numero + ":");
        if (botonArriba != null) System.out.println(" Escriba 'subir' para subir.");
        if (botonAbajo != null) System.out.println(" Escriba 'bajar' para bajar.");
    }

    public String getNombreBoton() {
        if (botonArriba != null && botonArriba.isEncendido()) return "Subir";
        if (botonAbajo != null && botonAbajo.isEncendido()) return "Bajar";
        return "Ninguno";
    }

    public int getNumero() {
        return numero;
    }

    public void apagarBotones() {
        if (botonArriba != null) botonArriba.apagar();
        if (botonAbajo != null) botonAbajo.apagar();
    }
}
