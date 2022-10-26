//specific space in the game will extend this class
public class LegendSpace extends RPGSpace{
    protected String spaceIcon;
    //default constructor
    public LegendSpace(){
        super();
        spaceIcon = "";
    }

    // replace the space with a letter
    @Override
    public String toString() {
        return spaceIcon;
    }
    //getter and setter
    public String getSpaceIcon() {
        return spaceIcon;
    }

    public void setSpaceIcon(String spaceIcon) {
        this.spaceIcon = spaceIcon;
    }
}
