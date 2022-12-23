import java.util.ArrayList;

class Battleship {
    private ArrayList<String> locationCells;
//    private int numOfHits;
    private String shipName;
    int shipSize = 3;
    boolean isAlive = true;

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
                isAlive = false;
            } else {
                result = "hit";
            }
        }
        return result;
    }

    void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    void setShipName(String ship) {
        shipName = ship;
    }

    ArrayList<String> getLocationCells() {
        return locationCells;
    }
    String getShipName() {
        return shipName;
    }
}

