package TheGame;

import javax.swing.*;

public class AttributeLabel extends JLabel {

    /*
    This is a custom JLabel which can be used to show a value with a bit of text
    bit easier than trying to include methods to completely rewrite each label individually
    whenever the value is updated by any amount, y'know?
    */

    private String attributeName;
    //holds the name of the attribute that this AttributeLabel is keeping track of

    private int value;
    //holds the value of the attribute that this AttributeLabel is keeping track of

    private AttributeLabel(String attributeName){
        //constructor without a set value to associate to the attribute name on the label
        this.attributeName = attributeName;
        this.setText(this.attributeName);
    }

    AttributeLabel(String attributeName, int value){
        //calls attributeName constructor then showValue with the value parameter
        //package-private btw
        this(attributeName);
        showValue(value);
    }

    void showValue(int value){
        this.value = value;
        this.setText(attributeName + this.value);
    }
    //updates the text on the label to show the new value, and updates the associated value attribute
    //package-private btw

    public int getValue(){
        return value;
    }
    //returns the 'value' attribute of this object



}
