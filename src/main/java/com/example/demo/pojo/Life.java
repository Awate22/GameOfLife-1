package com.example.demo.pojo;

import lombok.Getter;

@Getter
public class Life {
    private final int ROWS = 20;
    private final int COLS = 80;
    private final int TIME_DELAY = 1000;


    public void runGame() {


        Board board = new Board(getROWS(), getCOLS());
        Board nextBoard = new Board(getROWS(), getCOLS());
        initialzeBoard(board);
        for (int i = 0; i < 110; i++) {
            clearConsole();
            displayBoard(board);
            slow(getTIME_DELAY());
            rules(board, nextBoard);
            transferNextToCurrent(board, nextBoard);


        }
    }



    /**
     * Denna startbräda metod The intializeBoard static method sets up the initial board with a
     * random set of cells.
     */

    public void initialzeBoard(Board b) {

        for (int r = 0; r < ROWS; r++) {

            for (int c = 0; c < COLS; c++) {

                int value = (int) (Math.random() * 4); // kmr ge mig ett random nummer
                if (value == 0) { // 1/4 för att få en levande cell

                    b.set(r, c, 1);
                }
            }

        }

    }


    /**
     * DisplayBoard-metoden visar tavlan på skärmen. En bräda
     *  är en 2-dimensionell int[][] array, så för att displayen ska inkludera andra
     *  tecken--"." och "0", till exempel--tecken måste skrivas ut
     *  på skärmen efter att ha kontrollerat int-värdet för den platsen.
     * @param board the board to be displayed
     */

    public void displayBoard(Board board) {

        for (int r = 0; r < ROWS; r++) {

            for (int c = 0; c < COLS; c++) {

                if (board.get(r, c) == 0) {
                    System.out.print(".");

                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    /**
     * The rules method takes the current board and
     * a new (empty) board and calculates the next generation for that second
     * board based on the standard rules of Conway's Life:
     * 1. existing cell dies if fewer than 2 neighbors (underpopulation)
     * 2. existing cell lives if 2-3 neighbors ("these neighbors are JUST RIGHT!")
     * 3. existing cell dies if greater than 3 neighbors (overpopulation)
     * 4. empty cell becomes alive if exactly 3 neighbors (because...?)
     *
     * @param b the current board
     * @param nextB a board with the new generation on it
     */

    /**
     * we are going to go through every cell in this b apply this rules
     * and then set this cell for the next board
     *
     * @return
     */

    public int rules(Board b, Board nextB) {
        for (int r = 0; r < ROWS; r++) {

            for (int c = 0; c < COLS; c++) {
                int neighborCount = countNeighbors(r, c, b);

                if (b.get(r, c) == 1 && neighborCount < 2) {
                    nextB.set(r, c, 0);
                } else if (b.get(r, c) == 1 && neighborCount < 4) {
                    nextB.set(r, c, 1);
                } else if (b.get(r, c) == 1 && neighborCount > 3) {
                    nextB.set(r, c, 0);
                } else if (b.get(r, c) == 0 && neighborCount == 3) {
                    nextB.set(r, c, 1);
                    ;
                } else {
                    nextB.set(r, c, 0);
                }

            }
        }

        return 0;
    }


    /**
     * metoden countNeighbors räknar de åtta cellerna runt en given
     * cell, se till att inte räkna utanför gränserna för arrayen och
     * att inte räkna den aktuella cellen själv!
     *
     * @param row raden i den aktuella cellen
     * @param col kolumnen för den aktuella cellen
     * @param b   styrelsen vi undersöker
     * @return antalet grannar som inte är noll (minst 0, max 8)
     */


    public int countNeighbors(int row, int col, Board b) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >= 0 && r < ROWS &&
                        c >= 0 && c < COLS &&
                        !(r == row && c == col) &&
                        b.get(r, c) == 1) {
                    count++;
                }
            }

        }
        return count;
    }


    /**
     * Metoden transferNextToCurrent tar brädan med
     *  nästa generation och kopierar den till brädan för denna generation så
     *  att vi kan fortsätta visa och analysera generationer.
     *
    * @param board den nuvarande styrelsen som vi kommer att kopiera till
     * @param nextBoard nästa tavla som innehåller en beräknad ny generation
     */

    public void transferNextToCurrent(Board board, Board nextBoard) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board.set(r, c, nextBoard.get(r, c));
            }
        }
        System.out.println("\n");
    }

    /**
     * ClearConsole-metoden försöker rensa terminalen så att
     * successiva generationer av tavlan kan visas
     */
    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void slow(int TIME_DELAY) {
        // Sleep for some amount of time to slow display down
        try {
            Thread.sleep(TIME_DELAY);
            // TIME_DELAY is an integer in milliseconds
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


    }

}
