package com.mdolat.gameoflife.roundsManager;

import com.mdolat.gameoflife.board.Board;
import io.vavr.collection.List;

//todo review needed
public class RoundCalculator {

    private final GameStrategy gameStrategy;

    public RoundCalculator(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    public Board calculateNextRound(Board board) {
        Boolean[][] fromList = create2dArrayFromList(board.getBoardList());
        Boolean[][] resultArray = calculateVitalityForBoard(fromList);
        return Board.of(getListsFromArray(resultArray), board.getRound() + 1);
    }

    private Boolean[][] calculateVitalityForBoard(Boolean[][] fromList) {
        Boolean[][] resultArray = getEmpty2DArray(fromList.length, fromList[0].length);

        for (int i = 0; i < fromList.length; i++) {
            for (int j = 0; j < fromList[i].length; j++) {
                resultArray[i][j] = checkVitality(fromList, i, j);
            }
        }
        return resultArray;
    }

    private List<List<Boolean>> getListsFromArray(Boolean[][] resultArray) {
        List<List<Boolean>> boardBuilder = List.empty();
        for (Boolean[] aResultArray : resultArray) {
            boardBuilder = boardBuilder.append(List.of(aResultArray));
        }

        return boardBuilder;
    }

    private Boolean checkVitality(Boolean[][] array, int i, int j) {
        return gameStrategy.checkVitality(array, i, j);
    }

    private Boolean[][] create2dArrayFromList(List<List<Boolean>> boardList) {
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

    private Boolean[] createArray(List<Boolean> list) {
        Boolean[] array = new Boolean[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
