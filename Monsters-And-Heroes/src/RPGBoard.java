//board for RPG=like games
public class RPGBoard extends Board{
    //default constructor
    public RPGBoard(){
        super();
        board = new Space[boardSize][boardSize];
    }

    //initialize the board with empty RPGSpaces
    public void initBoard(){
        for(int x=0; x<board[0].length; x++){
            for(int y=0; y<board[0].length;y++){
                board[x][y] = new RPGSpace();
            }
        }
    }

    //getter and setter
    public RPGSpace[][] getBoard(){
        return (RPGSpace[][]) board;
    }
    public void setBoard(RPGSpace[][] board){
        this.board = board;
    }

}