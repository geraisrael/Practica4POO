/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica4.wordle;

import java.io.IOException;
/**
 * Esta clase se encargará del control lógicologico del juego.
 * 
 * @author Gerardo G. Vazquez.
 * @version 3/Mayo/2023
 */


public class LogicaWordle {
    private BancoPalabras bancoPalabras;
    private String palabraAdivinar;
    private int vidas;
    private char[] letrasAdivinadas;
    private boolean juegoTerminado;

    
    public LogicaWordle() {
        bancoPalabras = new BancoPalabras();
        vidas = 6;
        juegoTerminado = false;
        inicializarJuego();
    }
    
    /*
     *  Metodo que asigna la palabra alearotia. 
     */
    public void inicializarJuego() {
        palabraAdivinar = bancoPalabras.obtenerPalabraAleatoria();
        letrasAdivinadas = new char[palabraAdivinar.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }
    }

    /*
     * Metodo que verifica si la palabra coincide con la palabra aleatoria.
     */
    public boolean adivinarPalabra(String palabra) {
        boolean palabraEncontrada = true; // Suponemos inicialmente que la palabra está encontrada
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            if (palabraAdivinar.charAt(i) == palabra.charAt(i)) {
                letrasAdivinadas[i] = palabra.charAt(i); // Asignamos la letra adivinada en la posición correcta
            } else {
                palabraEncontrada = false; // Si hay una letra que no coincide, la palabra no está encontrada
                if (palabraAdivinar.indexOf(palabra.charAt(i)) != -1) {
                    letrasAdivinadas[i] = '-'; // Letra presente pero en posición incorrecta
                } else {
                    letrasAdivinadas[i] = 'x'; // Letra no presente en la palabra
                }
            }
        }
    
        if (!palabraEncontrada) {
            vidas--;
        }
    
        if (vidas <= 0 || palabraEncontrada) {
            juegoTerminado = true;
        }
        return palabraEncontrada;
    }

    /*
     * getter para el atributo que indica si el juego termino.
     */
    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    /*
     * getter para las vidas.
     */
    public int getVidas() {
        return vidas;
    }

    /*
     * getter la palabra aleatoria.
     */
    public String getPalabraAdivinar() {
        return palabraAdivinar;
    }

    /*
     * getter para las letras adivinadas.
     */
    public String getLetrasAdivinadas() {
        return new String(letrasAdivinadas);
    }
}


