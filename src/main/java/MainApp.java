import board.Board;
import board.BoardPrinter;
import com.google.common.collect.ImmutableList;
import org.reflections.Reflections;
import properties.PropertyHaving;
import roundsManager.Manager;
import roundsManager.RoundCalculator;

import java.io.*;
import java.util.Properties;
import java.util.Set;


public class MainApp {
    public static void main(String[] args){
        loadProperties();
        //demo();
    }

    private static void loadProperties() {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = MainApp.class.getResourceAsStream("/application.properties")){
            prop.load(resourceAsStream);

            prop.forEach((k, v) -> System.out.println(k + " ->" + v + "<-"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        Reflections reflections = new Reflections("board");
        Set<Class<? extends PropertyHaving>> subTypesOf = reflections.getSubTypesOf(PropertyHaving.class);
        subTypesOf.forEach(aClass -> System.out.println(aClass.getSimpleName()));

        subTypesOf.forEach(aClass -> ImmutableList
                                        .copyOf(aClass.getDeclaredFields())
                                        .stream()
                                        .filter(field -> field.getType().equals(String.class))

                                        .forEach(field -> System.out.println(field.getName()+ " " + prop.getProperty(field.getName().toLowerCase(), ""))));


    }

    public static void demo(){
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
