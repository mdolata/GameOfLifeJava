package com.mdolat.gameoflife.roundsManager.strategies;

import com.mdolat.gameoflife.roundsManager.GameStrategy;

public class ClassicConway implements GameStrategy {

    @Override
    public Boolean checkVitality(Boolean[][] array, int positionX, int positionY) {
        int aliveNeighbors = countAliveNeighbor(array, positionX, positionY);
        boolean result;

        Boolean currentCell = array[positionX][positionY];
        if(isAlive(currentCell)){
            result = has2or3AliveNeighbors(aliveNeighbors);
        } else {
            result = hasExactly3AliveNeighbors(aliveNeighbors);
        }

        return result;
    }

    private boolean hasExactly3AliveNeighbors(int aliveNeighbors) {
        return aliveNeighbors == 3;
    }

    private boolean has2or3AliveNeighbors(int aliveNeighbors) {
        return aliveNeighbors == 2 || aliveNeighbors == 3;
    }

    private boolean isAlive(Boolean currentCell) {
        return currentCell;
    }

    //TODO simplify neighbor counter
    /*
        1 | 2 | 3
        4 | c | 6
        7 | 8 | 9
     */
    int countAliveNeighbor(Boolean[][] array, int i, int j) {
        int counter = 0;
        int maxRow = array.length-1;
        int maxColumn = array[0].length-1;
        int row ;
        int column ;
        //1
        row = (i - 1 < 0) ? maxRow : i - 1;
        column = (j - 1 < 0) ? maxColumn : j - 1;
        counter += array[row][column] ? 1 : 0;

        //2
        row = (i - 1 < 0) ? maxRow : i - 1;
        column = j;
        counter += array[row][column] ? 1 : 0;

        //3
        row = (i - 1 < 0) ? maxRow : i - 1;
        column = (j + 1 > maxColumn) ? 0 : j + 1;
        counter += array[row][column] ? 1 : 0;

        //4
        row = i;
        column = (j - 1 < 0) ? maxColumn : j - 1;
        counter += array[row][column] ? 1 : 0;

        //6
        row = i;
        column = (j + 1 > maxColumn) ? 0 : j + 1;
        counter += array[row][column] ? 1 : 0;

        //7
        row = (i + 1 > maxRow) ? 0 : i + 1;
        column = (j - 1 < 0) ? maxColumn : j - 1;
        counter += array[row][column] ? 1 : 0;

        //8
        row = (i + 1 > maxRow) ? 0 : i + 1;
        column = j;
        counter += array[row][column] ? 1 : 0;

        //9
        row = (i + 1 > maxRow) ? 0 : i + 1;
        column = (j + 1 > maxColumn) ? 0 : j + 1;
        counter += array[row][column] ? 1 : 0;

        return counter;
    }
}
