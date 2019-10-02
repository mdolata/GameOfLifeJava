package com.mdolat.gameoflife;

import com.mdolat.gameoflife.board.Board;
import com.mdolat.gameoflife.board.BoardPrinter;
import com.mdolat.gameoflife.board.Symbols;
import com.mdolat.gameoflife.roundsManager.Manager;
import com.mdolat.gameoflife.roundsManager.RoundCalculator;
import com.mdolat.gameoflife.properties.PropertiesLoader;
import com.mdolat.gameoflife.roundsManager.strategies.ClassicConway;
import io.vavr.collection.List;
import io.vavr.control.Option;


public class MainApp {
    public static void main(String[] args){

        Option<String> live_cell = PropertiesLoader.getProperty("live_cell");
        Option<String> death_cell = PropertiesLoader.getProperty("death_cell");

        Symbols symbols = new Symbols(live_cell.get(), death_cell.get());

        Board board = createInitialBoard();
        RoundCalculator roundCalculator = new RoundCalculator(new ClassicConway());

        BoardPrinter printer = new BoardPrinter(symbols, System.out);
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
        List<Boolean> booleanList1 = List.of(false, false, false, false, false, false, false, false);
        List<Boolean> booleanList2 = List.of(false, false, false, true, true, true, false, false);
        List<Boolean> booleanList3 = List.of(false, false, false, false, false, false, false, false);
        List<Boolean> booleanList4 = List.of(false, false, false, false, false, false, false, false);
        return Board.of(List.of(booleanList1, booleanList2, booleanList3, booleanList4)).get();
    }
}
