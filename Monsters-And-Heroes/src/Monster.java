//base class for a monster to be extended further
public class Monster extends Creature{
    protected int baseDMG;
    protected int defense;
    protected int dodgeAbility;

    //default constructor
    public Monster(){

    }
    //create a monster with attributes
    public Monster(int baseDMG, int defense, int dodgeAbility) {
        super();
        this.baseDMG = baseDMG;
        this.defense = defense;
        this.dodgeAbility = dodgeAbility;
    }
    //create a monster and set all stats
    public Monster(int level, int hp, String name, int baseDMG, int defense, int dodgeAbility) {
        super(level, hp, name);
        this.baseDMG = baseDMG;
        this.defense = defense;
        this.dodgeAbility = dodgeAbility;
    }

    //organize monster stats
    @Override
    public String toString(){
        String toPrint = "";
        String spaces = "  ";
        toPrint+= getClass().getName() + spaces;
        toPrint+= name + spaces;
        toPrint+= "level: " + level + spaces;
        toPrint+= "HP: " + hp + spaces;
        toPrint+= "Damage: " + baseDMG + spaces;
        toPrint+= "Defense: "+defense+spaces;
        toPrint+= "DodgeAbiliyu: " + dodgeAbility + spaces;
        return toPrint;
    }

    //set attribute based on the input
    //ex: Name/level/damage/defense/dodge Ability
    //Desghidorrah	 3       300       400     35
    public void setAttributes(String input){
        //split off of any white space
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.level = Integer.parseInt(characterAttr[1]);
        this.baseDMG = Integer.parseInt(characterAttr[2]);
        this.defense = Integer.parseInt(characterAttr[3]);
        this.dodgeAbility = Integer.parseInt(characterAttr[4]);
        this.hp = level*100;
    }

    //monster is on the same level as the highest level hero in the party
    //ex: Name/level/damage/defense/dodge Ability
    //Desghidorrah	 3       300       400     35
    public void matchLevel(int newlevel){
        //balance creature to its new level
        int oldlevel = this.level;
        this.level = newlevel;
        this.hp = level*100;
        this.baseDMG = baseDMG/oldlevel * newlevel;
        this.defense = defense/oldlevel * newlevel;
    }

    //debuff from a spell
    public void spellDebuff(Spell spell){
        switch (spell.getSpellType()){
            case ICE: //do 10 percent dmg debuff
                this.baseDMG = this.baseDMG - (int)(this.baseDMG*.1);
                break;
            case FIRE: //do 10 percent defense debuff
                this.defense = this.defense - (int) (this.defense*.1);
                break;
            case LIGHTNING: //do 10 percent dodge Ability debuff
                this.dodgeAbility = this.dodgeAbility - (int) (this.dodgeAbility*.1);
                break;
        }

    }

    //calculate the amount of damage
    public int calcDmg(){
        return (int)(this.baseDMG *.15);
    }
    //calculate the dodge Ability of the hero
    public int calcDodge(){
        return (int)(dodgeAbility*.01);
    }
    //take damage and substract defense
    public void takeDamage(int dmg){
        this.hp = this.hp - (dmg-(defense/100));
    }

    // getters and setters
    public int getBaseDMG() {
        return baseDMG;
    }

    public int getDefense() {
        return defense;
    }

    public int getDodgeAbility() {
        return dodgeAbility;
    }

    public void setBaseDMG(int baseDMG) {
        this.baseDMG = baseDMG;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setDodgeAbility(int dodgeAbility) {
        this.dodgeAbility = dodgeAbility;
    }

}