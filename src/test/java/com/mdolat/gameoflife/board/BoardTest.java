package com.mdolat.gameoflife.board;

import com.mdolat.gameoflife.utils.BoardsManager;
import io.vavr.collection.List;
import io.vavr.control.Either;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BoardTest {

    private final List<List<Boolean>> boardList = BoardsManager.getEmptyBoard().getBoardList();

    @Test
    public void shouldCreateBoardWithFirstRound() {
        Either<ErrorMessage, Board> board = Board.of(boardList);
        assertEquals(1, board.get().getRound());
    }

    @Test
    public void createBoardForNthRound() {
        Either<ErrorMessage, Board> board;
        for (int i = 1; i < 15; i++) {
            board = Board.of(boardList, i);
            assertEquals(i, board.get().getRound());
        }
    }

    @Test
    public void shouldReturnLeftWithErrorMessage() {
        Either<ErrorMessage, Board> boardEither = Board.of(boardList, 0);

        Assert.assertTrue(boardEither.isLeft());
        Assert.assertEquals(boardEither.getLeft(), ErrorMessage.of("round should be over 0"));
    }
}