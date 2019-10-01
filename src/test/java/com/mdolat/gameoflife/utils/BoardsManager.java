package com.mdolat.gameoflife.utils;

import com.mdolat.gameoflife.board.Board;
import io.vavr.collection.List;

public class BoardsManager {

    public static final String EMPTY_BOARD = "\n";
    public static final String BOARD_1 = "##\n##\n";
    public static final String BOARD_2 = "#0\n#0\n";
    public static final String BOARD_3 =
            "#0#0#0#0\n" +
            "#0#0#0#0\n" +
            "#0#0#0#0\n" +
            "#0#0#0#0\n";

    public static Board getEmptyBoard() {
        return Board.of(List.of(List.of())).get();
    }

    public static Board getBoardNo1() {
        List<Boolean> booleans = List.of(true, true);
        return Board.of(List.of(booleans, booleans)).get();
    }

    public static Board getBoardNo2() {
        List<Boolean> booleans = List.of(true, false);
        return Board.of(List.of(booleans, booleans)).get();
    }

    public static Board getBoardNo3() {
        Boolean[] booleans1 = {true, false, true, false, true, false, true, false};
        List<Boolean> booleans = List.of(booleans1);
        return Board.of(List.of(booleans, booleans, booleans, booleans)).get();
    }
}
