package FlipBoardClasses;

import javax.swing.*;

public abstract class FlipPoints extends FlipCard {


    //constructor and theValue are package-private
    JLabel theValue;

    FlipPoints(FlipBoard fb, int value) {
        super(fb, value);
        theValue = new JLabel(String.valueOf(value),SwingConstants.CENTER);
        /*
        has a JLabel called 'theValue',
        containing the value of this card,
        which would be displayed in the middle of the panel.
        Only displayed when showContents() for this object is called
        */
    }

    public void showContents() {
        //same as FlipCard showContents() but theValue is added (and this is revalidated)
        super.showContents();
        this.add(theValue);
        revalidate();
    }
}
