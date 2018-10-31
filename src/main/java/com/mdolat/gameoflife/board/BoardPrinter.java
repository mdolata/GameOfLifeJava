package com.mdolat.gameoflife.board;

import com.mdolat.gameoflife.properties.PropertyHaving;
import com.mdolat.gameoflife.utils.LoadProperties;

import java.io.PrintStream;

public class BoardPrinter implements PropertyHaving {

    static {
        LoadProperties.loadProperties("application.properties");
        LIVE_CELL = "#";
        DEATH_CELL = " ";
    }
    //TODO create load constants from com.mdolat.gameoflife.properties file
    private static final String LIVE_CELL;
    //TODO create load constants from com.mdolat.gameoflife.properties file
    private static final String DEATH_CELL;

    private final PrintStream out;

    public BoardPrinter() {
        this.out = System.out;
    }

    BoardPrinter(PrintStream out) {
        this.out = out;
    }

    public void printBoard(Board board){
        board.getBoardList().forEach(row -> {
            row.forEach(cell -> out.print(getHumanForCellState(cell)));
            out.println();
        });
    }

    private String getHumanForCellState(Boolean state) {
        return (state) ? LIVE_CELL : DEATH_CELL;
    }
}