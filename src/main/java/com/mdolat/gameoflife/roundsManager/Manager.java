package com.mdolat.gameoflife.roundsManager;

import com.mdolat.gameoflife.board.Board;
import com.mdolat.gameoflife.board.ErrorMessage;
import io.vavr.control.Either;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final List<Board> boardList;
    private final RoundCalculator calculator;
    private Board lastKnownBoard;


    //todo Either!
    public Manager(Board initialBoard, RoundCalculator calculator) {
        if (initialBoard.getRound() != 1) throw new IllegalArgumentException("initial com.mdolat.gameoflife.board should has round no 1");
        this.calculator = calculator;
        boardList = new ArrayList<>();
        addNewBoard(initialBoard);
    }

    public int calculateNextRound(){
        Either<ErrorMessage, Board> newBoard = calculator.calculateNextRound(lastKnownBoard);
        newBoard.map(this::addNewBoard);
        return newBoard.get().getRound();
    }

    private Board addNewBoard(Board board) {
        boardList.add(board);
        setLastKnownBoard(board);
        return board;
    }

    private void setLastKnownBoard(Board lastKnownBoard) {
        this.lastKnownBoard = lastKnownBoard;
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public Board getLastKnownBoard() {
        return lastKnownBoard;
    }
}