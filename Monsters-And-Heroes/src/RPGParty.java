//a group of players for RPG games
public abstract class RPGParty {
    public RPGParty(){}
    public abstract void printPartyInv();


    //return true if all the heroes are dead
    public abstract boolean allDead();

    //get the number of alive heros
    public abstract int numAlive();

    //return indexes of the living creatures;
    public abstract int[] aliveIndexes();



}