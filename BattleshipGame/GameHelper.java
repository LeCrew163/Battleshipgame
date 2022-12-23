import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class GameHelper {
    String userGuess;

    String getUserInput (String consoleHelpText) {
        Scanner userInput = new Scanner(System.in);
        System.out.printf(consoleHelpText);
        userGuess = userInput.next();
        return userGuess;
    }

    ArrayList<String> placeShip() {
        Random rand = new Random();
        Battleship ship = new Battleship();
        int shipSize = ship.shipSize;
        int randomCase = rand.nextInt(2);
        int rNumCase0 = rand.nextInt(5);
        int rNumCase1 = rand.nextInt(7);
        char randomCharCase0 = (char) (rand.nextInt(7) + 'A');
        int randomCharCase1 = rand.nextInt(5) + 'A';
        String randomCell;
        ArrayList<String> randLocationCells = new ArrayList<String>();

        if (randomCase == 0) {
            for (int i = 0; i < shipSize; i++) {
                randomCell = randomCharCase0 + Integer.toString(rNumCase0);
                randLocationCells.add(randomCell);
                rNumCase0++;
            }
        }
        if (randomCase == 1) {
            for (int i = 0; i < shipSize; i++) {
                randomCell = (char) randomCharCase1 + Integer.toString(rNumCase1);
                randLocationCells.add(randomCell);
                randomCharCase1 ++;
            }
        }
        return randLocationCells;
    }
}
