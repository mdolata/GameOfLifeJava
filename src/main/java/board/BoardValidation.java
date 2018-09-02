package board;

import java.util.AbstractCollection;
import java.util.stream.IntStream;

public class BoardValidation {
    public static boolean isValid(Board board) {
        return getMax(board) == getMin(board);
    }

    private static int getMin(Board board) {
        return getIntStream(board)
                .min()
                .orElse(0);
    }

    private static int getMax(Board board) {
        return getIntStream(board)
                .max()
                .orElse(0);
    }

    private static IntStream getIntStream(Board board) {
        return board
                .getBoardList()
                .stream()
                .mapToInt(AbstractCollection::size);
    }
}
