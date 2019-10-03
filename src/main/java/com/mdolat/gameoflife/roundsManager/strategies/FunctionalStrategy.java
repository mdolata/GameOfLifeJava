package com.mdolat.gameoflife.roundsManager.strategies;

import com.mdolat.gameoflife.roundsManager.GameStrategy;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Functional implementation of game of life.
 * @author Rosemberg.Porras
 */
public class FunctionalStrategy implements GameStrategy {

    private final Predicate<Integer> aliveCellRule=(neighbors)->neighbors==2 || neighbors ==3;

    private final Predicate<Integer> deathCellRule=(neighbors)->neighbors==3;

    @Override
    public Boolean checkVitality(Boolean[][] board, int positionX, int positionY) {
        return checkHealth(board, positionX,positionY).
                map(state->getCountOfNeighbors(board,positionX,positionY).
                        filter(state?aliveCellRule:deathCellRule).isPresent()).get();
    }

    Optional<Boolean> checkHealth(Boolean[][] board, int positionX, int positionY){
        return Optional.of(board[positionX][positionY]);
    }

    Optional<Integer> getCountOfNeighbors(Boolean[][] board, int x, int y){
        return Optional.of(evaluateNeighbor(board,(x-1),(y-1))).
                map(value->value + evaluateNeighbor(board,(x-1),y)).
                map(value->value + evaluateNeighbor(board,(x-1),(y+1))).
                map(value->value + evaluateNeighbor(board,(x),(y-1))).
                map(value->value + evaluateNeighbor(board,(x),(y+1))).
                map(value->value + evaluateNeighbor(board,(x+1),(y-1))).
                map(value->value + evaluateNeighbor(board,(x+1),y)).
                map(value->value + evaluateNeighbor(board,(x+1),(y+1)));
    }
    Integer evaluateNeighbor(Boolean[][] board, int x, int y){
        return x>=0 && y>=0 && x<board.length && y<board[0].length?board[x][y]?1:0:0;
    }
}
