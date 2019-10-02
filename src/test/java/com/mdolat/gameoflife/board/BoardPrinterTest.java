package com.mdolat.gameoflife.board;

import com.mdolat.gameoflife.utils.BoardsManager;
import com.mdolat.gameoflife.utils.CustomOutputStream;
import com.mdolat.gameoflife.utils.CustomPrintStream;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//todo parametrize tests
public class BoardPrinterTest {

    private BoardPrinter boardPrinter;
    private CustomPrintStream printStream;

    @Before
    public void setUp() {
        printStream = new CustomPrintStream(new CustomOutputStream());
        boardPrinter = new BoardPrinter(new Symbols("#", "0"), printStream);
    }

    @Test
    public void checkPrintCorrectnessForEmptyBoard() {
        boardPrinter.printBoard(BoardsManager.getEmptyBoard());

        assertEquals(BoardsManager.EMPTY_BOARD, printStream.getContent());
    }

    @Test
    public void checkPrintCorrectnessForBoardNo1() {
        boardPrinter.printBoard(BoardsManager.getBoardNo1());

        assertEquals("Contents should be equals", BoardsManager.BOARD_1, printStream.getContent());
    }

    @Test
    public void checkPrintCorrectnessForBoardNo2() {
        boardPrinter.printBoard(BoardsManager.getBoardNo2());

        assertEquals("Contents should be equals", BoardsManager.BOARD_2, printStream.getContent());
    }

    @Test
    public void checkPrintCorrectnessForBoardNo3() {
        boardPrinter.printBoard(BoardsManager.getBoardNo3());

        assertEquals("Contents should be equals", BoardsManager.BOARD_3, printStream.getContent());
    }

    @Test
    public void checkPrintRoundCorrectnessForBoardNo3() {
        boardPrinter.printActualRound(BoardsManager.getBoardNo3());

        assertEquals("Contents should be equals", "1\n", printStream.getContent());
    }
}