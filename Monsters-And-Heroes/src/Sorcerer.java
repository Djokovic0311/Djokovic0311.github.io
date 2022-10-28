public class Sorcerer extends Hero implements HeroCreator{
    public Sorcerer(){
        super();
    }
    public Sorcerer(int lvl, int hp, String name, int strength, int dex, int agl, int mana, int exp, int money) {
        super(lvl, hp, name, strength, dex, agl, mana, exp, money);
    }

    public Sorcerer createHero(String charInfo){
        Sorcerer newHero = new Sorcerer();
        setAttributes(charInfo);
        return newHero;
    }

    //same as hero but add 5 percent more to favored stats
    public void LevelUp(){
        level++;
        hp = level*100;
        mana = (int)(mana*1.1);
        //5 more to favored skills
        strength = (int)(strength*1.05);
        agility = (int)(agility*1.10);
        dexterity = (int)(dexterity*1.10);
    }
}
