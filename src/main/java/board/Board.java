package board;

import java.util.Collection;

/*
Represents board game in console
 */
public class Board {

    private final Collection<Collection<Boolean>> boardList;
    private final int round;


    public Board(Collection<Collection<Boolean>> boardList) {
        this(boardList, 0);
    }

    public Board(Collection<Collection<Boolean>> boardList, int round) {
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
