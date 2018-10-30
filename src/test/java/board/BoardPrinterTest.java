package board;

import board.Utils.BoardsManager;
import board.Utils.CustomOutputStream;
import board.Utils.CustomPrintStream;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardPrinterTest {

    private BoardPrinter boardPrinter;
    private CustomPrintStream printStream;

    @Before
    public void setUp(){
        CustomOutputStream out = new CustomOutputStream();
        printStream = new CustomPrintStream(out);
        boardPrinter = new BoardPrinter(printStream);
    }

    @Test
    public void checkPrintCorrectnessForEmptyBoard(){
        boardPrinter.printBoard(BoardsManager.getEmptyBoard());

        assertEquals(BoardsManager.EMPTY_BOARD, printStream.getContent());
    }

    @Test
    public void checkPrintCorrectnessForBoardNo1(){
        boardPrinter.printBoard(BoardsManager.getBoardNo1());

        assertEquals("Contents should be equals", BoardsManager.BOARD_1, printStream.getContent());
    }

    @Test
    public void checkPrintCorrectnessForBoardNo2(){
        boardPrinter.printBoard(BoardsManager.getBoardNo2());

        assertEquals("Contents should be equals", BoardsManager.BOARD_2, printStream.getContent());
    }

    @Test
    public void checkPrintCorrectnessForBoardNo3(){
        boardPrinter.printBoard(BoardsManager.getBoardNo3());

        assertEquals("Contents should be equals", BoardsManager.BOARD_3, printStream.getContent());
    }
}