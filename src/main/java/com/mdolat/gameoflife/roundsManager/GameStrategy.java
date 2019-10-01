package com.mdolat.gameoflife.roundsManager;

//todo find better name
public interface GameStrategy {
    Boolean checkVitality(Boolean[][] board, int positionX, int positionY);
}
