// this class denotes to a space where hero can go
public class CommonSpace extends LegendSpace{
    private final String DEFAULT_ICON = " ";
    //default constructor
    //set the common space to just a space to show hero can go there.
    public CommonSpace(){
        super();
        spaceIcon = " ";
    }
    public String getIcon() {
        return DEFAULT_ICON;
    }
    //reset to default
    public void resetIcon() {
        spaceIcon = DEFAULT_ICON;
    }
}
