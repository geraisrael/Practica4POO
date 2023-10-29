/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerardo.gonzalez.uabc.practica4b.wordle;

import java.util.*;
/**
 * Write a description of class WordleGrafico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordleGrafico
{
    private ArrayList<Square> tablero;
    private ArrayList<Square> teclado;
    private Square texto;
    private LogicaWordle logica;
    private int filaActual = 0;
    
    public WordleGrafico()
    {
        tablero = new ArrayList<>();
        teclado = new ArrayList<>();
        texto = new Square();
        logica = new LogicaWordle();
    }
    
    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a Wordle Grafico!");
        mostrarTablero();
        mostrarTeclado();
        
        while (!logica.isJuegoTerminado()) {
            dibujarLetrasTeclado();
            mostrarTitulo();
            System.out.println("Vidas restantes: " + logica.getVidas());
            System.out.println("'Cuadrado Verde'" +"Letra adivinada en la posicion correcta.");
            System.out.println("'Cuadrado amarrillo'" +"Letra presente pero en posicion incorrecta.");
            System.out.println("'Cuadrado rojo'" +"Letra que no esta presente en la palabra.");
            System.out.print("Ingresa una palabra: ");
            String palabra = scanner.nextLine();
            
            if(palabra.length() != 5)
            {
                System.out.println("La palabra debe de tener exactamente 5 letras. Intentalo de nuevo.");
                continue; // Esto hará que se repita el bucle y solicitará una nueva palabra al usuario.
            }
            boolean palabraEncontrada = logica.adivinarPalabra(palabra);

                if (palabraEncontrada) {
                System.out.println("Palabra encontrada. ¡Has ganado!");
                for (int i = filaActual * 5; i < (filaActual + 1) * 5; i++) {
                    tablero.get(i).changeColor("green");
                }
                
                for (int i = filaActual * 5, j = 0; i < (filaActual + 1) * 5; i++, j++) {
                    
                    tablero.get(i).setLetra(palabra.charAt(j)); // Establece la letra en el cuadrado
                    tablero.get(i).mostrarLetra(); // Muestra la letra en el cuadrado
                }
            } else {
                System.out.println("Palabra incorrecta. Pierdes una vida.");
                String palabraAdivinar = logica.getPalabraAdivinar();
                String letrasAdivinadas = logica.getLetrasAdivinadas();
                for (int i = filaActual * 5; i < (filaActual + 1) * 5; i++) {
                    if (letrasAdivinadas.charAt(i - filaActual * 5) == '-') {
                        tablero.get(i).changeColor("yellow");
                    } else if (letrasAdivinadas.charAt(i - filaActual * 5) == 'x') {
                        tablero.get(i).changeColor("red");
                    } else if(letrasAdivinadas.charAt(i - filaActual * 5) == palabraAdivinar.charAt(i - filaActual * 5)){
                        tablero.get(i).changeColor("green");
                    }
                }
                
                for (int i = filaActual * 5, j = 0; i < (filaActual + 1) * 5; i++, j++) {
                    //tablero.get(i).changeColor("green");
                    tablero.get(i).setLetra(palabra.charAt(j)); // Establece la letra en el cuadrado
                    tablero.get(i).mostrarLetra(); // Muestra la letra en el cuadrado
                }
                
                filaActual++;
                
            }
            dibujarLetrasTeclado();
            mostrarTitulo();
            
            if (logica.getVidas() == 0) {
                System.out.println("Has perdido. La palabra era: " + logica.getPalabraAdivinar());
            }
    
            System.out.println();
        }
    
        filaActual = 0;
        logica.modificarJuego(false);
    }
    
    
    public void mostrarTitulo()
    {
        texto.dibujarTexto("Wordle",190,90,"black",32);    
    }
    
    public void mostrarTablero()
    {
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                int xPos = 120 + (j * 50);
                int yPos = 120 + (i * 50);
                Square cuadrado = new Square(xPos, yPos);
                cuadrado.makeVisible();
                tablero.add(cuadrado);
            }
        }
    }
    
    public void mostrarTeclado() {
        int tecladoX = 100;  // Posición inicial X del teclado
        int tecladoY = 450;  // Posición Y del teclado (más abajo)
        int cuadradoSize = 30;  // Tamaño de cada cuadrado en el teclado
        int espaciadoHorizontal = 5;  // Espacio horizontal entre los cuadrados
        int filas = 3; // Número de filas
        int cuadradosPorFila[] = {10, 9, 8}; // Cantidad de cuadrados en cada fila
        int cuadradosTotales = 0;
        
        String[] letrasAlfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N","O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"};
        
        int letraIndex = 0; // Para llevar un seguimiento de la letra actual
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cuadradosPorFila[i]; j++) {
                int xPos = tecladoX + j * (cuadradoSize + espaciadoHorizontal);
                int yPos = tecladoY + i * (cuadradoSize + espaciadoHorizontal);
                
                if (letraIndex < letrasAlfabeto.length) {
                    Square cuadrado = new Square(xPos, yPos);
                    cuadrado.changeSize(20);
                    cuadrado.setLetra(letrasAlfabeto[letraIndex].charAt(0)); // Establece la letra en el cuadrado
                    cuadrado.makeVisible();
                    teclado.add(cuadrado);
                    letraIndex++; // Avanzar al siguiente índice de letra en el alfabeto
                }
            }
        }
        dibujarLetrasTeclado();
    }   

    public void dibujarLetrasTeclado() {
        for (Square cuadrado : teclado) {
            cuadrado.mostrarLetra();
        }
    }

}

