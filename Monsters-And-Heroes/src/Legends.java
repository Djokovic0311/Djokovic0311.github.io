//Main class for Legends -> extends RPGGame
import java.util.Scanner;
import java.io.File;
import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;

public class Legends extends RPGGame{
    //variables
    private LegendBoard board;
    private HeroFactory heroFactory;
    private final Scanner myScanner;
    private Utils utils;

    //default constructor
    public Legends(){
        myScanner = new Scanner(System.in);
        utils = new Utils(myScanner);
    }
    //game begin
    public void playGame(){
        //while the game is not ever yet
        System.out.println("Welcome to Legends: Monsters and Heroes!");
        //generate map
        //create a board with default value
        board = new LegendBoard();
        //set up player

    }

    //a player's turn that shows them their current options
    public void playerTurn(){

    }

    //print the current options for the player
    public void printMoveOptions(){
        System.out.println("-------------------------");

        System.out.println("-------------------------");
    }
}
