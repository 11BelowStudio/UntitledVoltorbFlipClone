package FlipBoardClasses;

import java.util.ArrayList;
import java.util.Collections;

//package-private
class GameLevels {

    /*
    okay so basically this will handle the configurations of levels,
    and will return the parameters to be used to construct a level for the game
     */
    private ArrayList<ArrayList<ArrayList<Integer>>> levels;
    //3d arraylist containing level info

    //package-private
    GameLevels() {

        int[][][] arrLevels = {
                {{3, 1, 6}, {0, 3, 6}, {5, 0, 6}, {2, 2, 6}, {4, 1, 6}},
                {{1, 3, 7}, {6, 0, 7}, {3, 2, 7}, {0, 4, 7}, {5, 1, 7}},
                {{2, 3, 8}, {7, 0, 8}, {4, 2, 8}, {1, 4, 8}, {6, 1, 8}},
                {{3, 3, 8}, {0, 5, 8}, {8, 0, 10}, {5, 2, 10}, {2, 4, 10}},
                {{7, 1, 10}, {4, 3, 10}, {1, 5, 10}, {9, 0, 10}, {6, 2, 10}},
                {{3, 4, 10}, {0, 6, 10}, {8, 1, 10}, {5, 3, 10}, {2, 5, 10}},
                {{7, 2, 10}, {4, 4, 10}, {1, 6, 13}, {9, 1, 13}, {6, 3, 10}},
                {{0, 7, 10}, {8, 2, 10}, {5, 4, 10}, {2, 6, 10}, {7, 3, 10}}
        };

        /*
        basically all the levels as a 3d array, so it can be put in an arraylist.
        making the 3d arraylist directly looked more painful than justifiable,
        so it constructs it from this 3d array

        stuff in the array is stored in the format:
            int[level][configurations for the level][number of 2 cards, number of 3 cards, number of 0 (bomb) cards]

        also 3d arrayList time
         */

        levels = new ArrayList<>();

        //making the 3d 'levels' arraylist directly looked much more painful than justifiable,
        //so here's some for loops instead to make it
        int i = 0;
        int j;
        for (int[][] eachLevel: arrLevels){
            levels.add(new ArrayList<>()); //adds arrayList to levels
            j = 0;
            for (int[] configurations: eachLevel){
                levels.get(i).add(new ArrayList<>()); //adds arrayList to current arrayList of levels
                for (int value: configurations){
                    levels.get(i).get(j).add(value);
                    //adds current integer to current arrayList of currentArraylist of levels
                }
                j++;
            }
            i++;
        }
    }

    ArrayList<Integer> getLevelConfig(int level){
        //returns one random configuration for the current level of the player, passed as a parameter to makeBoard in FlipBoard

        int tempLevel = level - 1; //reduces level by 1 for purposes of easily getting it from the arraylist
        if (tempLevel > 7){
            tempLevel = 7; //there's only configurations for 8 levels so yeah final level repeats
            //however, there are lot of potential outcomes to the makeBoard() call for each configuration, so not a huge loss
        }
        ArrayList<ArrayList<Integer>> temp = levels.get(tempLevel); //extracts the configurations for the current level only
        Collections.shuffle(temp); //randomizes the configurations for the current level
        return temp.get(0); //gets the first configuration after the order was randomized
    }
}

