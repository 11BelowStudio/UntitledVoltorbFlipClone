package FlipBoardClasses;

import javax.swing.*;
import java.awt.*;

public class BombPanel extends JPanel{

    /*
    This is a JPanel which basically allows a BombShape object to be drawn on it

    A BombShape object is initialised in the constructor with default values.

    However, whenever this component is drawn, the overridden PaintComponent method
    will try to update the size of the BombShape object relative to the size of this panel.
    The resized BombShape object is then drawn on this panel.
     */

    private final BombShape bomb; //the BombShape which is drawn


    //constructor and updateSize are package-private btw
    BombPanel() {
        bomb = new BombShape();
        //the BombShape is constructed, using some default values
    }


    void updateSize(){
        int bombSize;

        Dimension size = this.getSize();
        if (size.getWidth() > size.getHeight()){
            bombSize = (int)(size.getHeight()*0.8);
        } else{
            bombSize = (int)(size.getWidth()*0.8);
        }
        //the bounding box for the bomb shape is 80% of the size of the smallest 2d dimension of this panel

        int x = (int)((size.getWidth() - bombSize)/2);
        int y = (int)((size.getHeight() - bombSize)/2);
        /*
        finds the upper-right corner which can be used to construct a a bombShape of size bombSize,
        so it can be centered relative to this panel
        */

        bomb.updateSize(x,y,bombSize);
        //the BombShape's dimensions are updated
    }

    @Override
    public void paintComponent(Graphics g){
        //updates the size of and draws bomb.
        // called whenever this panel is resized too, allowing for automatic resizing of the bomb
        updateSize();
        bomb.draw(g);
    }

}
