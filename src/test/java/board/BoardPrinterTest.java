package board;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
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

        assertEquals("Contents should be equals", "", printStream.content);
    }

    private class CustomPrintStream extends PrintStream{
        private String content;

        CustomPrintStream(OutputStream out) {
            super(out);
            content = "";
        }

        @Override
        public void print(String s) {
            content += s;
        }

        @Override
        public void println() {
            content += "\n";
        }
    }

    private class CustomOutputStream extends OutputStream {
        public void write(int b) throws IOException {}
    }
}