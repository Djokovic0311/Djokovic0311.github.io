//base board class to be extended further
public class Board {
    protected Space[][] board;
    protected int boardSize = 8;
    //default constructor
    public Board(){
        board = new Space[boardSize][boardSize];
    }
    //define a board with a fixed row and col
    public Board(int row, int col){
        board = new Space[row][col];
    }

    //initialize the board with all empty Spaces
    public void initBoard(){
        for(int x = 0; x<board[0].length; x++){
            for(int y = 0; y<board[0].length; y++){
                board[x][y] = new Space();
            }
        }
    }

    //method to get a specific Space
    public Space getSpace(int x, int y){
        return board[x][y];
    }
    //method to set a specific Space
    public void setSpace(int x, int y, Space space){
        board[x][y] = space;
    }

    //override toString
    @Override
    public String toString(){
        StringBuilder toPrint = new StringBuilder();
        //traverse the board and print each Space
        StringBuilder rowString = new StringBuilder();
        for(int x=0; x<board[0].length; x++){
            rowString.append("----");
        }
        //add a new line
        rowString.append("\n");
        rowString.insert(0,"-");
        for(int x=0; x<board.length; x++){
            if(x!=0){
                toPrint.append("\n");
            }
            toPrint.append(rowString);
            for(int y=0; y<board[0].length; y++){
                toPrint.append("| ");
                toPrint.append(board[x][y].toString());
                toPrint.append(" ");
                if(y==board[0].length-1){
                    toPrint.append("|");
                }
            }
        }
        toPrint.append("\n");
        toPrint.append(rowString);
        return toPrint.toString();
    }

    //getters and setters
    public Space[][] getBoard() {
        return board;
    }
    public void setBoard(Space[][] board) {
        this.board = board;
    }
}