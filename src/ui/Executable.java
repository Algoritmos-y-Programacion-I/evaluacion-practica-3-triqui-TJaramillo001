package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner in;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        in = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {

        flag = false;

        while (!flag) {

            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + "1. Imprimir tablero \n" + "2. Jugada de la máquina \n"
                    + "3. Jugada de humano \n" + "4. Verificar ganador \n" + "5. Salir del programa \n");

            int option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }

        }

    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La máquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
        System.out.println("Por favor ingrese la posicion en la que desea ingresar su jugada");
        System.out.println("Fila:");
        int fila = in.nextInt()-1;
        in.nextLine();

        System.out.println("Columna:");
        int columna = in.nextInt()-1;

        cont.jugadaHumano(fila, columna);
        imprimirTablero();

    }

    private void validarGanador() {
        cont.validarGanador();
    }
}