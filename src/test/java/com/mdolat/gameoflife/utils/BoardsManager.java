package com.mdolat.gameoflife.utils;

import com.mdolat.gameoflife.board.Board;
import com.google.common.collect.ImmutableList;

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
        return Board.of(ImmutableList.of(ImmutableList.of()));
    }

    public static Board getBoardNo1() {
        ImmutableList<Boolean> booleans = ImmutableList.of(true, true);
        return Board.of(ImmutableList.of(booleans, booleans));
    }

    public static Board getBoardNo2() {
        ImmutableList<Boolean> booleans = ImmutableList.of(true, false);
        return Board.of(ImmutableList.of(booleans, booleans));
    }

    public static Board getBoardNo3() {
        Boolean[] booleans1 = {true, false, true, false, true, false, true, false};
        ImmutableList<Boolean> booleans = ImmutableList.copyOf(booleans1);
        return Board.of(ImmutableList.of(booleans, booleans, booleans, booleans));
    }
}
