package com.mdolat.gameoflife.roundsManager;

import com.mdolat.gameoflife.board.Board;
import com.mdolat.gameoflife.board.BoardValidation;
import com.mdolat.gameoflife.board.ErrorMessage;
import com.mdolat.gameoflife.roundsManager.strategies.ClassicConway;
import com.mdolat.gameoflife.utils.BoardsManager;
import io.vavr.collection.Traversable;
import io.vavr.control.Either;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoundCalculatorTest {

    @Test
    public void boardShouldBeValidInNextRound() {
        RoundCalculator roundCalculator = new RoundCalculator(new ClassicConway());
        Board boardNo3 = BoardsManager.getBoardNo3();
        Either<ErrorMessage, Board> receivedBoard = roundCalculator.calculateNextRound(boardNo3);

        assertTrue(BoardValidation.isValid(receivedBoard.get()));
    }

    @Test
    public void roundInNextRoundShouldBeBiggerByOne() {
        RoundCalculator roundCalculator = new RoundCalculator(new ClassicConway());
        Board boardNo3 = BoardsManager.getBoardNo3();
        Either<ErrorMessage, Board> receivedBoard = roundCalculator.calculateNextRound(boardNo3);

        assertEquals(boardNo3.getRound() + 1, receivedBoard.get().getRound());
    }

    @Test
    public void boardSizeShouldBeTheSameInNextRound() {
        RoundCalculator roundCalculator = new RoundCalculator(new ClassicConway());
        Board boardNo3 = BoardsManager.getBoardNo3();
        Either<ErrorMessage, Board> receivedBoard = roundCalculator.calculateNextRound(boardNo3);

        assertEquals(boardNo3.getBoardList().size(), receivedBoard.get().getBoardList().size());

        int boardNo3InnerListSize = getInnerListSize(boardNo3);
        int receivedBoardInnerListSize = getInnerListSize(receivedBoard.get());

        assertEquals(boardNo3InnerListSize, receivedBoardInnerListSize);
    }

    private int getInnerListSize(Board boardNo3) {
        return boardNo3.getBoardList().toJavaStream().mapToInt(Traversable::size).findFirst().orElse(0);
    }
}