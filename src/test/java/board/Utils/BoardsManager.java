package board.Utils;

import board.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class BoardsManager {

    public static final String EMPTY_BOARD = "";
    public static final String BOARD_1 = "##\n##\n";
    public static final String BOARD_2 = "# \n# \n";

    public static Board getEmptyBoard() {
        return new Board(new ArrayList<>());
    }

    public static Board getBoardNo1() {
        Boolean[] booleans = new Boolean[]{true, true};
        Collection<Collection<Boolean>> list = new ArrayList<>();
        list.add(Arrays.asList(booleans));
        list.add(Arrays.asList(booleans));

        return new Board(list);
    }

    public static Board getBoardNo2() {
        Boolean[] booleans = new Boolean[]{true, false};
        Collection<Collection<Boolean>> list = new ArrayList<>();
        list.add(Arrays.asList(booleans));
        list.add(Arrays.asList(booleans));

        return new Board(list);
    }
}
