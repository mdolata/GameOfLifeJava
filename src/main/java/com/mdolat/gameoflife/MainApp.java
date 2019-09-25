package com.mdolat.gameoflife;

import com.google.common.collect.ImmutableMap;
import com.mdolat.gameoflife.board.Board;
import com.mdolat.gameoflife.board.BoardPrinter;
import com.google.common.collect.ImmutableList;
import com.mdolat.gameoflife.board.Symbols;
import com.mdolat.gameoflife.roundsManager.Manager;
import com.mdolat.gameoflife.roundsManager.RoundCalculator;
import com.mdolat.gameoflife.properties.PropertiesLoader;


public class MainApp {
    public static void main(String[] args){

        ImmutableMap<String, String> properties = PropertiesLoader.loadPropertiesFrom("/application.properties");

        Symbols symbols = new Symbols(properties.get("live_cell"), properties.get("death_cell"));

        Board board = createInitialBoard();
        RoundCalculator roundCalculator = new RoundCalculator();

        BoardPrinter printer = new BoardPrinter(symbols);
        Manager manager = new Manager(board, roundCalculator);

        for (int i = 0; i < 10; i++) {
            Board board1 = manager.getLastKnownBoard();
            printer.printActualRound(board);
            printer.printBoard(board1);

            sleep();
            manager.calculateNextRound();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Board createInitialBoard() {
        Boolean[] booleans1 = {false, false, false, false, false, false, false, false};
        Boolean[] booleans2 = {false, false, false, true, true, true, false, false};
        Boolean[] booleans3 = {false, false, false, false, false, false, false, false};
        Boolean[] booleans4 = {false, false, false, false, false, false, false, false};
        ImmutableList<Boolean> booleanslst1 = ImmutableList.copyOf(booleans1);
        ImmutableList<Boolean> booleanslst2 = ImmutableList.copyOf(booleans2);
        ImmutableList<Boolean> booleanslst3 = ImmutableList.copyOf(booleans3);
        ImmutableList<Boolean> booleanslst4 = ImmutableList.copyOf(booleans4);
        return Board.of(ImmutableList.of(booleanslst1, booleanslst2, booleanslst3, booleanslst4));
    }
}