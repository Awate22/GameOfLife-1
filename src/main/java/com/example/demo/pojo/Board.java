package com.example.demo.pojo;



public class Board {

/**skapar int array med en serie av rader och varje
* rad kommer att ha en serie kolumner
* så det gör den till en tvådimensionell array
*/
    int[][] b;


    /**
     *
     *  En konstruktor för object av klassen board som är tom och av storlek rows x cols
     *
     */
    public Board(int rows, int cols) {
        // initiera instans variabler - rows måste vara först när man initierar den.

        b = new int[rows][cols];


    }


    /**
     * Get-metoden returnerar värdet på boarden som är lagrat vid det angivna
     * rad, kol plats.
     */


    public int get(int row, int col) {
        return b[row][col];
    }


    /**
     * Void för att vi inte kommer returnera nåt
     * Metoden ställer in den angivna platsen för rad, kol
     * som kmr ge cellens  angivna värdet
     */


    public void set(int row, int col, int value) {
        b[row][col] = value;
    }


    /**
     * Metoden getrows returnerar antalet rader
     * inga () efter length gäller ba om de va en string
     */

    public int getRows() {
        return b.length;
    }


    /**
     * Metoden getCols returnerar antalet kolumner(bredden)
     * går in i rad 0 o hämtar längden i den kolumnen
     */


    public int getCols() {
        return b[0].length;
    }



}