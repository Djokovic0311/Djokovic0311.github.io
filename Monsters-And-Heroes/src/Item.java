//base class item to be extended
public class Item {
    protected String name;
    protected int price;
    //default constructor
    public Item(){
        name = "";
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
