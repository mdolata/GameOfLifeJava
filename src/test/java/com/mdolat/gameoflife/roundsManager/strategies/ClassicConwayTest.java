package com.mdolat.gameoflife.roundsManager.strategies;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassicConwayTest {

    ClassicConway gameStrategy = new ClassicConway();

    @Test
    public void checkNeighborAllDeath(){
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 1, 1);
        int expected = 0;
        assertEquals(expected, count);
    }

    //todo parametrize tests
    @Test
    public void checkNeighbor1(){
        Boolean[][] booleans = new Boolean[][]{
                {true, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor1Torus(){
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, false ,false, false},
                {false, false, false, true}};

        int count = gameStrategy.countAliveNeighbor(booleans, 0, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor2(){
        Boolean[][] booleans = new Boolean[][]{
                {false, true ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor2Torus(){
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, false ,false, false},
                {true, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 0, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor3(){
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, true, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor3Torus(){
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, false ,false, false},
                {false, true, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 0, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor4(){
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, false, false},
                {true, false ,false, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor4Torus(){
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, true},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 0, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor6(){
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, false, false},
                {false, false ,true, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor6Torus(){
        Boolean[][] booleans = new Boolean[][]{
                {true, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 0, 3);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor7(){
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, false, false},
                {false, false ,false, false},
                {true, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor7Torus(){
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, true},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 2, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor8(){
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, false, false},
                {false, false ,false, false},
                {false, true, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor8Torus(){
        Boolean[][] booleans = new Boolean[][]{
                {true, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 2, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor9(){
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, false, false},
                {false, false ,false, false},
                {false, false, true, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor9Torus(){
        Boolean[][] booleans = new Boolean[][]{
                {true, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = gameStrategy.countAliveNeighbor(booleans, 2, 3);
        int expected = 1;

        assertEquals(expected, count);
    }
}
