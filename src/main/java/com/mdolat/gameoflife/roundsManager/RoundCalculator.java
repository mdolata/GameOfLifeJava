package com.mdolat.gameoflife.roundsManager;

import com.mdolat.gameoflife.board.Board;
import com.google.common.collect.ImmutableList;

//todo review needed
public class RoundCalculator {

    public Board calculateNextRound(Board board) {
        Boolean[][] fromList = create2dArrayFromList(board.getBoardList());
        Boolean[][] resultArray = calculateVitalityForBoard(board, fromList);
        return Board.of(getListsFromArray(fromList, resultArray), board.getRound() + 1);
    }

    private Boolean[][] calculateVitalityForBoard(Board board, Boolean[][] fromList) {
        Boolean[][] resultArray = getEmpty2DArray(fromList.length, fromList[0].length);

        for (int i = 0; i < fromList.length; i++) {
            for (int j = 0; j < fromList[i].length; j++) {
                resultArray[i][j] = checkVitality(fromList, i, j);
            }
        }
        return resultArray;
    }

    private ImmutableList<ImmutableList<Boolean>> getListsFromArray(Boolean[][] fromList, Boolean[][] resultArray) {
        ImmutableList.Builder<ImmutableList<Boolean>> boardBuilder = ImmutableList.builderWithExpectedSize(fromList.length);
        for (Boolean[] aResultArray : resultArray) {
            boardBuilder = boardBuilder.add(ImmutableList.copyOf(aResultArray));
        }

        return boardBuilder.build();
    }

    private Boolean checkVitality(Boolean[][] array, int i, int j) {
        int aliveNeighbors = countAliveNeighbor(array, i, j);
        boolean result;

        Boolean currentCell = array[i][j];
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

    //TODO neighbor counter
    /*
        1 | 2 | 3
        4 | c | 6
        7 | 8 | 9
     */
    public int countAliveNeighbor(Boolean[][] array, int i, int j) {
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

    private Boolean[][] create2dArrayFromList(ImmutableList<ImmutableList<Boolean>> boardList) {
        Boolean[][] booleans;
        booleans = getEmpty2DArray(boardList.size(), boardList.get(0).size());

        for (int i = 0; i < booleans.length; i++) {
            booleans[i] = createArray(boardList.get(i));
        }
        return booleans;
    }

    private Boolean[][] getEmpty2DArray(int size1, int size2) {
        return new Boolean[size1][size2];
    }

    private Boolean[] createArray(ImmutableList<Boolean> list) {
        Boolean[] array = new Boolean[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
