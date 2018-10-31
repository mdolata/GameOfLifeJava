package com.mdolat.gameoflife.board;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mdolat.gameoflife.properties.PropertyHaving;
import com.mdolat.gameoflife.utils.LoadProperties;

import java.io.PrintStream;

public class BoardPrinter implements PropertyHaving {

    static {
        ImmutableList<String> fields = ImmutableList.of("LIVE_CELL", "DEATH_CELL");
        ImmutableMap<String, String> properties = LoadProperties.loadProperties("/application.properties", fields);
        LIVE_CELL = properties.get("LIVE_CELL");
        DEATH_CELL = properties.get("DEATH_CELL");
    }
    private static final String LIVE_CELL;
    private static final String DEATH_CELL;

    private final PrintStream out;

    public BoardPrinter() {
        this.out = System.out;
    }

    public BoardPrinter(PrintStream out) {
        this.out = out;
    }

    public void printBoard(Board board){
        board.getBoardList().forEach(row -> {
            row.forEach(cell -> out.print(getHumanForCellState(cell)));
            out.println();
        });
    }

    public String getHumanForCellState(Boolean state) {
        return (state) ? LIVE_CELL : DEATH_CELL;
    }
}