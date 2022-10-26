//space for RPG games extended from Space
public class RPGSpace extends Space{
    protected boolean isWalkable;
    //default constructor
    public RPGSpace(){
        super();
        isWalkable = true;
    }
    //allows to set if the tile is walkable or not
    public RPGSpace(boolean isWalkable) {
        super();
        this.isWalkable = isWalkable;
    }

    //getter and setter
    public boolean getWalkable() {
        return isWalkable;
    }
    public void setWalkable(boolean walk) {
        isWalkable = walk;
    }

}
