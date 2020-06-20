package FlipBoardClasses;


import java.awt.*;

public class ZeroCard extends FlipCard {

    private final BombPanel theBomb; //a BombPanel object

    //package private
    ZeroCard(FlipBoard fb){
        super(fb, 0); //flipCard object with value 0
        theBomb = new BombPanel(); //constructs a BombPanel called 'TheBomb'
    }


    public void showContents() {
        //same as FlipCard but theBomb is added, size updated, background now red
        super.showContents();
        this.add(theBomb, BorderLayout.CENTER);
        theBomb.updateSize();
        this.setBackground(Color.RED);
        this.revalidate();
    }

    public void showContentsIngame(){
        super.showContentsIngame(); //calls FlipCard showContentsIngame() method
        showContents(); //calls this object's showContents() method
        board.gameOver(); //gameOver method of the FlipBoard is called

        //probably should mention that having this get called is pretty much the lose condition for the game
    }
}
