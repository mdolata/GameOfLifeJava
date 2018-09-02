package roundsManager;

import board.Board;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final List<Board> boardList;
    private final RoundCalculator calculator;
    private Board lastKnownBoard;

    public Manager(Board initialBoard, RoundCalculator calculator) {
        if (initialBoard.getRound() != 1) throw new IllegalArgumentException("initial board should has round no 1");
        this.calculator = calculator;
        boardList = new ArrayList<>();
        addNewBoard(initialBoard);
    }

    public int calculateNextRound(){
        Board newBoard = calculator.calculateNextRound(lastKnownBoard);
        addNewBoard(newBoard);
        return newBoard.getRound();
    }

    private void addNewBoard(Board initialBoard) {
        boardList.add(initialBoard);
        setLastKnownBoard(initialBoard);
    }

    private void setLastKnownBoard(Board lastKnownBoard) {
        this.lastKnownBoard = lastKnownBoard;
    }
}