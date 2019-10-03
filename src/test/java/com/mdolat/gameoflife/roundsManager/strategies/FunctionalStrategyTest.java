package com.mdolat.gameoflife.roundsManager.strategies;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * @author Rosemberg.Porras
 */
public class FunctionalStrategyTest {

    private final FunctionalStrategy gameStrategy = new FunctionalStrategy();

    @Test
    public void checkHealthTest(){
        Boolean[][] booleans = new Boolean[][]{
                {true, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        Optional<Boolean> opt = gameStrategy.checkHealth(booleans, 0, 0);
        assertEquals(true, opt.orElseThrow(RuntimeException::new));
        opt = gameStrategy.checkHealth(booleans, 0, 1);
        assertEquals(false, opt.orElseThrow(RuntimeException::new));
    }

    @Test
    public void getCountOfNeighbors_corner_left_up_Test(){
        Boolean[][] booleans = new Boolean[][]{
                {true, false ,false, false},
                {false, false ,false, false},
                {false, false, false, false}};

        Optional<Integer> opt = gameStrategy.getCountOfNeighbors(booleans, 0, 0);
        Integer value=opt.orElse(-1);
        assertEquals(0, (int) value);

        booleans[0][1]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 0, 0);
        value=opt.orElse(-1);
        assertEquals(1, (int) value);

        booleans[0][1]=false;
        booleans[1][0]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 0, 0);
        value=opt.orElse(-1);
        assertEquals(1, (int) value);

        booleans[0][1]=true;
        booleans[1][0]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 0, 0);
        value=opt.orElse(-1);
        assertEquals(2, (int) value);

        booleans[0][1]=true;
        booleans[1][0]=true;
        booleans[1][1]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 0, 0);
        value=opt.orElse(-1);
        assertEquals(3, (int) value);
    }

    @Test
    public void getCountOfNeighbors_corner_left_down_Test(){
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, false ,false, false},
                {true, false, false, false}};

        Optional<Integer> opt = gameStrategy.getCountOfNeighbors(booleans, 2, 0);
        Integer value=opt.orElse(-1);
        assertEquals(0, (int) value);

        booleans[1][0]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 2, 0);
        value=opt.orElse(-1);
        assertEquals(1, (int) value);

        booleans[1][0]=false;
        booleans[2][1]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 2, 0);
        value=opt.orElse(-1);
        assertEquals(1, (int) value);

        booleans[1][0]=true;
        booleans[2][1]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 2, 0);
        value=opt.orElse(-1);
        assertEquals(2, (int) value);

        booleans[1][0]=true;
        booleans[2][1]=true;
        booleans[1][1]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 2, 0);
        value=opt.orElse(-1);
        assertEquals(3, (int) value);
    }

    @Test
    public void getCountOfNeighbors_corner_right_up_Test(){
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, true},
                {false, false ,false, false},
                {false, false, false, false}};

        Optional<Integer> opt = gameStrategy.getCountOfNeighbors(booleans, 0, 3);
        Integer value=opt.orElse(-1);
        assertEquals(0, (int) value);

        booleans[0][2]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 0, 3);
        value=opt.orElse(-1);
        assertEquals(1, (int) value);

        booleans[0][2]=false;
        booleans[1][3]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 0, 3);
        value=opt.orElse(-1);
        assertEquals(1, (int) value);

        booleans[0][2]=true;
        booleans[1][3]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 0, 3);
        value=opt.orElse(-1);
        assertEquals(2, (int) value);

        booleans[0][2]=true;
        booleans[1][3]=true;
        booleans[1][2]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 0, 3);
        value=opt.orElse(-1);
        assertEquals(3, (int) value);
    }

    @Test
    public void getCountOfNeighbors_corner_right_down_Test(){
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, false ,false, false},
                {false, false, false, true}};

        Optional<Integer> opt = gameStrategy.getCountOfNeighbors(booleans, 2, 3);
        Integer value=opt.orElse(-1);
        assertEquals(0, (int) value);

        booleans[1][3]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 2, 3);
        value=opt.orElse(-1);
        assertEquals(1, (int) value);

        booleans[1][3]=false;
        booleans[2][2]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 2, 3);
        value=opt.orElse(-1);
        assertEquals(1, (int) value);

        booleans[1][3]=true;
        booleans[2][2]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 2, 3);
        value=opt.orElse(-1);
        assertEquals(2, (int) value);

        booleans[1][3]=true;
        booleans[2][2]=true;
        booleans[1][2]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 2, 3);
        value=opt.orElse(-1);
        assertEquals(3, (int) value);
    }

    @Test
    public void getCountOfNeighbors_center_Test(){
        Boolean[][] booleans = new Boolean[][]{
                {false, false ,false, false},
                {false, true ,false, false},
                {false, false, false, false}};

        Optional<Integer> opt = gameStrategy.getCountOfNeighbors(booleans, 1, 1);
        Integer value=opt.orElse(-1);
        assertEquals(0, (int) value);

        booleans[0][1]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 1, 1);
        value=opt.orElse(-1);
        assertEquals(1, (int) value);

        booleans[2][1]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 1, 1);
        value=opt.orElse(-1);
        assertEquals(2, (int) value);

        booleans[1][0]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 1, 1);
        value=opt.orElse(-1);
        assertEquals(3, (int) value);

        booleans[1][2]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 1, 1);
        value=opt.orElse(-1);
        assertEquals(4, (int) value);

        booleans[0][0]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 1, 1);
        value=opt.orElse(-1);
        assertEquals(5, (int) value);

        booleans[2][0]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 1, 1);
        value=opt.orElse(-1);
        assertEquals(6, (int) value);

        booleans[2][2]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 1, 1);
        value=opt.orElse(-1);
        assertEquals(7, (int) value);

        booleans[0][2]=true;
        opt = gameStrategy.getCountOfNeighbors(booleans, 1, 1);
        value=opt.orElse(-1);
        assertEquals(8, (int) value);
    }
}
