package com.example.demo.pojo;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;


class LifeTest {


    @Test
    void initializeBoardAndInitializeRight() {

        /**
         *Testa att den initieras och testade att den initierades rätt
         */


        Board b = new Board(3, 3);
        b.set(0, 0, 1);
        b.set(0, 1, 1);
        b.set(0, 2, 1);
        b.set(1, 0, 1);
        b.set(1, 1, 1);
        b.set(1, 2, 1);
        b.set(2, 0, 1);
        b.set(2, 1, 0);
        b.set(2, 2, 0);

        Life l = new Life();

        assertEquals(6, l.countNeighbors(1, 1, b));
        assertEquals(4, l.countNeighbors(1, 0, b));


    }


    @Test
    void testIfOnly1dies() {




        Board b = new Board(20, 80);
        b.set(0, 0, 1);
        b.set(0, 1, 0);
        b.set(0, 2, 1);
        b.set(1, 0, 1);
        b.set(1, 1, 0);
        b.set(1, 2, 0);
        b.set(2, 0, 1);
        b.set(2, 1, 0);
        b.set(2, 2, 1);

        Board nextB = new Board(20, 80);


        Life life = new Life();


        assertEquals(1, b.get(2, 0));

        life.rules(b, nextB);
        life.transferNextToCurrent(b, nextB);

        assertEquals(0, nextB.get(2, 0));


    }


    @Test
    void testAllCellsDie() {


        Board b = new Board(20, 80);
        b.set(0, 0, 1);
        b.set(0, 1, 0);
        b.set(0, 2, 1);
        b.set(1, 0, 0);
        b.set(1, 1, 0);
        b.set(1, 2, 0);
        b.set(2, 0, 1);
        b.set(2, 1, 0);
        b.set(2, 2, 1);

        Board nextB = new Board(20, 80);


        Life life = new Life();

        assertEquals(1, b.get(0, 0));
        assertEquals(0, b.get(1, 1));

        life.rules(b, nextB);
        life.transferNextToCurrent(b, nextB);

        assertEquals(0, nextB.get(0, 0));
        assertEquals(0, nextB.get(1, 1));


    }

}

