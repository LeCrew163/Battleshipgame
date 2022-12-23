import java.util.ArrayList;
import java.io.*;
public class BattleshipGame {
    int numOfShips = 3;
    int numOfGuesses = 0;
    ArrayList<Battleship> ships = new ArrayList<>(numOfShips);
    static BattleshipGame game = new BattleshipGame();
    static GameHelper helper = new GameHelper();
    static Battleship one = new Battleship();
    static Battleship two = new Battleship();
    static Battleship three = new Battleship();

    public static void main(String[] args) {
        game.setUpGame();
        game.startPlaying();
        game.finishGame();
    }


    private void setUpGame() {
        one.setShipName("Bolt");
        two.setShipName("Hedwig");
        three.setShipName("Harry");
        ships.add(one);
        ships.add(two);
        ships.add(three);
        for (Battleship ship : ships) {
            ArrayList<String> randomShipCells = helper.placeShip();
            ship.setLocationCells(randomShipCells);
        }

        checkNotEqualShipLocation(ships);

//        for (Battleship ship : ships) { // Cheat Code, Positionen von allen Schiffen wird angezeigt
//            System.out.println(ship.getLocationCells());
//        }
    }

    void checkNotEqualShipLocation(ArrayList<Battleship> ships) { // Verbesserung: 1x array aus 3x machen und nach gleichen Elementen überprüfen
        for (int i = 0; i < numOfShips - 1; i++) {
            for (int a = i + 1; a < numOfShips; a++) {
                ArrayList<String> shipLocation = ships.get(i).getLocationCells();
                ArrayList<String> shipToCompareLocation = ships.get(a).getLocationCells();
                for (String cell : shipLocation) {
                    for (String cellToCompare : shipToCompareLocation) {
                        if (cell.equals(cellToCompare)) {
                            ships.clear();
                            setUpGame();
                            break;
                        }
                    }
                }
            }
        }
    }

    private void startPlaying() {
        while (!ships.isEmpty()) {
            String guess = helper.getUserInput("Enter a guess  ").toUpperCase();
            checkUserGuess(guess);
        }
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses ++;
        String result = "";
        for (Battleship ship : new ArrayList<Battleship> (ships)) {
            result = ship.checkYourself(userGuess);
            if (result.equals("kill")) {
                result = "kill";
                System.out.println("Ouch! You sunk " + ship.getShipName() + " :(");
                ships.remove(ship);
                break;
            } else if (result.equals("hit")) {
                result = "hit";
                break;
            } else {
                result = "miss";
                break;
            }
        }
        System.out.println(result);

    }

    private void finishGame() {
        String link = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        String link_euro = "https://images.t-online.de/2021/09/62624958v3/80x0:480x360/fit-in/1800x0/der-neue-fuenfer-"
                + "ist-der-erste-der-zweiten-generation-der-euro-scheine-seit-der-einfuehrung.jpg";
        System.out.println("All Ships are sunk! Nice job, captain!");
        System.out.println("You took " + numOfGuesses + " guesses");
        if (numOfGuesses < 25) {
            System.out.println("WOW! Only " + numOfGuesses + ". Captain Jack Sparrow, is that you? ");
        } else if (numOfGuesses < 40) {
            System.out.println("Could be better, but still ok. Here is your price: " + link);
        } else {
            System.out.println("Schwach, sehr schwach... So schwach, dass ich sogar auf die Schnelle deutsch gelernt " +
                    "habe, um es dir mitzuteilen.");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Schließ bitte das Spiel. Sofort.");
            try {
                Thread.sleep(2000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Was?! Bist du noch da? Okey, verschwindest du, wenn ich dir 5,00 Euro gebe? Hier: "
                    + link_euro);
            try {
                Thread.sleep(4000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Boaaaaah bin ich müde von dir. Ich schließe mich selbst.");
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("shutdown -s -t 2");
            }
            catch(IOException e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}
