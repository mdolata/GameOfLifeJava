package com.mdolat.gameoflife.board;

import com.mdolat.gameoflife.properties.PropertyHaving;

import java.io.PrintStream;

public class BoardPrinter implements PropertyHaving {

    private final String LIVE_CELL;
    private final String DEATH_CELL;

    private final PrintStream out;

    public BoardPrinter(Symbols symbols, PrintStream out) {
        this.out = out;
        LIVE_CELL = symbols.getLiveCell();
        DEATH_CELL = symbols.getDeathCell();
    }

    public void printBoard(Board board){
        board.getBoardList().forEach(row -> {
            row.forEach(cell -> out.print(getHumanForCellState(cell)));
            out.println();
        });
    }

    public void printActualRound(Board board) {
        out.print(board.getRound());
        out.println();
    }

    private String getHumanForCellState(Boolean state) {
        return (state) ? LIVE_CELL : DEATH_CELL;
    }
}