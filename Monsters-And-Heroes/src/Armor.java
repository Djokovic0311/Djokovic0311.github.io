//armor class for armor in Legend
public class Armor extends RPGItem{
    private int dmgReduction;
    private String usage;
    public Armor(){
        super();
        dmgReduction = 0;
    }

    public void setAttributes(String input){
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.price = Integer.parseInt(characterAttr[1]);
        this.requiredLevel = Integer.parseInt(characterAttr[2]);
        this.dmgReduction = Integer.parseInt(characterAttr[3]);
        this.usage = characterAttr[4];
    }

    //print weapon and info
    @Override
    public String toString(){
        String str = "";
        String spaces = " ";
        str += this.name+spaces;
        str += "Price: "+ this.price+spaces;
        str += "RequiredLevel: " + this.requiredLevel+spaces;
        str += "DamageReduction: " + this.dmgReduction+spaces;
        str += "Usage: " + this.usage + spaces;
        return str;
    }

    public int getDmgRed() {
        return dmgReduction;
    }

    public void setDmgRed(int dmgRed) {
        this.dmgReduction = dmgRed;
    }
}