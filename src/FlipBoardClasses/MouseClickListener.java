package FlipBoardClasses;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//these are used to tell the difference between left click and right click events
import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

public class MouseClickListener implements MouseListener {

    //yes, this was pretty much taken from the sample code

    MouseClickListener() {
        //nothing to really construct tbh
        //package-private btw
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isLeftMouseButton(e)){
            //if something is left-clicked
            if (e.getSource() instanceof FlipCard){
                //if it's a FlipCard which hasn't been revealed, it calls the showContentsIngame() method of it
                if (!((FlipCard) e.getSource()).isRevealed()){
                    ((FlipCard) e.getSource()).showContentsIngame();
                }
            } else if(e.getSource() instanceof Note){
                //if it's a Note on a FlipCard which hasn't been revealed, it calls the showContentsIngame() method of it
                if (!((Note) e.getSource()).isRevealed()){
                    ((Note) e.getSource()).showContentsIngame();
                }
            }
        } else if (isRightMouseButton(e)){
            //if a Note has been right-clicked, it calls that Note's 'flag' method
            if (e.getSource() instanceof Note){
                ((Note) e.getSource()).flag();
                //basically allows the player to take notes of what they think the card is
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //yeah basically nothing happens for this
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //same
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //that tbh
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //I think you can probably see a pattern here
    }
}
