//a hero but is favored on strength and dexterity
public class Paladin extends Hero implements HeroCreator{
    public Paladin(){
        super();
    }
    public Paladin(int lvl, int hp, String name, int strength, int dex, int agl, int mana, int exp, int money) {
        super(lvl, hp, name, strength, dex, agl, mana, exp, money);
    }

    public Paladin createHero(String charInfo){
        Paladin newHero = new Paladin();
        setAttributes(charInfo);
        return newHero;
    }

    //same as hero but add 5 percent more to favored stats
    public void LevelUp(){
        level++;
        hp = level*100;
        mana = (int)(mana*1.1);
        //5 more to favored skills
        strength = (int)(strength*1.10);
        agility = (int)(agility*1.05);
        dexterity = (int)(dexterity*1.10);
    }

}
