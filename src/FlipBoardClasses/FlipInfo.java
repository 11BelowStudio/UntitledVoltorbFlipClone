package FlipBoardClasses;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createLineBorder;

public class FlipInfo extends FlipObject {

    //tracks the 'total' score and count of 'zeroes' for the row/column this FlipInfo object is on
    private final int total;
    private final int zeroes;

    //package-private
    FlipInfo(FlipBoard fb, int total, int zeroes){
        //initialization time
        super(fb);
        this.total = total;
        this.zeroes = zeroes;

        this.revealed = true; //always revealed so yeah its true


        this.setBorder(createLineBorder(Color.black));
        this.setBackground(new Color(246, 199, 0));
        //black border with yellow background for this

        this.setLayout(new GridLayout(2,1)); //2 vertically-aligned items

        JLabel totalLabel = new JLabel(String.valueOf(total), SwingConstants.CENTER);
        this.add(totalLabel);
        //JLabel to show the 'total' value centered in the top half of this panel

        JPanel bombInfo = new JPanel();
        bombInfo.setBackground(new Color(233, 118, 0));
        bombInfo.setLayout(new GridLayout(1,2));
        //bombInfo JPanel to hold info about bombs, with orange background, holding 2 elements, with same horizontal alignment

        BombPanel bombIcon = new BombPanel();
        bombInfo.add(bombIcon); //creates a BombPanel added to the left of the bombInfo panel

        String bombCount = String.valueOf(zeroes);
        if (zeroes == 1){
            bombCount += " Bomb";
        } else{
            bombCount += " Bombs";
        }
        JLabel bombLabel = new JLabel(bombCount);
        bombInfo.add(bombLabel);
        //creates and adds a label for the count of bombs, put to the right of the bombInfo panel

        this.add(bombInfo);
        //bombInfo panel added to this
    }

    @Override
    public String toString(){
        return "(" + total + "|" + zeroes + ")";
    } //string representation

    public void showContents(){}
    /*
    this is empty because the contents are shown by the constructor, so any method here would be redundant.
    You may be wondering 'why not have showContents only be a method of FlipCard then, and not FlipObject?'
    Well, the 'gameOver()' method of FlipBoard expects a 'showContents' method for all the FlipObjects
    in the ArrayList of FlipObjects, even if it won't be calling it for any FlipInfo FlipObjects,
    so, to avoid any exceptions being thrown from that, this empty method has been created.
    */
}
