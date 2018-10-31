package com.mdolat.gameoflife.board;

import java.util.Collection;

public class BoardValidation {
    private static final int EXPECTED_DISTINCT_SIZES_COUNT = 1;

    public static boolean isValid(Board board) {
        return EXPECTED_DISTINCT_SIZES_COUNT == board
                .getBoardList()
                .stream()
                .mapToInt(Collection::size)
                .distinct()
                .count();
    }
}
