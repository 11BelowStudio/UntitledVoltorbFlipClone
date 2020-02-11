package FlipBoardClasses;

import java.awt.*;

public class GoodCard extends FlipPoints {

    //package-private
    GoodCard(FlipBoard fb, int value) {
        super(fb, value);
    } //calls FlipPoints constructor


    public void showContents() {
        super.showContents(); //calls FlipPoints showContents()
        if (value == 2){
            //green colour scheme for a '2' card
            this.setBackground(new Color(228, 241, 50));
            theValue.setForeground(new Color(112, 119, 8));
        } else{
            //yellow colour scheme for a '3' card
            this.setBackground(new Color(253, 220, 34));
            theValue.setForeground(new Color(50, 43, 1));
        }

    }

    public void showContentsIngame(){
        super.showContentsIngame(); //calls FlipPoints showContentsIngame()
        showContents(); //calls this object's showContents method
        board.foundGoodCard(); //calls 'foundGoodCard()' method of the flipBoard
    }
}
