package board;

import board.Utils.BoardsManager;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    private static Collection<Collection<Boolean>> boardList;

    @BeforeClass
    public static void setUp(){
        boardList = BoardsManager.getEmptyBoard().getBoardList();
    }

    @Test
    public void createBoardForFirstRound(){
        Board board = new Board(boardList);
        assertEquals(1, board.getRound());
    }

    @Test
    public void createBoardForNthRound(){
        Board board;
        for (int i = 1; i < 15; i++) {
            board = new Board(boardList, i);
            assertEquals(i, board.getRound());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenRoundIsLessThanOne(){
        new Board(boardList, 0);
    }

    @Test
    public void checkBoardsImmutability(){

    }
}