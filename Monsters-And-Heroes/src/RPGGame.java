import java.util.Objects;

//default class for RPG like games
public class RPGGame extends Game{
    //variables
    private RPGBoard board;

    //move options
    protected final String moveUP = "W";
    protected final String moveLEFT = "A";
    protected final String moveDOWN = "S";
    protected final String moveRIGHT = "D";
    protected final String showInfo = "I";
    protected final String quitGama = "Q";
    protected final String showInv = "E";
    protected final String showMap = "M";

    //default constructor
    public RPGGame(){
        board = new RPGBoard();
    }
    public boolean checkValidOption(String option) {
        return (Objects.equals(option, moveUP) || Objects.equals(option, moveDOWN) ||Objects.equals(option, moveLEFT)
        || Objects.equals(option, moveRIGHT) || Objects.equals(option, showInfo) || Objects.equals(option, quitGama)
        || Objects.equals(option, showInv) || Objects.equals(option, showMap));
    }
}