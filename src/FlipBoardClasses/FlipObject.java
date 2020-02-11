package FlipBoardClasses;

import javax.swing.*;

public abstract class FlipObject extends JPanel {

    /*
    FlipObject is the superclass of FlipCard and FlipInfo

    Basically has a reference to the FlipBoard it was built by,
    and whether it is revealed or not.

    It has a concrete method to return the value of it's 'revealed' attribute,
    as well as an abstract 'showContents()' method to show its contents

    also everything but showContents() is package-private
    */

    FlipBoard board;
    boolean revealed;

    FlipObject(FlipBoard fb){
        this.board = fb; //reference to the object that called it
        revealed = false; //it's not revealed so yeah it's false
    }


    boolean isRevealed(){
        return revealed;
    }
    //does what it says on the tin tbh

    public abstract void showContents();
    //implemented by subclasses
}
