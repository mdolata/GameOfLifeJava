package board.Utils;

import board.Board;
import com.google.common.collect.ImmutableList;

public class BoardsManager {

    public static final String EMPTY_BOARD = "\n";
    public static final String BOARD_1 = "##\n##\n";
    public static final String BOARD_2 = "# \n# \n";
    public static final String BOARD_3 =
            "# # # # \n" +
            "# # # # \n" +
            "# # # # \n" +
            "# # # # \n";

    public static Board getEmptyBoard() {
        return new Board(ImmutableList.of(ImmutableList.of()));
    }

    public static Board getBoardNo1() {
        ImmutableList<Boolean> booleans = ImmutableList.of(true, true);
        return new Board(ImmutableList.of(booleans, booleans));
    }

    public static Board getBoardNo2() {
        ImmutableList<Boolean> booleans = ImmutableList.of(true, false);
        return new Board(ImmutableList.of(booleans, booleans));
    }

    public static Board getBoardNo3() {
        Boolean[] booleans1 = {true, false, true, false, true, false, true, false};
        ImmutableList<Boolean> booleans = ImmutableList.copyOf(booleans1);
        return new Board(ImmutableList.of(booleans, booleans, booleans, booleans));
    }
}
