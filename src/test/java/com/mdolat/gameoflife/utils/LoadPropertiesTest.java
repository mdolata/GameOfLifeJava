package com.mdolat.gameoflife.utils;

import com.mdolat.gameoflife.board.BoardPrinter;
import com.mdolat.gameoflife.board.Utils.BoardsManager;
import com.mdolat.gameoflife.board.Utils.CustomOutputStream;
import com.mdolat.gameoflife.board.Utils.CustomPrintStream;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoadPropertiesTest {

    private BoardPrinter boardPrinter;
    private CustomPrintStream printStream;

    @Before
    public void setUp(){
        CustomOutputStream out = new CustomOutputStream();
        printStream = new CustomPrintStream(out);
        boardPrinter = new BoardPrinter(printStream);
    }

    @Test
    public void checkIfBoardPrinterFieldsAreSet(){
        boardPrinter.printBoard(BoardsManager.getBoardNo1());
        String content = printStream.getContent();

        assertTrue(content.contains(boardPrinter.getHumanForCellState(true)));
        assertFalse(content.contains(boardPrinter.getHumanForCellState(false)));
    }

}