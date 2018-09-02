package board;

import java.util.Collection;

/*
Represents board game in console
 */
public class Board {

    private final Collection<Collection<Boolean>> boardList;
    private final int round;


    public Board(Collection<Collection<Boolean>> boardList) {
        this(boardList, 1);
    }

    public Board(Collection<Collection<Boolean>> boardList, int round) {
        if (round < 1) throw new IllegalArgumentException("round should be over 0");
        this.boardList = boardList;
        this.round = round;
    }

    public Collection<Collection<Boolean>> getBoardList() {
        return boardList;
    }

    public int getRound() {
        return round;
    }
}
