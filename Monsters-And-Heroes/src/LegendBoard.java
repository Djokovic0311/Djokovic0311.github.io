//the board for Legends -> extends RPGBoard
import java.util.Random;
public class LegendBoard extends RPGBoard{
    //default party location
    private final int defaultPartyLocX = 0;
    private final int defaultPartyLocY = 0;
    private final String playerIcon = "P";

    //last player location
    private int lastX;
    private int lastY;

    //number of Space types currently in Legends = 3
    private final int NUM_TYPES = 3;

    //default constructor
    public LegendBoard(){
        board = new LegendSpace[boardSize][boardSize];
        initBoard();
    }
    public LegendBoard(int row, int col){
        board = new LegendSpace[row][col];
        lastX = defaultPartyLocX;
        lastY = defaultPartyLocY;
    }

    //initialize the board
    public void initBoard(){
        //total Spaces on the board
        int totalSpaces = boardSize*boardSize;
        //number of market Spaces is about 30 percent
        int numMarket = (int) (totalSpaces * .3);
        //number of inaccessible spaces is around 20 percent
        int numInaccessible = (int) (totalSpaces * .2);
        //common Spaces are calculated from the remainder
        int numCommon = totalSpaces - numMarket - numInaccessible;
        //now go through the whole board and place the Spaces accordingly
        for(int x=0; x<board.length; x++){
            for(int y=0; y<board[0].length; y++){
                //the party will always start on a common Space
                if(x==defaultPartyLocX && y==defaultPartyLocY){
                    board[x][y] = new CommonSpace();
                    numCommon--;
                }
                //otherwise generate board randomly
                else{
                    int SpaceNum = (int)(1+Math.random()*(10-1+1));

                    if((SpaceNum >= 1 && SpaceNum <= 3) && numMarket > 0){
                        board[x][y] = new MarketSpace();
                        numMarket--;
                    }
                    else if((SpaceNum == 4 || SpaceNum == 5) && numInaccessible > 0){
                        board[x][y] = new InaccessibleSpace();
                        numInaccessible--;
                    }
                    else if(numCommon > 0){
                        board[x][y] = new CommonSpace();
                        numCommon--;
                    }
                    else if(numInaccessible > 0){
                        board[x][y] = new InaccessibleSpace();
                        numInaccessible--;
                    }
                    else if(numMarket > 0){
                        board[x][y] = new MarketSpace();
                        numMarket--;
                    }
                    else{
                        board[x][y] = new CommonSpace();
                        numCommon--;
                    }
                }
            }
        }
        //if the player has nowhere to go, generate a new board

    }

    //check if the party has a route to go
    public boolean checkRoute(int x, int y){
        //check the four adjacent Spaces to the player
        if(x-1 >= 0 && board[x-1][y]!=null && ())
    }
    //check currennt Space valid
    public boolean canGo(int x, int y){
        if (x>=0 && x<board.length && y>=0 && y<board[0].length && ((LegendSpace)board[x][y]).isWalkable){
            return true;
        }
        System.out.println("Can't go there! Please choose another direction");
        return false;
    }

    //update the Party's position on the map
    public void updatePlayer(int x, int y){
        //change back to the original icon
        if(board[lastX][lastY] instanceof InaccessibleSpace){
            ((InaccessibleSpace)board[lastX][lastY]).resetIcon();
        }
        else if(board[lastX][lastY] instanceof CommonSpace){
            ((CommonSpace)board[lastX][lastY]).resetIcon();
        }
        else{
            ((MarketSpace)board[lastX][lastY]).resetIcon();
        }
    }
}
