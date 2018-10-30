package board;

import com.google.common.collect.ImmutableList;

/*
Represents board game in console
 */
public class Board {

    private final ImmutableList<ImmutableList<Boolean>> boardList;
    private final int round;


    public Board(ImmutableList<ImmutableList<Boolean>> boardList) {
        this(boardList, 1);
    }

    public Board(ImmutableList<ImmutableList<Boolean>> boardList, int round) {
        if (round < 1) throw new IllegalArgumentException("round should be over 0");
        this.boardList = boardList;
        this.round = round;
    }

    public ImmutableList<ImmutableList<Boolean>> getBoardList() {
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
