// this class denotes to inaccessible space in legend game
public class InaccessibleSpace extends LegendSpace{
    private final String DEFAULT_ICON = "*";
    //default costructor
    //set the icon to a * so it represents an inaccessibleSpace
    public InaccessibleSpace(){
        super();
        isWalkable = false;
        spaceIcon = DEFAULT_ICON;
    }
    public String getIcon() {
        return DEFAULT_ICON;
    }
    //reset icon to default
    public void resetIcon() {
        spaceIcon = DEFAULT_ICON;
    }
}
