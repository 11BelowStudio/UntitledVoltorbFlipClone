package FlipBoardClasses;

import javax.swing.border.EtchedBorder;
import java.awt.*;

//a lot of this stuff is package-private
public abstract class FlipCard extends FlipObject {

    protected int value;
    private NotePanel notes;
    //value held by card and the NotePanel initially present on this card

    FlipCard(FlipBoard fb, int value){
        //initialisation
        super(fb);
        this.value = value;

        setLayout(new GridLayout(1,1));
        //the only component on this will fill all space


        this.setBackground(new Color(152, 202, 50));
        this.setBorder(new EtchedBorder());
        //green background with etchedBorder

        this.notes = new NotePanel(this);
        this.add(notes);
        //creates a NotePanel called 'notes', adds it to this panel
    }

    public void showContents(){
        this.remove(notes);
        this.revealed = true;
        //notes are removed, and this is revealed
    }

    public void showContentsIngame(){
        showContents();
        board.updateScore(value);
        //same as showContents, but making a call to update the current score too
    }

    public int getValue(){
        return value;
    } //returns the value of 'value'

    MouseClickListener getMouseListener(){
        return board.getMouseListener();
    }
    //obtains the mouseListener of 'board' (called by 'notes' when constructing the individual 'Note' items in it)

    @Override
    public String toString(){
        return "[" + value + "]";
    } //string representation
}
