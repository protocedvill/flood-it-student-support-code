// Imports for the parameters of flood

import java.util.*;


public class Flood {

    // flood time complexity: O(???)
    public static void flood(WaterColor color,
                              LinkedList<Coord> flooded_list,
                              Tile[][] tiles,
                              Integer board_size) {

        LinkedList<Coord> toAdd = new LinkedList<>();

        // Checks all existing flooded items - adds nearby matching files to toAdd
        for (Coord coord : flooded_list) {
            for (Coord coord2 : coord.neighbors(board_size)) {
                if (!flooded_list.contains(coord2) && coord2.onBoard(board_size) && tiles[coord2.getY()][coord2.getX()].getColor() == color) {
                    toAdd.add(coord2);
                }
            }
        }

        // Adds all first pass matches.
        //System.out.println("First Pass:");
        //System.out.println(floodlistToString(toAdd));
        flooded_list.addAll(toAdd);

        // Checks all new squares for matching squares
        // - Removes each square from the toAdd list when checked
        // - Adds new matching squares to the toAdd list
        // as the board is finite, eventually all squares will be checked and the loop will exit
        while(!toAdd.isEmpty()) {

            //System.out.println("Checking Matching for:");
            //System.out.println(floodlistToString(toAdd));

            // I tried doing this only using the toAdd list as my working space, but it ran into concurrency issues
            LinkedList<Coord> toAddTmp = new LinkedList<>();
            LinkedList<Coord> toRemoveTmp = new LinkedList<>();

            for (Coord coord : toAdd) {
                for (Coord coord2 : coord.neighbors(board_size)) {
                    if (!flooded_list.contains(coord2) && coord2.onBoard(board_size) && tiles[coord2.getY()][coord2.getX()].getColor() == color) {
                        //System.out.println("Found: " + coord2 + " using " + coord);
                        toAddTmp.add(coord2);
                    }
                }
                // Removes current item so we can exit when the toAdd list is empty
                //System.out.println("Removing " + coord);
                toRemoveTmp.add(coord);
            }

            toAdd.addAll(toAddTmp);
            toAdd.removeAll(toRemoveTmp);

            flooded_list.addAll(toAddTmp);
        }
    }

    // flood1 time complexity: O(???)
    public static void flood1(WaterColor color,
                             LinkedList<Coord> flooded_list,
                             Tile[][] tiles,
                             Integer board_size) {
        // YOUR CODE
    }

    public static String floodlistToString(LinkedList<Coord> flooded_list) {
        String output = "";
        for (Coord coord : flooded_list) {
            output = output.concat(coord.toString());
        }
        return output;
    }

}
