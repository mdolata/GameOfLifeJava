package roundsManager;

import board.Board;

public class RoundCalculator {
    public Board calculateNextRound(Board board) {
        return new Board(board.getBoardList(), board.getRound() + 1);
    }
}
