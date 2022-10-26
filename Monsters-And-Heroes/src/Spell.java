//spell classes for each kind of spell
public class Spell extends RPGItem{
    private int damage;
    private int manaCost;
    private Spells spellType;

    public Spell() {
        super();
    }

    public void setAttributes(String input, Spells spellType){
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.price = Integer.parseInt(characterAttr[1]);
        this.requiredLevel = Integer.parseInt(characterAttr[3]);
        this.manaCost = Integer.parseInt(characterAttr[4]);
        this.spellType = spellType;

    }

    //print spell and info
    @Override
    public String toString(){
        String str = "";
        String spaces = "  ";
        str+=this.name+spaces;
        str+="Price: "+ this.price+spaces;
        str+="RequiredLevel: " + this.requiredLevel+spaces;
        str+="Damage: " + this.damage+spaces;
        str+="ManaCost: "+this.manaCost+spaces;
        return str;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public Spells getSpellType() {
        return spellType;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setManaprice(int manaprice) {
        this.manaCost = manaprice;
    }

    public void setSpellType(Spells spellType) {
        this.spellType = spellType;
    }

}
enum Spells{
    ICE,
    FIRE,
    LIGHTNING
}