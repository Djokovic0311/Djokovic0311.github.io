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
                int
            }
        }
    }






    @Override
    public boolean allDead() {
        return false;
    }

    @Override
    public int numAlive() {
        return 0;
    }

    @Override
    public int[] aliveIndexes() {
        return new int[0];
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
