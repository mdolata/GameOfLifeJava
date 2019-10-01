package com.mdolat.gameoflife.board;

import io.vavr.collection.List;
import io.vavr.control.Either;

public class Board {

    private final List<List<Boolean>> boardList;
    private final int round;

    public static Either<ErrorMessage, Board> of(List<List<Boolean>> boardList) {
        return of(boardList, 1);
    }

    public static Either<ErrorMessage, Board> of(List<List<Boolean>> boardList, int round) {
        if (round < 1) return Either.left(ErrorMessage.of("round should be over 0"));
        return Either.right(new Board(boardList, round));
    }

    private Board(List<List<Boolean>> boardList, int round) {
        this.boardList = boardList;
        this.round = round;
    }

    public List<List<Boolean>> getBoardList() {
        return boardList;
    }

    public int getRound() {
        return round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return round == board.round && boardList.equals(board.boardList);
    }

    @Override
    public int hashCode() {
        int result = boardList.hashCode();
        result = 31 * result + round;
        return result;
    }
}
