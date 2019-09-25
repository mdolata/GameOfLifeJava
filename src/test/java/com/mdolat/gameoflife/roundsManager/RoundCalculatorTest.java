package com.mdolat.gameoflife.roundsManager;

import com.mdolat.gameoflife.board.Board;
import com.mdolat.gameoflife.board.BoardValidation;
import com.mdolat.gameoflife.testUtils.BoardsManager;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class RoundCalculatorTest {

    @Test
    public void boardShouldBeValidInNextRound() {
        RoundCalculator roundCalculator = new RoundCalculator();
        Board boardNo3 = BoardsManager.getBoardNo3();
        Board receivedBoard = roundCalculator.calculateNextRound(boardNo3);

        assertTrue(BoardValidation.isValid(receivedBoard));
    }

    @Test
    public void roundInNextRoundShouldBeBiggerByOne() {
        RoundCalculator roundCalculator = new RoundCalculator();
        Board boardNo3 = BoardsManager.getBoardNo3();
        Board receivedBoard = roundCalculator.calculateNextRound(boardNo3);

        assertEquals(boardNo3.getRound() + 1, receivedBoard.getRound());
    }

    @Test
    public void boardSizeShouldBeTheSameInNextRound() {
        RoundCalculator roundCalculator = new RoundCalculator();
        Board boardNo3 = BoardsManager.getBoardNo3();
        Board receivedBoard = roundCalculator.calculateNextRound(boardNo3);

        assertEquals(boardNo3.getBoardList().size(), receivedBoard.getBoardList().size());

        int boardNo3InnerListSize = getInnerListSize(boardNo3);
        int receivedBoardInnerListSize = getInnerListSize(receivedBoard);

        assertEquals(boardNo3InnerListSize, receivedBoardInnerListSize);
    }

    @Test
    public void checkNeighborAllDeath(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 1, 1);
        int expected = 0;
        assertEquals(expected, count);
    }

    //todo parametrize tests
    @Test
    public void checkNeighbor1(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {true, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor1Torus(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, false ,false, false},
                {false, false, false, true}};

        int count = roundCalculator.countAliveNeighbor(booleans, 0, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor2(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false, true ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor2Torus(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, false ,false, false},
                {true, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 0, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor3(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, true, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor3Torus(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, false ,false, false},
                {false, true, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 0, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor4(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, false, false},
                {true, false ,false, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor4Torus(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, true},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 0, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor6(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, false, false},
                {false, false ,true, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor6Torus(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {true, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 0, 3);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor7(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, false, false},
                {false, false ,false, false},
                {true, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor7Torus(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, true},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 2, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor8(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, false, false},
                {false, false ,false, false},
                {false, true, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor8Torus(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {true, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 2, 0);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor9(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {false ,false, false, false},
                {false, false ,false, false},
                {false, false, true, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 1, 1);
        int expected = 1;

        assertEquals(expected, count);
    }

    @Test
    public void checkNeighbor9Torus(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Boolean[][] booleans = new Boolean[][]{
                {true, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        int count = roundCalculator.countAliveNeighbor(booleans, 2, 3);
        int expected = 1;

        assertEquals(expected, count);
    }
    private int getInnerListSize(Board boardNo3) {
        return boardNo3.getBoardList().stream().mapToInt(Collection::size).findFirst().orElse(0);
    }
}