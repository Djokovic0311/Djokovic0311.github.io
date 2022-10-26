//base space class to be extended
public class Space {
    protected String type;

    //default constructor
    public Space() {
        type = "";
    }

    //set type once initializing
    public Space(String str) {
        type = str;
    }

    //overriding toString
    @Override
    public String toString() {
        return type;
    }

    //getter and setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
