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

    public void applyPotion(Hero hero){
        String[] affs = attrAffected.split("/");
        for (String aff : affs) {
            switch (aff) {
                case "Health":
                    hero.setHp(hero.getHp() + attIncrease);
                    break;
                case "Mana":
                    hero.setMana(hero.getMana() + attIncrease);
                    break;
                case "Strength":
                    hero.setStrength(hero.getStrength() + attIncrease);
                    break;
                case "Dexterity":
                    hero.setDexterity(hero.getDexterity() + attIncrease);
                    break;
                case "Agility":
                    hero.setAgility(hero.getAgility() + attIncrease);
                    break;
                case "All":
                    hero.setHp(hero.getHp() + attIncrease);
                    hero.setMana(hero.getMana() + attIncrease);
                    hero.setStrength(hero.getDexterity() + attIncrease);
                    hero.setDexterity(hero.getDexterity() + attIncrease);
                    hero.setAgility(hero.getAgility() + attIncrease);
                    break;
            }
        }

    }


    public int getAttIncrease() {
        return attIncrease;
    }

    public String getAttrAffected() {
        return attrAffected;
    }

    public void setAttIncrease(int attIncrease) {
        this.attIncrease = attIncrease;
    }

    public void setAttrAffected(String attrAff) {
        this.attrAffected = attrAff;
    }
}