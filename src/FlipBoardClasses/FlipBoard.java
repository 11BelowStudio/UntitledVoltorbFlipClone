package FlipBoardClasses;

import TheGame.Game;

import java.util.ArrayList;
import java.util.Collections;

public class FlipBoard {

    private ArrayList<ArrayList<FlipObject>> grid;
    //a 2d ArrayList of FlipObject items

    private int amountToFind;
    //records the number of 2 and 3 cards that must be found with the current configuration of 'grid'

    private final Game game;
    //Reference to the 'Game' object that called this

    private final MouseClickListener mouseListener;
    //A 'MouseClickListener' object, which implements 'MouseListener'

    private final GameLevels theLevels;
    //A 'GameLevels' object, which is used to store/obtain information about level configurations


    public FlipBoard(Game game) {
        this.game = game;
        //reference to the Game object that constructed this
        mouseListener = new MouseClickListener();
        /*
        a MouseClickListener implementation of MouseListener
        to allow the user to interact with the various FlipCard objects
        (as well as the Note objects on the FlipCard objects)
        contained in the 2d ArrayList of FlipObjects constructed in makeBoard
        */

        theLevels = new GameLevels();
        //constructs 'theLevels', so it can actually be used
    }


    private void makeBoard(ArrayList<Integer> values){

        /*
        An ArrayList of integer objects is passed here,
        with the structure {number of 2 cards, number of 3 cards, number of 0 cards}
        */
        int two = values.get(0);
        int three = values.get(1);
        int zero = values.get(2);
        //'two','three', and 'zero' initialised appropriately

        ArrayList<Integer> shuffleList = new ArrayList<>();
        /*
        Holds integer representations of the items which will be held by 'grid'
        The appropriate number of 0s, 1s, 2s, and 3s will be added to this,
        with a total of 25 items being held in it.
        It will then be shuffled, and then sub-lists of this will be used
        for the construction of 'grid'
         */

        amountToFind = two + three;
        //this is the total number of '2' and '3' cards in the grid
        //the player must find all of them in order to complete the level

        int i = 0;
        while (i < two){
            shuffleList.add(2);
            i++;
        }
        i = 0;
        while (i < three){
            shuffleList.add(3);
            i++;
        }
        i = 0;
        while (i < zero){
            shuffleList.add(0);
            i++;
        }
        while (shuffleList.size() < 25){
            shuffleList.add(1);
            i++;
        }

        Collections.shuffle(shuffleList);

        ArrayList<ArrayList<Integer>> intGrid = new ArrayList<>();
        /*
        'grid' but for integer values of the 'FlipCard' items only, basically
        It is used to assist in the construction of the 'grid',
        helping to extract sub-lists of shuffleList,
        and using them appropriately
         */
        grid = new ArrayList<>();
        //this one is the one that actually matters



        int[] colTotal = {0,0,0,0,0};
        int[] colZeroes = {0,0,0,0,0};
        /*
        ongoing counts of the sum of values/count of zeroes for the objects in each column.
        the sum of values/count of zeroes for each row can be monitored on a row-by-row basis,
        so they don't need a somewhat persistent array to keep track of each of them
        */

        i = 0;
        int current;

        while (i < 5){
            intGrid.add(new ArrayList<>(shuffleList.subList(i * 5, (i + 1) * 5)));
            //extracts the next 5 items from shuffleList, adding them as an ArrayList to intGrid
            ArrayList<Integer> temp = intGrid.get(i); //gets that list from intGrid
            grid.add(new ArrayList<>()); //adds empty ArrayList to 'grid'

            /*
            I know that technically each ArrayList in 'grid'/'intGrid' are their own element,
            however, as they effectively work as 'rows' if we treat grid/intGrid as 2d arrays,
            I will be referring to each of them as a 'row' of 'grid'/'intGrid'
            (gets the point across easier I guess)
            */

            //resets these for the new row
            int total = 0;
            int zeroes = 0;
            int j = 0;

            while (j < 5){ //for everything in the current row, basically
                current = temp.get(j); //current = current item
                /*
                and now, it will add a FlipCard object to the current row of Grid,
                according to what the current integer in the temp ArrayList is

                ZeroCard, OneCard, and GoodCard all extend FlipCard,
                which itself extends FlipObject
                */

                if (current == 0){
                    zeroes++;
                    colZeroes[j]++;
                    grid.get(i).add(new ZeroCard(this));
                    /*
                    If the current item is a 0
                        Increase the count of zeroes for the row/column by 1
                        Add a ZeroCard object to the current row of grid
                    */
                } else{
                    total += current;
                    colTotal[j] += current;
                    //if it's not a 0, increase the total counts for row/column by the current item
                    if (current == 1){
                        grid.get(i).add(new OneCard(this));
                        //add a 'OneCard' to current row of 'grid' if current is 1
                    } else{
                        grid.get(i).add(new GoodCard(this, current));
                        //add a GoodCard to current row of 'grid' if current is 2 or 3
                    }
                }
                grid.get(i).get(j).addMouseListener(mouseListener);
                //adds a mouseListener to the FlipCard (whether a ZeroCard, OneCard, or GoodCard) that was added
                j++;
            }
            grid.get(i).add(new FlipInfo(this,total,zeroes));
            /*
            Adds a 'FlipInfo' object to 'grid', at the end of the current row
            It contains the total sum and the count of zeroes for this row as attributes.
            */
            i++;
        }

        grid.add(new ArrayList<>()); //adds a 6th row to the 'grid' array (yes I know its just adding another ArrayList element)
        i = 0;
        while (i < 5){
            /*
            Uses the values recorded in the colTotal and colZeroes arrays to construct a FlipInfo
            object for each column of FlipCard items in the previous rows of 'grid'
             */
            grid.get(5).add(new FlipInfo(this,colTotal[i],colZeroes[i]));
            i++;
        }


    }

