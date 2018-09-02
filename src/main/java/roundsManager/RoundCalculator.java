package roundsManager;

import board.Board;
import com.google.common.collect.ImmutableList;

public class RoundCalculator {
    public Board calculateNextRound(Board board) {
        Boolean[][] fromList = create2dArrayFromList(board.getBoardList());
        Boolean[][] resultArray = getEmptyArray(board.getBoardList());

        for (int i = 0; i < fromList.length; i++) {
            for (int j = 0; j < fromList[i].length; j++) {
                resultArray[i][j] = checkVitality(fromList, i, j);
            }
        }

        return new Board(board.getBoardList(), board.getRound() + 1);
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

    private int countAliveNeighbor(Boolean[][] array, int i, int j) {
        return 0;
    }

    private Boolean[][] create2dArrayFromList(ImmutableList<ImmutableList<Boolean>> boardList) {
        Boolean[][] booleans;
        booleans = getEmptyArray(boardList);

        for (int i = 0; i < booleans.length; i++) {
            booleans[i] = createArray(boardList.get(i));
        }
        return booleans;
    }

    private Boolean[][] getEmptyArray(ImmutableList<ImmutableList<Boolean>> boardList) {
        return new Boolean[boardList.size()][boardList.get(0).size()];
    }

    private Boolean[] createArray(ImmutableList<Boolean> list) {
        Boolean[] array = new Boolean[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
