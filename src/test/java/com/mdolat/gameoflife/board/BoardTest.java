package com.mdolat.gameoflife.board;

import com.mdolat.gameoflife.utils.BoardsManager;
import io.vavr.collection.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BoardTest {

    private List<List<Boolean>> boardList = BoardsManager.getEmptyBoard().getBoardList();

    @Test
    public void shouldCreateBoardWithFirstRound() {
        Board board = Board.of(boardList);
        assertEquals(1, board.getRound());
    }

    @Test
    public void createBoardForNthRound() {
        Board board;
        for (int i = 1; i < 15; i++) {
            board = Board.of(boardList, i);
            assertEquals(i, board.getRound());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenRoundIsLessThanOne() {
        Board.of(boardList, 0);
    }
}