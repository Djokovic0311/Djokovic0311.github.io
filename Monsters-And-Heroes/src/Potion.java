//potion class for potions in Legend
public class Potion extends RPGItem{
    private int attIncrease;
    private String attrAffected;
    public Potion() {
        super();
    }

    public void setAttributes(String input){
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.price = Integer.parseInt(characterAttr[1]);
        this.requiredLevel = Integer.parseInt(characterAttr[2]);
        this.attIncrease = Integer.parseInt(characterAttr[3]);
        this.attrAffected = characterAttr[4];
    }

    //print potion and info
    @Override
    public String toString(){
        String str = "";
        String spaces = "  ";
        str+=this.name+spaces;
        str+="Price: "+ this.price+spaces;
        str+="RequiredLevel: " + this.requiredLevel+spaces;
        str+="Potency: " + this.attIncrease+spaces;
        str+="Affinities: "+this.attrAffected+spaces;
        return str;
    }
}
