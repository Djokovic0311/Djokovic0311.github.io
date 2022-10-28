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
        this.hp = hp;
        this.name = name;
    }

    //take damage
    public void takeDamage(int dmg){
        hp -= dmg;
    }
    //gain health
    public void gainHealth(int health){
        hp+=health;
    }

    //return true if a creature is dead
    public boolean isDead(){
        return this.hp <= 0;
    }

    //go up a level
    public void levelUp(){
        level++;
    }

    //getter and setters
    public int getTarget(){
        return target;
    }

    public void setTarget(int target){
        this.target = target;
    }

    public int getLevel(){
        return level;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }
}