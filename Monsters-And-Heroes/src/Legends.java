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
        chooseHeroes();
        System.out.println(heroFactory);
        System.out.println("Let the Adventure begin!!");
        System.out.println("");
        System.out.println(board);
        while (!isOver){
            //player turn
            playerTurn();
        }
        System.out.println("Game is Over!");
    }

    //a player's turn that shows them their current options
    public void playerTurn(){
        //check current Space and if it's a market then prompt whether to go inside
        Space curSpace = board.getSpace(heroFactory.getXLoc(), heroFactory.getYLoc());
        if(curSpace instanceof MarketSpace){

        }
        printMoveOptions();
        checkMoveOption();
    }

    //check if the player can go there and if so then move the player
    public void checkMoveOption(){
        String option = utils.getCharInput();
        int currX = heroFactory.getXLoc(); int currY = heroFactory.getYLoc();
        //check if it is any of our input options

        switch (option){
            case moveUP:
                if(board.canGo(currX-1, currY)){
                    playerMove(currX,currY);
                }
                else {
                    checkMoveOption();
                }
                break;
            case moveLEFT:
                if(board.canGo(currX, currY-1)){
                    playerMove(currX,currY-1);
                }
                else {
                    checkMoveOption();
                }
                break;
            case moveDOWN:
                if(board.canGo(currX+1, currY)){
                    playerMove(currX+1,currY);
                }
                else {
                    checkMoveOption();
                }
                break;
            case moveRIGHT:
                if(board.canGo(currX, currY+1)){
                    playerMove(currX,currY+1);
                }
                else {
                    checkMoveOption();
                }
                break;
            case quitGame:
                isOver = true;
                break;
            case showInfo:
                System.out.println();
            case moveUP:
                if(board.canGo(currX-1, currY)){
                    playerMove(currX,currY);
                }
            case moveUP:
                if(board.canGo(currX-1, currY)){
                    playerMove(currX,currY);
                }
            case moveUP:
                if(board.canGo(currX-1, currY)){
                    playerMove(currX,currY);
                }
        }
    }

    //print the current options for the player
    public void printMoveOptions(){
        System.out.println("-------------------------");
        System.out.println("Type " + moveUP + " to move up.");
        System.out.println("Type " + moveLEFT + " to move left.");
        System.out.println("Type " + moveDOWN + " to move down.");
        System.out.println("Type " + moveRIGHT + " to move right.");
        System.out.println("Type " + showInfo + " to show info.");
        System.out.println("Type " + quitGame + " to quit.");
        System.out.println("Type " + showInv + " to manage inventory.");
        System.out.println("Type " + showMap + " to show the Map");
        System.out.println("-------------------------");
    }

    //move and update the player's position
    public void playerMove(int x, int y){
        heroFactory.setPos(x, y);
        board.updatePlayer(x,y);
        System.out.println(board); //show the updated board
        if (board.getSpace(x,y) instanceof CommonSpace){
            Random rand = new Random();
            int encounterChance = 3;
            int SpaceNum = rand.nextInt(encounterChance);
            if(SpaceNum == 0){

            }
        }

    }

    //allow the user to choose heroes at the beginning of the game
    public void chooseHeroes(){
        System.out.println("How many heroes would you like to join in your party?");
        int MAX_HEROES = 3;
        System.out.println("Max is " + MAX_HEROES);
        int numHeroes = utils.getIntInput(1, MAX_HEROES);
        heroFactory = new HeroFactory(numHeroes);
        for(int x=0; x<numHeroes; x++){
            addHero(x);
        }
    }

    //add a hero to the party
    public void addHero(int index){
        System.out.println("");
        System.out.println("Which type of hero would you like?");
        System.out.println("Warrior = 1, Sorcerer = 2, Paladin = 3");
        int choice = utils.getIntInput(1,3);
        System.out.println("YOUR CHOICE IS " + choice);
        int input;
        String heroString = "";

        String warriorPath = "./Warriors.txt";
        String sorcererPath = "./Sorcerers.txt";
        String paladinPath = "./Paladins.txt";

        switch (choice) {
            case 1:
                System.out.println("Please select a Warrior with his number");
                System.out.println("");
                utils.printFile(warriorPath);
                int fileLength = utils.getFileLength(warriorPath);
                System.out.println(fileLength);
                input = utils.getIntInput(1, fileLength);
                heroString = utils.getFileLine(input, warriorPath);
                break;
            case 2:
                System.out.println("Please select a Sorcerer with his number");
                System.out.println("");
                utils.printFile(sorcererPath);
                fileLength = utils.getFileLength(sorcererPath);
                input = utils.getIntInput(1, fileLength);
                heroString = utils.getFileLine(input, sorcererPath);
                break;
            case 3:
                System.out.println("Please select a Warrior with his number");
                System.out.println("");
                utils.printFile(paladinPath);
                fileLength = utils.getFileLength(paladinPath);
                input = utils.getIntInput(1, fileLength);
                heroString = utils.getFileLine(input, paladinPath);
                break;
        }
        System.out.println("You have chosen:");
        System.out.println(heroString);
        //now generate the object with the hero factory and add it to the party
        HeroCenter heroCenter = new HeroCenter();
        Hero newHero = heroCenter.createHero(choice);
        newHero.setAttributes(heroString);
        heroFactory.setIndex(index, newHero);
    }

    //allow the hero to use his inventory
}
