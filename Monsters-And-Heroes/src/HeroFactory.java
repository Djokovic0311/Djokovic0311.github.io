//a group of players for RPG games
public class HeroFactory extends RPGParty{
    private final int defaultPartyLocX = 0;
    private final int defaultPartyLocY = 0;
    //current location
    private int xLoc;
    private int yLoc;
    protected Hero[] heroParty;
    //constructor
    public HeroFactory(int num){
        heroParty = new Hero[num];
        xLoc = defaultPartyLocX;
        yLoc = defaultPartyLocY;
    }

    //get a Hero at an index
    public Hero getIndex(int index){
        return heroParty[index];
    }
    //set a hero at one index
    public void setIndex(int index, Hero hero){
        heroParty[index] = hero;
    }
    //print inventory
    public void printPartyInv() {
        for(Hero hero : heroParty) {
            hero.printInv();
        }

    }

    //revive the dead members after the battle
    public void reviveParty(){
        for(Hero hero : heroParty) {
            if(hero.isDead()) {
                hero.setHp(hero.getLevel() * 100 / 2);
            }
        }
    }

    //award the heroes for winning
    public void awardAfterWin(){
        for(Hero hero : heroParty) {
            if(!(hero.isDead())) {
                // add 2 exp
                hero.setExp(hero.getExp() + 2);
                // get gold and hp
                int prevMoney = hero.getGold();
                hero.setGold(prevMoney + (getHighestLvl() * 100));
                hero.setHp(hero.getHp() + (hero.getHp() / 10));
                //add 10 percent mana back
                hero.setMana(hero.getMana() + (hero.getMana() / 10));
            }
        }
    }

    //check for level up
    public void checkLevelUp(){
        for(Hero hero : heroParty) {
            if(hero.checkLevelUp()) {
                hero.levelUp();
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("\n");
        toPrint.append("You curent hero party: \n");
        for(Hero hero : heroParty) {
            toPrint.append(hero).append("\n");
            toPrint.append("\n");
        }
        return toPrint.toString();
    }

    //return true if all the heroes are dead
    public boolean allDead(){
        int count = 0;
        for(Hero hero : heroParty) {
            if(hero.isDead()) {
                count++;
            }
        }
        return count == heroParty.length;
    }

    //get the number of alive heros
    public int numAlive(){
        int count =0;
        for (Hero hero : heroParty) {
            if(!(hero.isDead())) {
                count++;
            }
        }
        return count;
    }

    //return indexes of the living crearures
    public int[] aliveIndexes(){
        int[] alive = new int[numAlive()];
        int count = 0;
        for(int x = 0; x<heroParty.length; x++){
            if(!(heroParty[x].isDead())){
                alive[count] = x;
                count++;
            }
        }
        return alive;
    }

    //set the party's new position
    public void setPos(int x, int y){
        xLoc = x;
        yLoc = y;
    }

    //get the highest level in the party
    public int getHighestLvl(){
        int highestLevel = 0;
        for (Hero hero : heroParty) {
            highestLevel = Math.max(highestLevel, hero.getLevel());
        }
        return highestLevel;
    }

    //getters and setters
    public int getXLoc(){
        return xLoc;
    }
    public int getYLoc(){
        return yLoc;
    }
    public void setXLoc(int xLoc){
        this.xLoc = xLoc;
    }
    public void setYLoc(int yLoc){
        this.yLoc = yLoc;
    }

    public int getLength() {
        return heroParty.length;
    }
}