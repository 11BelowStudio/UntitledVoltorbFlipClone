package TheGame;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    /*
    tbh the only reason this exists is because the assignment brief required the creation of this,
    even though the keyboard goes unused in the game I created

    yes this is pretty much copied from the sample code
    */


    KeyboardListener(){} //package-private btw, but there isn't really anything to construct here

    @Override
    public void keyTyped(KeyEvent e) {
        //well uhh basically nothing happens
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Congratulations you pressed the spacebar");
            //idk some functionality I guess to show it responding to a keyboard event
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //nothing happens here too
    }
}
