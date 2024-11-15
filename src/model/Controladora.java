package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora 
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }


    public void jugadaHumano(int i, int j){
        if(!tableroTresEnRaya[i][j].equals("X")){
            tableroTresEnRaya[i][j]= "O";
        } else{
            System.out.println("Disculpe, esa posicion ya esta tomada, por favor intente de nuevo.");
        }
    }

    public void validarGanador(){
        for(int i=0; i<tableroTresEnRaya.length;i++){

            //Gana en fila
            if(tableroTresEnRaya[i][0].equals("X") &&tableroTresEnRaya[i][1].equals("X") && tableroTresEnRaya[i][2].equals("X")){
                System.out.println("Gana la maquina ");
                inicializarTablero(); // Resetear el tablero despues de que alguien gane
            }
            if(tableroTresEnRaya[i][0].equals("O") &&tableroTresEnRaya[i][1].equals("O") && tableroTresEnRaya[i][2].equals("O")){
                System.out.println("Gana el humano");
                inicializarTablero(); // Resetear el tablero despues de que alguien gane
            }

            //Gana en columna
            if(tableroTresEnRaya[0][i].equals("X")&&tableroTresEnRaya[1][i].equals("X")&&tableroTresEnRaya[2][i].equals("X")){
                System.out.println("Gana la maquina ");
                inicializarTablero(); // Resetear el tablero despues de que alguien gane
            }
            if(tableroTresEnRaya[0][i].equals("O")&&tableroTresEnRaya[1][i].equals("O")&&tableroTresEnRaya[2][i].equals("O")){
                System.out.println("Gana el humano ");
                inicializarTablero(); // Resetear el tablero despues de que alguien gane
            }
        }

        //Gana en diagonal de izquierda a derecha
        if(tableroTresEnRaya[0][0].equals("X")&&tableroTresEnRaya[1][1].equals("X")&&tableroTresEnRaya[2][2].equals("X")){
            System.out.println("Gana la maquina ");
            inicializarTablero(); // Resetear el tablero despues de que alguien gane
        }
        if(tableroTresEnRaya[0][0].equals("O")&&tableroTresEnRaya[1][1].equals("O")&&tableroTresEnRaya[2][2].equals("O")){
            System.out.println("Gana el humano ");
            inicializarTablero(); // Resetear el tablero despues de que alguien gane
        }

        //Gana en diagonal de derecha a izquierda
        if(tableroTresEnRaya[0][2].equals("X")&&tableroTresEnRaya[1][1].equals("X")&&tableroTresEnRaya[2][0].equals("X")){
            System.out.println("Gana la maquina ");
            inicializarTablero(); // Resetear el tablero despues de que alguien gane
        }
        if(tableroTresEnRaya[0][2].equals("O")&&tableroTresEnRaya[1][1].equals("O")&&tableroTresEnRaya[2][0].equals("O")){
            System.out.println("Gana el humano ");
            inicializarTablero(); // Resetear el tablero despues de que alguien gane
        }
        
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }
}