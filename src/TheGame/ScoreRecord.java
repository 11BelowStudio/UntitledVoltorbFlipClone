package TheGame;

public class ScoreRecord implements Comparable<ScoreRecord> {

    //basically contains a String object to hold a player's name, and an Integer object to hold their score
    private String name;
    private Integer theScore;

    //pls note that the constructors are package-private

    ScoreRecord(String scoreName, String score){
        //this constructor is called when HighScoreHandler is reading from the high score file
        setName(scoreName); //attempts to initialise their name
        try {
            //attempts to get an Integer theScore from the String score
            this.theScore = Integer.parseInt(score);
        } catch (Exception e){
            //sets theScore to 0 if it fails
            this.theScore = 0;
        }
    }

    ScoreRecord(String scoreName, int score) {
        //this constructor is called when HighScoreHandler is constructing a score achieved by the current player
        setName(scoreName); //attempts to initialise their name
        this.theScore = score; //theScore set to value of score
    }

    private void setName(String scoreName){
        if (scoreName == null ||  scoreName.isEmpty()){
            this.name = "unknown"; //name set to unknown if scoreName is empty
        } else{
            this.name = scoreName; //otherwise name set to scoreName
        }
    }

    Integer getScore(){
        return theScore;
    } //returns 'theScore' of this ScoreRecord


    @Override
    public String toString(){
        return name + "\n" + theScore + "\n";
        //name on first line of string, theScore on 2nd line, and followed by a newline
    }


    @Override
    public int compareTo(ScoreRecord o) {
        return this.getScore().compareTo(o.getScore());
        //compares the 'theScore' value of this to the 'theScore' value of the other ScoreRecord
    }

}
