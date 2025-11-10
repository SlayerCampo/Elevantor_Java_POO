import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al edificio UCC");
        System.out.print("Por favor, ingrese el número de pisos del edificio: ");
        int pisos = sc.nextInt();
        sc.nextLine(); 

        Edificio edificio = new Edificio(pisos);
        edificio.iniciar();
    }
}


