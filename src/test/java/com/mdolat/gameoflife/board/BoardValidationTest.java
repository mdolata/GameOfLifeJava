package com.mdolat.gameoflife.board;

import com.mdolat.gameoflife.utils.BoardsManager;
import io.vavr.collection.List;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardValidationTest {

    @Test
    public void shouldReturnTrueForCorrectBoard() {
        assertTrue(BoardValidation.isValid(BoardsManager.getEmptyBoard()));
        assertTrue(BoardValidation.isValid(BoardsManager.getBoardNo1()));
        assertTrue(BoardValidation.isValid(BoardsManager.getBoardNo2()));
        assertTrue(BoardValidation.isValid(BoardsManager.getBoardNo3()));
    }

    @Test
    public void shouldReturnFalseForIncorrectBoard() {
        Boolean[] booleans1 = {true, false, true, false, true, false, true, false};
        Boolean[] booleans2 = {true, false, true, false, true, false, true};
        List<Boolean> list1 = List.of(booleans1);
        List<Boolean> list2 = List.of(booleans2);
        Board board = Board.of(List.of(list1, list2));

        assertFalse(BoardValidation.isValid(board));
    }
}