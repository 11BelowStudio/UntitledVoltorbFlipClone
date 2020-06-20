package FlipBoardClasses;

import javax.swing.*;
import java.awt.*;

class Note extends JPanel {

    private final FlipCard card; //Record of what FlipCard object this Note is on
    private final JLabel noteLabel; //a JLabel
    private final String noteText; //the text that may be shown/hidden on noteLabel
    private boolean flagged; //tracks whether or not the noteText should be shown

    Note(FlipCard card, String contents, boolean darker){
        //initialisation time
        this.card = card;
        this.flagged = false;
        noteText = contents;

        noteLabel = new JLabel("",SwingConstants.CENTER);
        this.add(noteLabel); //blank JLabel added to middle of the note

        //a e s t h e t i c s
        if (darker){
            this.setBackground(new Color(107, 143, 36));
            noteLabel.setForeground(Color.lightGray.brighter());
            //dark green with light grey text if this is a 'darker' note
        } else{
            this.setBackground(new Color(152, 202, 50));
            noteLabel.setForeground(Color.darkGray.darker());
            //light green with dark grey text if this is not a 'darker' note
        }
    }

    void flag(){
        if (flagged){
            this.flagged = false;
            hideNote();
            //hides the note if it currently is flagged, marks it as not flagged
        } else{
            this.flagged = true;
            showNote();
            //shows the note if it's currently hidden, marks it as flagged
        }
    }

    private void showNote(){ noteLabel.setText(noteText); }
    //sets the noteLabel text to show noteText if this note is to be shown

    private void hideNote(){ noteLabel.setText(""); }
    //the noteLabel is made blank to hide it

    void showContentsIngame(){ card.showContentsIngame(); }
    //calls the showContentsIngame() method of the FlipCard this note is on

    boolean isRevealed(){ return card.isRevealed(); }
    //returns the result of the isRevealed() method of the FlipCard this note is on
}
