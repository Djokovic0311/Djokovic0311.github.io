//weapon class in legend game
public class Weapon extends RPGItem{
    private int damage;
    private int requiredHands;
    public Weapon(){
        super();
        damage = 0;
    }
    //read weapons from Weaponry.txt
    public void setAttributes(String input){
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.price = Integer.parseInt(characterAttr[1]);
        this.requiredLevel = Integer.parseInt(characterAttr[2]);
        this.damage = Integer.parseInt(characterAttr[3]);
        this.requiredHands = Integer.parseInt(characterAttr[4]);
    }

    //print weapon info
    @Override
    public String toString(){
        String str = "";
        String spaces = "  ";
        str+=this.name+spaces;
        str+="Price: "+ this.price+spaces;
        str+="RequiredLevel: " + this.requiredLevel+spaces;
        str+="damage: " + this.damage+spaces;
        str+="RequiredHands: " + this.requiredHands+spaces;
        return str;
    }


    public int getDamage() {
        return damage;
    }

    public int getRequiredHands() {
        return requiredHands;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setRequiredHands(int requiredHands) {
        this.requiredHands = requiredHands;
    }
}