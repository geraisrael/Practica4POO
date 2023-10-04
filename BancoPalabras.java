/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica4.wordle;

import java.util.ArrayList;
import java.util.Random;
/**
 * Clase que representa el banco de mis palabras a adivinar.
 * 
 * @author Gerardo G. Vazquez. 
 * @version 3/Mayo/2023
 */



public class BancoPalabras {
  private ArrayList<String> palabras;
  
  public BancoPalabras()
  {
      palabras = new ArrayList<String>();
      String[] banco = {"abaco","abeja","babas","bacia","cable","dabas","dando","edita"
        ,"educo","fajas","gafas","nitro","perro","hielo","labio","haber","icono","patas","minas",
        "manos","llave","boxer","boxer","busto","burro","burla","comic","debil","dulce","drama"
        ,"fosil","fumar","fresa","guapo","gusto","huevo","hotel" };
      
      for(String palabra: banco)
      {
          palabras.add(palabra);
      }
  }
  
  /*
   * Verifica si la palabra ingresada coincide con la palabra aleatoria.
   */
  public boolean esPalabraValida(String palabra) {
    return palabras.contains(palabra);
  }

  /*
   * Regresa la palabra aleatoria.
   */
  public String obtenerPalabraAleatoria()
  {
      Random rand = new Random();
      int indice = rand.nextInt(palabras.size());
      return palabras.get(indice);
  }
  
  /*
   * Muestra el banco de palabras.
   */
  public void mostrarPalabras() {
    for (String palabra : palabras) 
    {
      System.out.println(palabra);
    }
  }
}

