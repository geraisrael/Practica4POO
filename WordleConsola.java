/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica4.wordle;

import java.util.Scanner;
/**
 * Esta clase hará el juego wordle en consola.
 * 
 * @author Gerardo G. Vazquez. 
 * @version 3/Mayo/2023
 */


public class WordleConsola {
    private LogicaWordle logica;
    
    public WordleConsola()
    {
        logica = new LogicaWordle();
    }
    
    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a Wordle!");

        while (!logica.isJuegoTerminado()) {
            System.out.println("Vidas restantes: " + logica.getVidas());
            System.out.println("Palabra: "+ logica.getLetrasAdivinadas());
            System.out.println("'letra'" +"Letra adivinada en la posicion correcta.");
            System.out.println("'-'" +"Letra presente pero en posicion incorrecta.");
            System.out.println("'x'" +"Letra que no esta presente en la palabra.");
            System.out.print("Ingresa una palabra: ");
            String palabra = scanner.nextLine();
            
            if(palabra.length() != 5)
            {
                System.out.println("La palabra debe de tener exactamente 5 letras. Intentalo de nuevo.");
                continue; // Esto hará que se repita el bucle y solicitará una nueva palabra al usuario.
            }
            boolean palabraEncontrada = logica.adivinarPalabra(palabra);

            if (palabraEncontrada) {
                System.out.println("Palabra encontrada. Haz ganado!.");
            } else {
                System.out.println("Palabra incorrecta. Pierdes una vida.");
            }
            
            if(logica.getVidas() == 0)
            {
      System.out.println("Has perdido! La palabra era: " + logica.getPalabraAdivinar());
            
            }
            
            
            System.out.println();
        }

    }
}
