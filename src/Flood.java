// Imports for the parameters of flood

import java.lang.reflect.Array;
import java.util.*;


public class Flood {

    // flood time complexity: O(???)
    public static void flood(WaterColor color,
                              LinkedList<Coord> flooded_list,
                              Tile[][] tiles,
                              Integer board_size) {

        LinkedList<Coord> toAdd = new LinkedList<>();

        for (Coord coord : flooded_list) {
            for (Coord coord2 : coord.neighbors(board_size)) {
                if (!flooded_list.contains(coord2) && coord2.onBoard(board_size) && tiles[coord2.getY()][coord2.getX()].getColor() == color) {
                    toAdd.add(coord2);
                }
            }
        }
        flooded_list.addAll(toAdd);
    }

    // flood1 time complexity: O(???)
    public static void flood1(WaterColor color,
                             LinkedList<Coord> flooded_list,
                             Tile[][] tiles,
                             Integer board_size) {
        // YOUR CODE
    }

}
