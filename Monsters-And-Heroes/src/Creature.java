//base class to be extended to heros & monsters
public class Creature {
    protected int level;
    protected int hp;
    protected String name;
    protected boolean isDead;
    //who they are targeting, which is updated with each turn
    protected int target;

    //default constructor
    public Creature(){
        name = "CREATURE";
        level = 1;
        hp = 100;
    }
    //constructor with parameters
    public Creature(int level, int hp, String name){
        this.level = level;
        this.hp = hp
    }
}
