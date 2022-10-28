import java.util.ArrayList;

//hero class extended from base creatrue
public class Hero extends Creature{
    //hero attributes
    private int HAND = 2;
    protected int usedHand = 0;
    protected int strength;
    protected int dexterity;
    protected int agility;
    protected int mana;
    protected int exp;
    protected int gold;
    protected ArrayList<Weapon> weapons;
    protected ArrayList<Armor> armor;
    protected ArrayList<Potion> potions;
    protected ArrayList<Spell> spells;
    protected ArrayList<Weapon> equippedWeapon;
    protected Armor equippedArmor;

    public Hero(){
        super();
    }

    //constructor to add just attributes
    public Hero(int strength, int dex, int agl, int mana, int exp, int gold){
        super();
        this.strength = strength;
        this.dexterity = dex;
        this.agility = agl;
        this.mana = mana;
        this.exp = exp;
    }
    //constructor to make a completely custom hero
    public Hero(int level, int hp, String name, int strength, int dex, int agl, int mana, int exp, int gold){
        super(level,hp,name);
        this.strength = strength;
        this.dexterity = dex;
        this.agility = agl;
        this.mana = mana;
        this.exp = exp;
        this.gold = gold;
    }

    //print out a Hero's inventory
    public void printInv(){
        System.out.println("-----------");
        System.out.println("Hero " + name + "'s inventory");
        System.out.println("Weapons: ");
        if(weapons.size() > 0){
            for(Weapon wpn: weapons){
                System.out.println(wpn);
            }
        }
        System.out.println("Armor: ");
        if(armor.size() > 0){
            for(Armor arm: armor){
                System.out.println(arm);
            }
        }
        System.out.println("Potions: ");
        if(potions.size() > 0){
            for(Potion pot: potions){
                System.out.println(pot);
            }
        }
        System.out.println("Spells: ");
        if(spells.size() > 0){
            for(Spell spl: spells){
                System.out.println(spl);
            }
        }
    }

    //equip a specific piece of armor
    public void equipArmor(int armorIndex){
        equippedArmor = armor.get(armorIndex);
        System.out.println("Equipped " + equippedArmor.getName());
    }

    //equip a specific weapon
    public void equipWeapon(int wpnIndex){

        if(usedHand + weapons.get(wpnIndex).getRequiredHands() <= HAND)  {
            equippedWeapon.add(weapons.get(wpnIndex));
            System.out.println("Equipped " + equippedWeapon.get(equippedWeapon.size()-1).getName());
            usedHand += weapons.get(wpnIndex).getRequiredHands();
            weapons.remove(wpnIndex);
        }
        else {
            System.out.println("No enough hands to equip "+ equippedWeapon.get(equippedWeapon.size()-1).getName());
        }
    }
    public void takeDownWeapon(int wpnIndex) {
        System.out.println("Took down " + equippedWeapon.get(wpnIndex).getName());
        Weapon wpn = equippedWeapon.get(wpnIndex);
        equippedWeapon.remove(wpnIndex);
        weapons.add(wpn);
        usedHand -= wpn.getRequiredHands();
    }
    //use a potion and then remove it
    public void applyPotion(int potionIndex){
        potions.get(potionIndex).applyPotion(this);
        System.out.println("Used " + potions.get(potionIndex).getName());
        potions.remove(potionIndex);
    }

    //use a spell
    //return true if the hero has enough mana to apply the spell with index of the spellIndex
    public boolean applySpell(int spellIndex){
        //if the player has enough mana, then subtract it from the mana
        int manaCost = spells.get(spellIndex).getManaCost();
        if(this.mana >= manaCost) {
            this.mana = this.mana -manaCost;
            return true;
        }
        System.out.println("Not enough mana available");
        return false;

    }

    //print hero information
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        String spaces = "  ";
        if(isDead()){
            str.append("DEAD ");
        }
        str.append(this.name).append(spaces);
        str.append("Level: ").append(this.level).append(spaces);
        str.append("HP: ").append(this.hp).append(spaces);
        str.append("MP:").append(this.hp).append(spaces);
        str.append("Strength: ").append(this.strength).append(spaces);
        str.append("Dexterity: ").append(this.dexterity).append(spaces);
        str.append("Agility: ").append(this.agility).append(spaces);
        str.append("Gold: ").append(this.gold).append(spaces);
        str.append("Exp: ").append(this.exp).append(spaces);
        str.append("Weapon: ");
        for(Weapon weapon : this.equippedWeapon) {
            str.append(weapon.getName()).append(spaces);
        }
        str.append("Aromor: ").append(this.equippedArmor.getName()).append(spaces);
        return str.toString();
    }

    //set attributes according to the hero input
    public void setAttributes(String input){
        level = 1;
        hp = level*100;
        String[] characterAttr = input.split("\\s+");
        name = characterAttr[0];
        mana = Integer.parseInt(characterAttr[1]);
        strength = Integer.parseInt(characterAttr[2]);
        agility = Integer.parseInt(characterAttr[3]);
        dexterity = Integer.parseInt(characterAttr[4]);
        gold = Integer.parseInt(characterAttr[5]);
        exp = Integer.parseInt(characterAttr[6]);
        //init other variables
        weapons = new ArrayList<>();
        armor = new ArrayList<>();
        potions = new ArrayList<>();
        spells = new ArrayList<>();
        equippedWeapon = new ArrayList<Weapon>();
        equippedArmor = new Armor();
    }

    //check if a hero has leveled up
    public boolean checkLevelUp(){
        return exp >= level * 10;
    }

    //upgrade their stats
    public void levelUp(){
        level++;
        hp = level*100;
        mana = (int)(mana*1.1);
        //all skills go up 5 percent by default
        strength = (int)(strength*1.05);
        agility = (int)(agility*1.05);
        dexterity = (int)(dexterity*1.05);
    }

    //calculate the amount of damage a hero does with a weapon
    public int calcWpDmg(int weaponIndex){
        return (int)((strength+equippedWeapon.get(weaponIndex).getDamage())*.05);
    }

    //calculate the dodge chance of the hero
    public int calcDodge(){
        return (int)((agility)*0.02);
    }
    //calculate the amount of damage a hero does with a spell
    public int calcSpellDmg(Spell spell){
        return spell.getDamage() + ((dexterity/1000)*spell.getDamage());
    }

    //take damage
    public void takeDamage(int dmg){
        this.hp = this.hp - (dmg - (equippedArmor.getDmgRed()/10));
    }

    //getters and setters
    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public int getMana() {
        return mana;
    }

    public int getExp(){
        return exp;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    public int getGold(){
        return this.gold;
    }

    public void setGold(int gold){
        this.gold = gold;
    }

    public ArrayList<Weapon> getEqpWeapon(){
        return equippedWeapon;
    }
    public void setEquippedWeapon(ArrayList<Weapon> wpn){
        equippedWeapon = wpn;
    }
    public void setEquippedArmor(Armor armor){
        equippedArmor = armor;
    }
    public Armor getEqpArmor(){
        return equippedArmor;
    }
    public void setArmor(Armor arm){
        equippedArmor = arm;
    }
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    public void setWeapons(ArrayList<Weapon> wpns) {
        weapons = wpns;
    }
    public ArrayList<Armor> getArmor(){
        return armor;
    }
    public ArrayList<Potion> getPotions(){
        return potions;
    }
    public ArrayList<Spell> getSpells(){
        return spells;
    }
}