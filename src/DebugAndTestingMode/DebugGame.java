package DebugAndTestingMode;

import TheGame.Game;

public class DebugGame extends Game {

    //basically this starts the game but enables the 'debug' mode

    //this allows the user to see the board in advance, but they will be called out for cheating

    private DebugGame(){
        super();
        super.enableDebug();
    }

    public static void main(String[] args){
        new DebugGame();
    }
}
