package roundsManager;

import board.Board;
import board.BoardValidation;
import board.Utils.BoardsManager;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class RoundCalculatorTest {

    //TODO refactor this test
    //split to few smaller tests
    @Test
    public void calculateBoardIsValidAndHasTheSameSizeAfter(){
        RoundCalculator roundCalculator = new RoundCalculator();
        Board boardNo3 = BoardsManager.getBoardNo3();
        Board receivedBoard = roundCalculator.calculateNextRound(boardNo3);

        assertTrue(BoardValidation.isValid(receivedBoard));
        assertEquals(boardNo3.getRound() + 1, receivedBoard.getRound());
        assertEquals(boardNo3.getBoardList().size(), receivedBoard.getBoardList().size());

        int boardNo3InnerListSize = getInnerListSize(boardNo3);
        int receivedBoardInnerListSize = getInnerListSize(receivedBoard);

        assertEquals(boardNo3InnerListSize, receivedBoardInnerListSize);
    }

    private int getInnerListSize(Board boardNo3) {
        return boardNo3.getBoardList().stream().mapToInt(Collection::size).findFirst().orElse(0);
    }
}