package roundsManager;

import board.Utils.BoardsManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

    private RoundCalculator roundCalculator;

    @Before
    public void setUp(){
        this.roundCalculator = new RoundCalculator();
    }

    @Test
    public void shouldCreateManager(){
        Manager manager = new Manager(BoardsManager.getEmptyBoard(), roundCalculator);

        assertEquals(1, manager.getBoardList().size());
        assertEquals(BoardsManager.getEmptyBoard(), manager.getLastKnownBoard());
        assertEquals(1, manager.getLastKnownBoard().getRound());
    }

    @Test
    public void shouldCalculateNextRound(){
        Manager manager = new Manager(BoardsManager.getEmptyBoard(), roundCalculator);

        int newestRound = manager.calculateNextRound();

        assertEquals(2, newestRound);
        assertEquals(2, manager.getBoardList().size());
        assertEquals(2, manager.getLastKnownBoard().getRound());
    }

    @Test
    public void shouldCalculateNextTwoRound(){
        Manager manager = new Manager(BoardsManager.getEmptyBoard(), roundCalculator);

        int newestRound = manager.calculateNextRound();
        assertEquals(2, newestRound);

        newestRound = manager.calculateNextRound();
        assertEquals(3, newestRound);
        assertEquals(3, manager.getBoardList().size());
        assertEquals(3, manager.getLastKnownBoard().getRound());
    }
}