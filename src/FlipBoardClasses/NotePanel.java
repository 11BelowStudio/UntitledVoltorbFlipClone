package FlipBoardClasses;

import javax.swing.*;
import java.awt.*;

class NotePanel extends JPanel {

    //allows the user to take notes of what they think the card this NotePanel is on contains

    //package-private
    NotePanel(FlipCard card){

        //2*2 grid layout, light green background
        this.setLayout(new GridLayout(2,2,0,0));
        this.setBackground(new Color(152, 202, 50));


        /*
        creates 4 Note items, with reference to the FlipCard this NotePanel is on
        can be used to mark whether the player suspects that the FlipCard may have
        a bomb, 1 point, 2 points, or 3 points.

        'darker' is used to provide a checkerboard pattern
        */
        Note noteBomb = new Note(card, "Bomb", false);
        Note noteOne = new Note(card, "1", true);
        Note noteTwo = new Note(card, "2", true);
        Note noteThree = new Note(card, "3", false);

        //mouseListener added to the Note objects
        noteBomb.addMouseListener(card.getMouseListener());
        noteOne.addMouseListener(card.getMouseListener());
        noteTwo.addMouseListener(card.getMouseListener());
        noteThree.addMouseListener(card.getMouseListener());

        //Note objects added to this NotePanel
        this.add(noteBomb);
        this.add(noteOne);
        this.add(noteTwo);
        this.add(noteThree);

        //revalidates this panel
        this.revalidate();
    }

}
