/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerardo.gonzalez.uabc.practica4b.wordle;

import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Font;
/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Square
{
    private int size;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private String texto;
    private char letra;
    
    /**
     * Create a new square at default position with default color.
     */
    public Square(int x, int y)
    {
        size = 40;
        xPosition = x;
        yPosition = y;
        color = "blue";
        isVisible = false;
        texto = "";
    }
    
    public Square(int x, int y, char letra)
    {
        size = 40;
        xPosition = x;
        yPosition = y;
        color = "blue";
        isVisible = false;
        texto = "";
        this.letra = letra;
    }

    public Square()
    {
        size = 40;
        xPosition = 20;
        yPosition = 20;
        color = "blue";
        isVisible = false;
        texto = "";
        letra = 'A';
    }
    
    public void setLetra(char letra)
    {
        this.letra = letra;    
    }
    
    public char getLetra()
    {
        return letra;
    }
    
    public void cambioPosicion(int xPosition, int yPosition)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    
    public void colocarPosicion(int xPosition, int yPosition)
    { 
        erase();
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        draw();
    }
    
    public int getSize()
    {
        return size;
    }
    
    public int getPositionX()
    {
        return xPosition;    
    }
    
    public int getPositionY()
    {
        return yPosition;    
    }
    
    /**
     * Make this square visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Make this square invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    /**
     * Move the square a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the square a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the square a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the square a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the square horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the square vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the square horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the square vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newSize)
    {
        erase();
        size = newSize;
        draw();
    }
    
    public void cambioDeTamaño(float newSize)
    {
       newSize = newSize / 100.0f;
       newSize = newSize * size;
       size = size +(int)newSize;
       draw();
    }
    
    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }
    
        /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    
    public String getColor()
    {
        return color;
    }
    
    /**
     * Draw the square with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                        new Rectangle(xPosition, yPosition, size, size));
            canvas.wait(10);
        }
    }

    /**
     * Erase the square on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    public boolean getIsVisible()
    {
        return isVisible;
    }
    
    public void mostrarLetra() {
        // Dibuja la letra en el cuadrado
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.drawString(String.valueOf(letra), xPosition + size / 2, yPosition + size / 2, "black", size / 2);
        }
    }
    
    public void dibujarTexto(String texto, int x, int y, String color,int tamano)
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.drawString(texto,x,y,color,tamano);
    }
}
