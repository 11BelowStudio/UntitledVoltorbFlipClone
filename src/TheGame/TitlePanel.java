package TheGame;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class TitlePanel extends JPanel {

    private final Game game; //reference to the parent Game object that called this

    TitlePanel(Game g) { //package-private

        //setting up reference to the game and giving this panel a borderLayout
        this.game = g;
        this.setLayout(new BorderLayout());

        TitleImagePanel imagePanel = new TitleImagePanel();
        this.add(imagePanel, BorderLayout.CENTER);
        //constructs a TitleImagePanel, added to the middle of this panel


        //creates a new JPanel to hold some buttons, and creates the buttons
        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start the game");
        JButton scoreButton = new JButton("See high scores");
        JButton creditsButton = new JButton("View the credits");
        JButton instructionsButton = new JButton("View the instructions");


        startButton.addActionListener(e -> game.startGame()); //starts game when pressed
        scoreButton.addActionListener(e-> game.showHighScores()); //shows high scores when pressed
        creditsButton.addActionListener(e -> this.showCredits()); //shows credits when pressed
        instructionsButton.addActionListener(e -> this.showInstructions()); //shows instructions when pressed

        //buttons added to the ButtonPanel JPanel
        buttonPanel.add(startButton);
        buttonPanel.add(scoreButton);
        buttonPanel.add(creditsButton);
        buttonPanel.add(instructionsButton);

        this.add(buttonPanel, BorderLayout.SOUTH);//buttonPanel added to the bottom of this panel
        this.revalidate();
    }

    private void showCredits() {
        //shows a JOptionPane with the credits
        JOptionPane.showMessageDialog(this,
                "CREDITS\n\n"
                        +"Programming, Art, etc:\n"
                        +"* 11BelowStudio\n\n"
                        +"Original game concept:\n"
                        +"* This game is essentially a recreation of the 'Voltorb Flip' minigame from the non-Japanese versions of\n"
                        +"  Pokemon HeartGold and Pokemon SoulSilver (developed by Game Freak, published by Nintendo, 2010).\n"
                        +"  Further information about it can be read here: https://bulbapedia.bulbagarden.net/wiki/Voltorb_Flip\n\n"
                        +"* I have made a few minor changes to it (different visuals, different note-taking method, adding an\n"
                        +"  extra element of risk vs reward with the scores, etc), however, for all intents and purposes,\n"
                        +"  this game is pretty much a copy of that game.",
                "The credits",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void showInstructions(){
        //shows a JOptionPane with instructions for playing the game
        JOptionPane.showMessageDialog(this,
                "HOW TO PLAY\n\n"
                        +"The objective:\n"
                        +"* Reveal all of the '2' and '3' cards on the board.\n"
                        +"      You don't need to reveal the '1' cards, but you can reveal them if you want to\n"
                        +"* Avoid revealing any bomb cards.\n"
                        +"      They will explode in your face, and you will look very silly when that happens.\n"
                        +"* Get a high score or something I guess\n\n"
                        +"Things that may help you to not lose:\n"
                        +"* Every row/column has a panel with information about what is in the row.\n"
                        +"      It shows the sum of the values of the point cards in that row/column,\n"
                        +"      as well as the count of bombs in that row/column.\n"
                        +"* Right-clicking the squares for the checkerboard pattern on each card\n"
                        +"  will allow you to take a note of what you think each card holds.\n"
                        +"      Top-left: bomb, top-right: 1, bottom-left: 2, bottom-right: 3.\n"
                        +"      Right-clicking that square again will hide that note again.\n\n"
                        +"How to get a high score\n"
                        +"* Revealing a card will multiply your current score by the amount on that card\n"
                        +"      However, a bomb card counts as a 'x0' multiplier for your score, and will end the game.\n"
                        +"* After you have completed a level, you will have the option to 'bank' your score.\n"
                        +"      If you choose to 'bank' it, your current score will be added to your 'banked' score,\n"
                        +"      and your current score will be reset to 0.\n"
                        +"      However, only your 'banked' score counts towards your final score when you lose the game,\n"
                        +"      so you should bear that in mind if you're going for a high score.\n"
                        +"\n",
                "How to play the game",
                JOptionPane.PLAIN_MESSAGE);
    }
}
