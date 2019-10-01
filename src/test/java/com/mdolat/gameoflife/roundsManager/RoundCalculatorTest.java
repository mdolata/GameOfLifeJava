package com.mdolat.gameoflife.roundsManager;

import com.mdolat.gameoflife.board.Board;
import com.mdolat.gameoflife.board.BoardValidation;
import com.mdolat.gameoflife.roundsManager.strategies.ClassicConway;
import com.mdolat.gameoflife.utils.BoardsManager;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class RoundCalculatorTest {

    @Test
    public void boardShouldBeValidInNextRound() {
        RoundCalculator roundCalculator = new RoundCalculator(new ClassicConway());
        Board boardNo3 = BoardsManager.getBoardNo3();
        Board receivedBoard = roundCalculator.calculateNextRound(boardNo3);

        assertTrue(BoardValidation.isValid(receivedBoard));
    }

    @Test
    public void roundInNextRoundShouldBeBiggerByOne() {
        RoundCalculator roundCalculator = new RoundCalculator(new ClassicConway());
        Board boardNo3 = BoardsManager.getBoardNo3();
        Board receivedBoard = roundCalculator.calculateNextRound(boardNo3);

        assertEquals(boardNo3.getRound() + 1, receivedBoard.getRound());
    }

    @Test
    public void boardSizeShouldBeTheSameInNextRound() {
        RoundCalculator roundCalculator = new RoundCalculator(new ClassicConway());
        Board boardNo3 = BoardsManager.getBoardNo3();
        Board receivedBoard = roundCalculator.calculateNextRound(boardNo3);

        assertEquals(boardNo3.getBoardList().size(), receivedBoard.getBoardList().size());

        int boardNo3InnerListSize = getInnerListSize(boardNo3);
        int receivedBoardInnerListSize = getInnerListSize(receivedBoard);

        assertEquals(boardNo3InnerListSize, receivedBoardInnerListSize);
    }

    private int getInnerListSize(Board boardNo3) {
        return boardNo3.getBoardList().stream().mapToInt(Collection::size).findFirst().orElse(0);
    }
}