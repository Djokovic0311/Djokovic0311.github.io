//RPGItem class for RPG games and their items
public class RPGItem extends Item{
    //default constructor
    protected int requiredLevel;

    public RPGItem() {
        super();
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

}
