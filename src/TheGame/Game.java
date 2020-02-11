package TheGame;

import FlipBoardClasses.FlipBoard;
/*
Basically, TheGame (the package this is in) holds the game logic and such,
whilst FlipBoardClasses holds the classes and such that make up the game
Anything in FlipBoardClasses that needs to communicate with this does so via a FlipBoard object
Additionally, this can obtain the necessary stuff from FlipBoardClasses via a FlipBoard object

also this is called by the 'main' method in 'MainClassIsHere.MainClass' btw
*/

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    private TitlePanel theTitle;
    //A TitlePanel object, for the title screen

    private JPanel gameInfo;
    //A JPanel object, to show information about the player's current game to the player
    private JPanel gamePanel;
    //a JPanel that holds the bits that the user interacts with in the game
    //technically it's a FlipBoardClasses.FlipBoardPanel object, but that extends JPanel, so uhh yeah


    private HighScoreHandler highScores;
    //used to process reading/saving high scores


    private int score;
    private AttributeLabel scoreLabel;
    //score holds the current score, scoreLabel is responsible for displaying it

    private int bankedScore;
    private AttributeLabel bankLabel;
    //ditto but for the banked score (the score which goes towards the high score)

    private int level;
    private AttributeLabel levelLabel;
    //ditto but for the current level of the game


    private FlipBoard fb;
    //a FlipBoard object (boundary for FlipBoardClasses package)

    private boolean firstFlip;
    //tracks whether or not the current 'card flip' action is the first action taken by the user

    private boolean debugMode;
    //records whether or not this is being run in debug mode


    public Game(){

        this.debugMode = false;

        //basically sets stuff up

        this.setTitle("Untitled Game Unrelated To Minesweeper #1804170");
        //casually shoehorning in my registration number into the game's title

        this.setLayout(new BorderLayout());
        //setting up the title and the layout manager for this frame

        score = 0;
        bankedScore = 0;
        level = 1;
        //scores start at 0, levels start at 1


        highScores = new HighScoreHandler();
        //'highScores' is used to deal with high scores and such

        fb = new FlipBoard(this);
        //'fb' is a FlipBoard object, used for setting up and handling a lot of backend stuff

        addKeyListener(new KeyboardListener());

        showTitle(); //sets up title screen panel

        this.revalidate();
        this.pack();
        setPreferredSize(this.getSize());

        setVisible(true); //this frame is made visible


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //terminates program when window closed
    }

    private void showTitle(){
        if (theTitle!= null){
            this.remove(theTitle);
            theTitle = null;
        } //removes theTitle if it already exists

        theTitle = new TitlePanel(this);
        this.add(theTitle,BorderLayout.CENTER);
        //TheTitle is created and added to this frame, in the middle of it
    }


    void startGame(){
        //called when the user presses 'startButton' on TitlePanel
        if (theTitle!= null){
            this.remove(theTitle);
            theTitle = null;
        } //removes the TitlePanel

        setupGameInfo(); //initialises the GameInfo JPanel
        initGame(true); //initialises the gamePanel FlipBoardPanel

        setSize(new Dimension(800,600));
        setPreferredSize(this.getSize());
        //size set to 600 by 800 because the game looks decent at that size tbh
    }


    private void setupGameInfo(){
        //will now setup the GameInfo panel which goes above the game area

        //removes any existing gameInfo panel
        if (gameInfo != null){
            this.remove(gameInfo);
            gameInfo = null;
        }

        //actually sets up the gameInfo panel, using AttributeLabel objects, creating+initialising them
        gameInfo = new JPanel(new GridLayout(1,3));
        scoreLabel = new AttributeLabel("Score: ",0);
        bankLabel = new AttributeLabel("Banked score: ",0);
        levelLabel = new AttributeLabel("Level: ",1);
        gameInfo.add(levelLabel);
        gameInfo.add(bankLabel);
        gameInfo.add(scoreLabel);

        this.add(gameInfo, BorderLayout.NORTH);
    }

    private void initGame(boolean pointsBanked){

        //removes the gamePanel panel if it already exists
        if (gamePanel != null){
            this.remove(gamePanel);
            gamePanel = null;
        }


        gamePanel = fb.makeThePanel(level);
        /*
        gamePanel is the FlipBoardPanel returned by the makeThePanel method of 'fb',
        (with the current level as a parameter of that method)
        FlipBoardPanel extends JPanel so it can be treated as JPanel, which is what is happening here
        */


        if (pointsBanked){ //if the player chose to bank their points
            addToBankedScore();
            setScore(0);
            firstFlip = true;
            //adds score to bankedScore, resets score, and sets firstFlip to true
        }


        this.add(gamePanel, BorderLayout.CENTER);
        //GamePanel added to the Center area of this frame

        this.revalidate();
        this.repaint();
        //makes sure all the components are in the correct positions/the correct size

        if (debugMode){
            //will output the board if the user is in debug mode
            System.out.println("\nboard config:");
            System.out.println(fb);
            System.out.println("don't cheat pls\n");
        }
    }


    public void gameOver(){
        System.out.println("F"); //press F to pay respects
        setScore(0); //score is set to 0
        highScores.recordHighScore(bankedScore);
        //updates the record of high scores appropriately (and outputs final banked score to the user)
        showHighScores(); //high scores shown to user
        level1(); //reset to level 1
        resetBanked(); //banked points reset
        initGame(true); //gamePanel remade for a new game
    }


    void showHighScores(){ //package-private btw
        //pretty much just creates a JOptionPane to show a record of the top 5 scores, using the toString method of highScores
        JOptionPane.showMessageDialog(this, "Top 5 High Scores:\n\n" + highScores.scoresToString(), "Leaderboard", JOptionPane.PLAIN_MESSAGE);
    }


    public void updateScore(int cardValue){
        if (firstFlip) {
            firstFlip = false;
            setScore(cardValue);
            //firstFlip is made false and score is set to cardValue if this was the first card revealed
        } else {
            multiplyScore(cardValue);
            //score multiplied by cardValue if this was not the first card revealed
        }
    }


    //checks to see if you have won the game
    public void wonLevel(){

        System.out.println("A winner is you"); //console message


        String[] options = {"Bank them", "Risk them"}; //custom text for JOptionPane buttons

        int bankPoints = JOptionPane.showOptionDialog(this,
                "Would you like to bank your points?\n"
                        +"Or would you like to risk them for an even higher score?\n"
                        +"Remember that only your banked points are recorded on the leaderboard!",
                "Congratulations!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        //asks the user if they want to bank their points or not

        nextLevel(); //level increased by 1

        //next level is initialised appropriately depending on whether or not they pressed the 'bank them' button
        if (bankPoints == 0){
            initGame(true);
            //if they did choose to bank them
        } else{
            initGame(false);
            //if they chose to not bank them, or simply closed the optionDialog
        }
    }



    private void multiplyScore(int multiplier){
        this.score *= multiplier;
        updateScoreLabel();
        //score multiplied by the multiplier, scoreLabel updated appropriately
    }


    private void setScore(int score){
        this.score = score;
        updateScoreLabel();
        //score set to the passed value, scoreLabel updated appropriately
    }

    private void updateScoreLabel(){
        scoreLabel.showValue(score);
    }
    //calls the showValue method of scoreLabel to make it show the current value of 'score'

    private void addToBankedScore(){
        this.bankedScore += this.score;
        setScore(0);
        updateBankLabel();
        //score added to bankedScore, score set to 0, bankLabel adjusted appropriately
    }

    private void resetBanked(){
        this.bankedScore = 0;
        updateBankLabel();
        //bankedScore set to 0, bankLabel adjusted appropriately
    }

    private void updateBankLabel(){
        bankLabel.showValue(bankedScore);
    }
    //calls the showValue method of bankLabel to make it show the current value of 'bankedScore'


    private void nextLevel(){
        this.level++;
        updateLevelLabel();
        //increases the level by 1, levelLabel adjusted appropriately
    }

    private void level1(){
        this.level = 1;
        updateLevelLabel();
        //level set to 1, levelLabel adjusted appropriately
    }

    private void updateLevelLabel(){
        levelLabel.showValue(level);
    }
    //calls the showValue method of levelLabel to make it show the current value of 'level'

    protected void enableDebug(){
        this.debugMode = true;
        highScores.haxDetected();
        System.out.println("Testing mode enabled!");
        //enables debug mode, informs highScores object about it being on
    }


}
