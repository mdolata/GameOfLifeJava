package board;

import java.io.PrintStream;
import java.util.Collection;

public class BoardPrinter {

    //TODO create load constants from properties file
    private static final String LIVE_CELL = "#";
    //TODO create load constants from properties file
    private static final String DEATH_CELL = " ";

    private final PrintStream out;

    public BoardPrinter() {
        this.out = System.out;
    }

    public BoardPrinter(PrintStream out) {
        this.out = out;
    }

    public void printBoard(Board board){
        Collection<Collection<Boolean>> boardList = board.getBoardList();
        for (Collection<Boolean> rows : boardList) {
            for (Boolean cellState : rows) {
                out.print(getHumanForCellState(cellState) + " ");
            }
            out.println();
        }
    }

    private String getHumanForCellState(Boolean state) {
        return (state) ? LIVE_CELL : DEATH_CELL;
    }
}