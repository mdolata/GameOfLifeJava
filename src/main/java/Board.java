
/*
Represents board game in console
 */
public class Board {

    private final boolean[][] board;

    public Board(int boardSize) {
        this.board = new boolean[boardSize][boardSize];
    }

    public void printBoard(){
        for (boolean[] aBoard : board) {
            for (int j = 0; j < board.length; j++) {
                String state = (aBoard[j]) ? "#" : " ";
                System.out.println(state);
            }
        }
    }
}
