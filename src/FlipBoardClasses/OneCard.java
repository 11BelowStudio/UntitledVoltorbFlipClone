package FlipBoardClasses;


import java.awt.*;

public class OneCard extends FlipPoints {

    //package-private
    OneCard(FlipBoard fb) {
        super(fb, 1);
    } //FlipPoints object with value of 1, basically

    public void showContents() {
        super.showContents(); //calls FlipPoints.showContents()
        this.setBackground(new Color(247, 242, 212));
        theValue.setForeground(new Color(43, 38, 8));
        //light grey background with dark grey text, suitably mundane for this somewhat mundane outcome
    }
}
