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
}
