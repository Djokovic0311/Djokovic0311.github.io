//base class for a game
public class Game {
    protected volatile boolean isOver;
    //default constructor
    public Game(){
        isOver = false;
    }
    //default method to play game
    //continues until game is over
    public void playGame(){
        while(!isOver){
            continue;
        }
        System.out.println("Game Over!");
    }

    //getter and setter

}
