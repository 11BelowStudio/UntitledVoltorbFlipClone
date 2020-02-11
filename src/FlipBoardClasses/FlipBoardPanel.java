package FlipBoardClasses;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class FlipBoardPanel extends JPanel {

    //package-private

    FlipBoardPanel(ArrayList<ArrayList<FlipObject>> theBoard){

        //basically it's a JPanel version of the 3D ArrayList of FlipObjects

        this.setLayout(new GridLayout(6,6,1,1));

        for (ArrayList<FlipObject> flipObjects : theBoard) {
            for (FlipObject flipObject : flipObjects) {
                this.add(flipObject);
            }
        }
    }



}
