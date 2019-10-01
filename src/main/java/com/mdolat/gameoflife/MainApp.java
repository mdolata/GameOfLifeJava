package com.mdolat.gameoflife;

import com.google.common.collect.ImmutableMap;
import com.mdolat.gameoflife.board.Board;
import com.mdolat.gameoflife.board.BoardPrinter;
import com.mdolat.gameoflife.board.Symbols;
import com.mdolat.gameoflife.roundsManager.Manager;
import com.mdolat.gameoflife.roundsManager.RoundCalculator;
import com.mdolat.gameoflife.properties.PropertiesLoader;
import com.mdolat.gameoflife.roundsManager.strategies.ClassicConway;
import io.vavr.collection.List;


public class MainApp {
    public static void main(String[] args){

        ImmutableMap<String, String> properties = PropertiesLoader.loadPropertiesFrom("/application.properties");

        Symbols symbols = new Symbols(properties.get("live_cell"), properties.get("death_cell"));

        Board board = createInitialBoard();
        RoundCalculator roundCalculator = new RoundCalculator(new ClassicConway());

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
        List<Boolean> booleanslst1 = List.of(booleans1);
        List<Boolean> booleanslst2 = List.of(booleans2);
        List<Boolean> booleanslst3 = List.of(booleans3);
        List<Boolean> booleanslst4 = List.of(booleans4);
        return Board.of(List.of(booleanslst1, booleanslst2, booleanslst3, booleanslst4));
    }
}