    //This is used by FlipCard to assist in constructing a Notes object
    MouseClickListener getMouseListener(){return mouseListener;}


    /* The only function in this which is called by the 'game' object */
    public FlipBoardPanel makeThePanel(int levelNumber){
        /*
        obtains a level configuration for the current level from theLevels,
        uses this to call makeBoard,
        then constructs a flipBoardPanel with the new state of 'grid',
        which is then returned
         */
        makeBoard(theLevels.getLevelConfig(levelNumber));
        return new FlipBoardPanel(grid);
    }




    /* Functions that are used by FlipObjects to call functions of the 'game' object */

    void updateScore(int value){ game.updateScore(value);}
    //called when a FlipCard object (or a Note of a FlipCard) is left-clicked, updates non-banked score appropriately

    void foundGoodCard(){
        //called when a GoodCard object is clicked, decreases amountToFind by 1, and checks if there are any left to find
        this.amountToFind--;
        if (this.amountToFind == 0) {
            game.wonLevel();
            //calls wonLevel method of 'game' if level is complete (all GoodCards found)
        }
    }

    void gameOver(){
        //called by ZeroCard being clicked, will reveal the contents of all the FlipCards that were not yet revealed
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (!grid.get(y).get(x).isRevealed()) {
                    grid.get(y).get(x).showContents();
                    //showContents() merely shows FlipCard contents: showContentsIngame() methods perform the additional operations
                }
            }
        }
        //now calls the gameOver method of 'game' because the game is now over
        game.gameOver();
    }


    //this returns a String representation of the 'grid' object, mainly exists for testing purposes I guess
    @Override
    public String toString(){
        StringBuilder outString = new StringBuilder();
        int i = 0;
        while (i < 6){
            outString.append(grid.get(i).toString());
            outString.append("\n");
            i++;
            /*basically just adds each arrayList in 'grid', followed by a newline,
            to the string being built by the outString StringBuilder*/
        }
        return outString.toString();
    }

}
