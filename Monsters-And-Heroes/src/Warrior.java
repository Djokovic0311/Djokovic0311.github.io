// a hero favored on strength and agility
public class Warrior extends Hero implements HeroCreator{
    public Warrior(){
        super();
    }
    public Warrior(int lvl, int hp, String name, int strength, int dex, int agl, int mana, int exp, int money) {
        super((lvl, hp, name, strength, dex, agl, mana, exp, money);
    }

    public Warrior createHero(String charInfo){
        Warrior newHero = new Warrior();
        setAttributes(charInfo);
        return newHero;
    }

    //same as hero but add 5 percent more increase to favored skills
    public void LevelUp(){
        level++;
        hp = level*100;
        mana = (int)(mana*1.1);
        //5 more to favored skills
        strength = (int)(strength*1.10);
        agility = (int)(agility*1.10);
        dexterity = (int)(dexterity*1.05);
    }
}