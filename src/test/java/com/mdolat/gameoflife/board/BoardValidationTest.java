package com.mdolat.gameoflife.board;

import com.mdolat.gameoflife.board.Utils.BoardsManager;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardValidationTest {

    @Test
    public void shouldReturnTrueForCorrectBoard(){
        assertTrue(BoardValidation.isValid(BoardsManager.getEmptyBoard()));
        assertTrue(BoardValidation.isValid(BoardsManager.getBoardNo1()));
        assertTrue(BoardValidation.isValid(BoardsManager.getBoardNo2()));
        assertTrue(BoardValidation.isValid(BoardsManager.getBoardNo3()));
    }

    @Test
    public void shouldReturnFalseForIncorrectBoard(){
        Boolean[] booleans1 = {true, false, true, false, true, false, true, false};
        Boolean[] booleans2 = {true, false, true, false, true, false, true};
        ImmutableList<Boolean> list1 = ImmutableList.copyOf(booleans1);
        ImmutableList<Boolean> list2 = ImmutableList.copyOf(booleans2);
        Board board = new Board(ImmutableList.of(list1, list2));

        assertFalse(BoardValidation.isValid(board));
    }
}