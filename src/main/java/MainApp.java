import board.Board;
import board.BoardPrinter;
import com.google.common.collect.ImmutableList;
import roundsManager.Manager;
import roundsManager.RoundCalculator;


public class MainApp {
    public static void main(String[] args){
        Board board = getBoardNo3();
        RoundCalculator roundCalculator = new RoundCalculator();

        BoardPrinter printer = new BoardPrinter();
        Manager manager = new Manager(board, roundCalculator);

        for (int i = 0; i < 10; i++) {
            Board board1 = manager.getLastKnownBoard();
            System.out.println(board1.getRound());
            printer.printBoard(board1);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            manager.calculateNextRound();
        }
    }

    private static Board getBoardNo3() {
        Boolean[] booleans1 = {false, false, false, false, false, false, false, false};
        Boolean[] booleans2 = {false, false, false, true, true, true, false, false};
        Boolean[] booleans3 = {false, false, false, false, false, false, false, false};
        Boolean[] booleans4 = {false, false, false, false, false, false, false, false};
        ImmutableList<Boolean> booleanslst1 = ImmutableList.copyOf(booleans1);
        ImmutableList<Boolean> booleanslst2 = ImmutableList.copyOf(booleans2);
        ImmutableList<Boolean> booleanslst3 = ImmutableList.copyOf(booleans3);
        ImmutableList<Boolean> booleanslst4 = ImmutableList.copyOf(booleans4);
        return new Board(ImmutableList.of(booleanslst1, booleanslst2, booleanslst3, booleanslst4));
    }
}
