//this class denotes to market for sale and purchase
public class MarketSpace extends LegendSpace{
    private final String DEFAULT_ICON = "M";
    //default constructor
    //set the space icon to M for market
    public MarketSpace(){
        super();
        spaceIcon = DEFAULT_ICON;
    }
    public String getIcon() {
        return DEFAULT_ICON;
    }
    //reset back to default
    public void resetIcon() {
        spaceIcon = DEFAULT_ICON;
    }
}
