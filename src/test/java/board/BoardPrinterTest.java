package board;

import board.Utils.CustomOutputStream;
import board.Utils.CustomPrintStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class BoardPrinterTest {

    @Test
    public void checkPrintCorrectness(){
        CustomPrintStream printStream = new CustomPrintStream(new CustomOutputStream());
        BoardPrinter boardPrinter = new BoardPrinter(printStream);

        ArrayList<Collection<Boolean>> arrayList = new ArrayList<>();

        Board board = new Board(arrayList);

        boardPrinter.printBoard(board);

        assertEquals("Contents should be equals", "", printStream.getContent());
    }

}