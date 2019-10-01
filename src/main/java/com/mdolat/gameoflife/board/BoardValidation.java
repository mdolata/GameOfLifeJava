package com.mdolat.gameoflife.board;

import io.vavr.collection.Traversable;

public class BoardValidation {
    private static final int EXPECTED_DISTINCT_SIZES_COUNT = 1;

    public static boolean isValid(Board board) {
        return EXPECTED_DISTINCT_SIZES_COUNT == board
                .getBoardList()
                .toStream()
                .distinctBy(Traversable::size)
                .count(integer -> true);
    }
}
