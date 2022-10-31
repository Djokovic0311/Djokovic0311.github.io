//Main class for Legends -> extends RPGGame
import java.util.Scanner;
import java.io.File;
import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;

public class Legends extends RPGGame{
    //variables
    private LegendBoard board;
    private HeroFactory heroFactory;
    private final Scanner myScanner;
    private Utils utils;

    //default constructor
    public Legends(){
        myScanner = new Scanner(System.in);
        utils = new Utils(myScanner);
    }
    //game begin
    public void playGame(){
        //while the game is not ever yet
        System.out.println("Welcome to Legends: Monsters and Heroes!");
        //generate map
        //create a board with default value
        board = new LegendBoard();
        //set up player
        chooseHeroes();
        System.out.println(heroFactory);
        System.out.println("Let the Adventure begin!!");
        System.out.println("");
        System.out.println(board);
        while (!isOver){
            //player turn
            playerTurn();
        }
        System.out.println("Game is Over!");
    }

    //a player's turn that shows them their current options
    public void playerTurn(){
        //check current Space and if it's a market then prompt whether to go inside
        Space curSpace = board.getSpace(heroFactory.getXLoc(), heroFactory.getYLoc());
        if(curSpace instanceof MarketSpace){

        }
        printMoveOptions();
        checkMoveOption();
    }

    //check if the player can go there and if so then move the player
    public void checkMoveOption(){
        String option = utils.getCharInput();
        int currX = heroFactory.getXLoc(); int currY = heroFactory.getYLoc();
        //check if it is any of our input options

        switch (option){
            case moveUP:
                if(board.canGo(currX-1, currY)){
                    playerMove(currX,currY);
                }
                else {
                    checkMoveOption();
                }
                break;
            case moveLEFT:
                if(board.canGo(currX, currY-1)){
                    playerMove(currX,currY-1);
                }
                else {
                    checkMoveOption();
                }
                break;
            case moveDOWN:
                if(board.canGo(currX+1, currY)){
                    playerMove(currX+1,currY);
                }
                else {
                    checkMoveOption();
                }
                break;
            case moveRIGHT:
                if(board.canGo(currX, currY+1)){
                    playerMove(currX,currY+1);
                }
                else {
                    checkMoveOption();
                }
                break;
            case quitGame:
                isOver = true;
                break;
            case showInfo:
                System.out.println(heroFactory);
                break;
            case showMap:
                System.out.println(board);
                break;
            case showInv:
                manageInv();
                break;
            default:
        }
    }

    //print the current options for the player
    public void printMoveOptions(){
        System.out.println("-------------------------");
        System.out.println("Type " + moveUP + " to move up.");
        System.out.println("Type " + moveLEFT + " to move left.");
        System.out.println("Type " + moveDOWN + " to move down.");
        System.out.println("Type " + moveRIGHT + " to move right.");
        System.out.println("Type " + showInfo + " to show info.");
        System.out.println("Type " + quitGame + " to quit.");
        System.out.println("Type " + showInv + " to manage inventory.");
        System.out.println("Type " + showMap + " to show the Map");
        System.out.println("-------------------------");
    }

    // move and update the player's position
    public void playerMove(int x, int y){
        heroFactory.setPos(x, y);
        board.updatePlayer(x,y);
        System.out.println(board); //show the updated board
        if (board.getSpace(x,y) instanceof CommonSpace){
            Random rand = new Random();
            int encounterChance = 3;
            int SpaceNum = rand.nextInt(encounterChance);
            if(SpaceNum == 0){
                startBattle();
            }
        }
    }

    //allow the user to choose heroes at the beginning of the game
    public void chooseHeroes(){
        System.out.println("How many heroes would you like to join in your party?");
        int MAX_HEROES = 3;
        System.out.println("Max is " + MAX_HEROES);
        int numHeroes = utils.getIntInput(1, MAX_HEROES);
        heroFactory = new HeroFactory(numHeroes);
        for(int x=0; x<numHeroes; x++){
            addHero(x);
        }
    }

    //add a hero to the party
    public void addHero(int index){
        System.out.println("");
        System.out.println("Which type of hero would you like?");
        System.out.println("Warrior = 1, Sorcerer = 2, Paladin = 3");
        int choice = utils.getIntInput(1,3);
        System.out.println("YOUR CHOICE IS " + choice);
        int input;
        String heroString = "";

        String warriorPath = "./Warriors.txt";
        String sorcererPath = "./Sorcerers.txt";
        String paladinPath = "./Paladins.txt";

        switch (choice) {
            case 1:
                System.out.println("Please select a Warrior with his number");
                System.out.println("");
                utils.printFile(warriorPath);
                int fileLength = utils.getFileLength(warriorPath);
                System.out.println(fileLength);
                input = utils.getIntInput(1, fileLength);
                heroString = utils.getFileLine(input, warriorPath);
                break;
            case 2:
                System.out.println("Please select a Sorcerer with his number");
                System.out.println("");
                utils.printFile(sorcererPath);
                fileLength = utils.getFileLength(sorcererPath);
                input = utils.getIntInput(1, fileLength);
                heroString = utils.getFileLine(input, sorcererPath);
                break;
            case 3:
                System.out.println("Please select a Warrior with his number");
                System.out.println("");
                utils.printFile(paladinPath);
                fileLength = utils.getFileLength(paladinPath);
                input = utils.getIntInput(1, fileLength);
                heroString = utils.getFileLine(input, paladinPath);
                break;
        }
        System.out.println("You have chosen:");
        System.out.println(heroString);
        //now generate the object with the hero factory and add it to the party
        HeroCenter heroCenter = new HeroCenter();
        Hero newHero = heroCenter.createHero(choice);
        newHero.setAttributes(heroString);
        heroFactory.setIndex(index, newHero);
    }

    //allow the hero to use his inventory
    public void manageInv(){
        System.out.println("");
        heroFactory.printPartyInv();
        System.out.println("Which Hero's inventory would you like to manage?");
        System.out.println("Type -1 to exit");
        for(int x = 0; x< heroFactory.getLength(); x++){
            System.out.println("(" + x + ")" + heroFactory.getIndex(x));
        }
        int choice = utils.getIntInput(-1, heroFactory.getLength()-1);
        if(choice == -1){
            return;
        }
        Hero hero = heroFactory.getIndex(choice);
        System.out.println("You have selected: " + hero.getName());
        hero.printInv();
        System.out.println("What would you like to do?");
        System.out.println("(1) Equip Items?");
        System.out.println("(2) Use a Potion?");
        choice = utils.getIntInput(0, 2);
        //get input and then do a method based on the choice
        if(choice == 1){
            equipItem(hero);
        }
        else if(choice == 2){
            usePotion(hero);
        }
    }

    //set up the market
    public void marketSetup() {
        System.out.println("------------------");
        System.out.println("Welcome to our shop!");
        System.out.println("What would you like to do?");
        System.out.println("(1) Enter the shop");
        System.out.println("(2) Move along");
        System.out.println("");
        int choice = utils.getIntInput(1, 2);
        if (choice == 1) { //if they want to enter the shop
            System.out.println("Welcome to the shop!");
            System.out.println("");
            heroMarket();
            marketSetup();
        }
    }

    //select the hero and choose whether to shop or sell
    public void heroMarket(){
        System.out.println("Please select a Hero to work with");
        for(int x = 0; x< heroFactory.getLength(); x++){
            System.out.println("(" + (x+1) + ") " + heroFactory.getIndex(x));
        }
        System.out.println("Or type -1 to leave");
        int choice = utils.getIntInput(-1, heroFactory.getLength());
        if(choice > 0){
            Hero hero = heroFactory.getIndex(choice-1);
            hero.printInv();
            System.out.println("");
            System.out.println("What would you like to do?");
            System.out.println("(1) Shop");
            System.out.println("(2) Sell");
            int choice2 = utils.getIntInput(-1, 2);
            if(choice2 == 1){
                buyItem(hero);
            }
            else if(choice2 == 2){
                sellItem(hero);
            }
        }
    }

    //allow to buy items
    public void buyItem(Hero hero) {
        System.out.println("What kind of item would you like?");
        System.out.println("(1) Weapons");
        System.out.println("(2) Armor");
        System.out.println("(3) Potions");
        System.out.println("(4) Spells");
        int choice = utils.getIntInput(-1, 4);
        final String filePath;

        final String weaponPath = "./Weaponry.txt";
        final String armorPath = "./Armory.txt";
        final String potionPath = "./Potions.txt";
        final String iceSpellPath = "./IceSpells.txt";
        final String fireSpellPath = "./FireSpells.txt";
        final String lightningSpellPath = "./LightningSpells.txt";

        if (choice == 1) {
            filePath = weaponPath;
        }
        else if (choice == 2) {
            filePath = armorPath;
        }
        else if (choice == 3) {
            filePath = potionPath;
        }
        else if (choice == 4) {
            System.out.println("What kind of spell would you like?");
            System.out.println("(1) Ice Spells");
            System.out.println("(2) Fire Spells");
            System.out.println("(3) Lightning Spells");
            int subChoice = utils.getIntInput(1, 3);
            if (subChoice == 1) {
                filePath = iceSpellPath;
            }
            else if (subChoice == 2) {
                filePath = fireSpellPath;
            }
            else {
                filePath = lightningSpellPath;
            }
        }
        else {
            return;
        }
        utils.printFile(filePath);
        int itemChoice = utils.getIntInput(1, utils.numLines(filePath) - 1);
        String itemStr = utils.getFileLine(itemChoice, filePath);

        RPGItem toBuy;
        //generate the item based on what kind of item it is
        switch (filePath) {
            case weaponPath:
                toBuy = new Weapon();
                ((Weapon) toBuy).setAttributes(itemStr);
                break;
            case armorPath:
                toBuy = new Armor();
                ((Armor) toBuy).setAttributes(itemStr);
                break;
            case potionPath:
                toBuy = new Potion();
                ((Potion) toBuy).setAttributes(itemStr);
                break;
            case iceSpellPath:
                toBuy = new Spell();
                ((Spell) toBuy).setAttributes(itemStr, Spells.ICE);
                break;
            case fireSpellPath:
                toBuy = new Spell();
                ((Spell) toBuy).setAttributes(itemStr, Spells.FIRE);
                break;
            case lightningSpellPath:
                toBuy = new Spell();
                ((Spell) toBuy).setAttributes(itemStr, Spells.LIGHTNING);
                break;
            default:
                toBuy = new Weapon();
                break;
        }
        //if the hero is capable to buy selected item
        if (hero.getLevel() >= toBuy.getRequiredLevel() && hero.getGold() >= toBuy.getPrice()) {
            if (toBuy instanceof Weapon) {
                hero.getWeapons().add((Weapon) toBuy);
//                System.out.println(hero.getWeapons().size());
                hero.setWeapons(hero.getWeapons());
                hero.setGold(hero.getGold() - toBuy.getPrice());
            }
            else if (toBuy instanceof Armor) {
                hero.getArmor().add((Armor) toBuy);
                hero.setGold(hero.getGold() - toBuy.getPrice());
            }
            else if (toBuy instanceof Potion) {
                hero.getPotions().add((Potion) toBuy);
                hero.setGold(hero.getGold() - toBuy.getPrice());
            }
            else {
                hero.getSpells().add((Spell) toBuy);
                hero.setGold(hero.getGold() - toBuy.getPrice());
            }
            System.out.println("Successfully bought it!");
        }
        else {
            System.out.println("Cannot buy that item!");
            if (hero.getLevel() < toBuy.getRequiredLevel())
                System.out.println("Hero has no enough level");
            else System.out.println("Hero has no enough gold");
        }
    }

    //allow a hero to sell an item in his inventory
    public void sellItem(Hero hero){
        hero.printInv();
        System.out.println("What kind of item would you like to sell?");
        System.out.println("(1) Weapons");
        System.out.println("(2) Armor");
        System.out.println("(3) Potions");
        System.out.println("(4) Spells");
        int choice = utils.getIntInput(1, 4);
        RPGItem toSell = new RPGItem();
        System.out.println("Which one would you like to sell?");
        System.out.println("Enter -1 if you give up selling");
//        boolean sellValidation = printInv(hero, choice, toSell);

        //remove the item
        if(choice == 1){ //weapons
            ArrayList<Weapon> items = hero.getWeapons();
            if(items.size() == 0){
                System.out.println("Hero doesn't have any to sell");
                return;
            }
            for(int x=0; x<items.size(); x++){
                System.out.println("(" + x + ") " + items.get(x));
            }
            int itemChoice = utils.getIntInput(-1, items.size()-1);
            if(itemChoice == -1){ //if they've changed their mind
                return;
            }
            else{
                toSell = items.get(itemChoice);
            }
        }
        else if(choice == 2){ //armor
            ArrayList<Armor> items = hero.getArmor();
            if(items.size() == 0){
                System.out.println("Hero doesn't have any to sell");
                return;
            }
            for(int x=0; x<items.size(); x++){
                System.out.println("(" + x + ") " + items.get(x));
            }
            int itemChoice = utils.getIntInput(-1, items.size()-1);
            if(itemChoice == -1){ //if they've changed their mind
                return;
            }
            else{
                toSell = items.get(itemChoice);
            }
        }
        else if(choice == 3){ //potions
            ArrayList<Potion> items = hero.getPotions();
            if(items.size() == 0){
                System.out.println("Hero doesn't have any to sell");
                return;
            }
            for(int x=0; x<items.size(); x++){
                System.out.println("(" + x + ") " + items.get(x));
            }
            int itemChoice = utils.getIntInput(-1, items.size()-1);
            if(itemChoice == -1){ //if they've changed their mind
                return;
            }
            else{
                toSell = items.get(itemChoice);
            }
        }
        else if(choice == 4){ //spells
            ArrayList<Spell> items = hero.getSpells();
            if(items.size() == 0){
                System.out.println("Hero doesn't have any to sell");
                return;
            }
            for(int x=0; x<items.size(); x++){
                System.out.println("(" + x + ") " + items.get(x));
            }
            int itemChoice = utils.getIntInput(-1, items.size()-1);
            if(itemChoice == -1){ //if they've changed their mind
                return;
            }
            else{
                toSell = items.get(itemChoice);
            }
        }
        //add money for half the cost of the item
        hero.setGold(hero.getGold() + (toSell.getPrice()/2));
        System.out.println("Successfully sold " + toSell.getName());
        //remove the item
        if(toSell instanceof Weapon){
            hero.getWeapons().remove(toSell);
        }
        else if(toSell instanceof Armor){
            hero.getArmor().remove(toSell);
        }
        else if(toSell instanceof Potion){
            hero.getPotions().remove(toSell);
        }
        else if(toSell instanceof Spell){
            hero.getSpells().remove(toSell);
        }

    }

    //start a battle sequence
    public void startBattle(){
        System.out.println("------------------");
        System.out.println("THE BATTLE BEGINS...");
        System.out.println("------------------");
        System.out.println(heroFactory);
        // generate monsters corresponding to the size of the party and highest level of the heroes
        int highLvl = heroFactory.getHighestLvl();
        MonsterParty monsters = new MonsterParty(heroFactory.getLength());
        for(int x=0; x<monsters.getLength(); x++){
            Random rand = new Random();
            int type = rand.nextInt(3) + 1;
            String charInfo;
            String filePath;
            if(type ==1){
                filePath = "./Dragons.txt";
            }
            else if(type ==2){
                filePath = "./Exoskeletons.txt";
            }
            else{
                filePath = "./Spirits.txt";
            }
            int toGet = rand.nextInt(utils.numLines(filePath)) + 1;
            charInfo = utils.getFileLine(toGet, filePath);
            MonsterFactory monsterFactory = new MonsterFactory();
            Monster newMon = monsterFactory.createMonster(type, charInfo, highLvl);
            monsters.setIndex(x, newMon);
        }
        System.out.println(monsters);

        //keep fighting until a side is dead
        while(!monsters.allDead() && !heroFactory.allDead()){
            //player turn
            heroTurn(monsters);

            //monster turn
            monsterTurn(monsters);

            //show the hp after all of that
            System.out.println(heroFactory);
            System.out.println(monsters);
        }
        if(monsters.allDead()){
            System.out.println("Heroes win!");
            heroFactory.awardAfterWin();
            heroFactory.reviveParty();
        }
        //if the players are all dead then the game is over
        else if(heroFactory.allDead()){
            System.out.println("Heroes lose!");
            isOver = true;
        }
        heroFactory.checkLevelUp();
    }

    //give each monster a turn
    public void monsterTurn(MonsterParty monsters){
        int[] aliveMon = monsters.aliveIndexes();
        //get alive heroes and alive monsters and set the targets
        for (int i : aliveMon) {
            int[] aliveHeroes = heroFactory.aliveIndexes();
            int target = 0;
            for (int aliveHero : aliveHeroes) {
                if (Math.abs(i - target) >= Math.abs(i - aliveHero)) {
                    target = aliveHero;
                }
            }
            Monster currentMonster = monsters.getIndex(i);
            currentMonster.setTarget(target);
            monsterAttack(currentMonster);
        }
    }

    //let the monster attack its target
    public void monsterAttack(Monster monster){
        Random rand = new Random();
        //if the monster dodges the attack
        Hero target = heroFactory.getIndex(monster.getTarget());
        if(rand.nextInt(100)+1 <= target.calcDodge()){
            System.out.println("The Hero Dodged!");
        }
        else{
            //calculate damage
            int dmg = monster.calcDmg();
            target.takeDamage(dmg);
            System.out.println(monster.getName() + " has attacked " + target.getName()+ " with " + dmg);
            System.out.println("");
        }

    }

    //the player's turn
    public void heroTurn(MonsterParty monsters){
        //get the alive heroes and the alive monsters and set the targets accordingly
        int[] aliveHeroes = heroFactory.aliveIndexes();
        for (int aliveHero : aliveHeroes) {
            int[] aliveMon = monsters.aliveIndexes();
            if (aliveMon.length == 0) { //if they're all dead
                break;
            }
            int target = 0;
            //choose a monster
            for (int y = 0; y < aliveMon.length; y++) {
                if (y == 0) {
                    target = aliveMon[y];
                } else if (Math.abs(aliveHero - target) >= Math.abs(aliveHero - aliveMon[y])) {
                    target = aliveMon[y];
                }
            }
            Hero currentHero = heroFactory.getIndex(aliveHero);
            currentHero.setTarget(target);
            System.out.println("------------");
            System.out.println(currentHero.getName() + " is targeting -> " + monsters.getIndex(target).getName());
            System.out.println("What would you like to do?");
            System.out.println("(1) Attack");
            System.out.println("(2) Use a Spell");
            System.out.println("(3) Change Equipment");
            System.out.println("(4) Use a Potion");
            int choice = utils.getIntInput(1, 4);
            if (choice == 1) {
                heroAttack(currentHero, monsters);
            } else if (choice == 2) {
                useSpell(currentHero, monsters);
            } else if (choice == 3) {
                equipItem(currentHero);
            } else if (choice == 4) {
                usePotion(currentHero);
            }
        }
    }
    public void heroAttack(Hero hero, MonsterParty monsters){
        Random rand = new Random();
        Monster target = monsters.getIndex(hero.getTarget());
        if(rand.nextInt(100)+1 <= target.calcDodge()){
            System.out.println("The Monster Dodged!");
        }
        else{
            System.out.println("Which weapon equipped do you wanna to use?");
            ArrayList<Weapon> eqpWeapons = hero.getEqpWeapon();
            if(eqpWeapons.size() == 0) {
                System.out.println("No equipped weapons to use!");
                return;
            }
            for(int x = 0; x < eqpWeapons.size(); x++) {
                System.out.println("(" + x + ") " + eqpWeapons.get(x));
            }

            int choice = utils.getIntInput(-1,eqpWeapons.size());
            int dmg = hero.calcWpDmg(choice);
            target.takeDamage(dmg);
            System.out.println("");
            System.out.println(hero.getName() + " has done " + dmg + " to " + target.getName());
            System.out.println("");
        }
    }
    //let a hero use a potion that the player selects
    public void usePotion(Hero hero){
        System.out.println("What would you like to use?");
        ArrayList<Potion> potions = hero.getPotions();
        if(potions.size() > 0){
            for(int x=0; x<potions.size(); x++){
                System.out.println("(" + x + ") " + potions.get(x));
            }
            //get the potion they want
            int choice2 = utils.getIntInput(-1, potions.size()-1);
            hero.applyPotion(choice2); //equip it
        }
        else{ //if they don't have any
            System.out.println("No potions to use!");
        }
    }

    //equip a weapon or armor
    public void equipItem(Hero hero){
        System.out.println("What would you like to equip?");
        System.out.println("(0) Weapon");
        System.out.println("(1) Armor");
        System.out.println("(-1) Nothing");
        int choice = utils.getIntInput(-1, 1);
        //if they want to equip a weapon
        if(choice == 0){
            System.out.println("Do you want to take down some weapons in advance?");
            System.out.println("(0) Yes");
            System.out.println("(1) No");
            int choice2 = utils.getIntInput(-1, 1);
            while(choice2 == 0 && hero.getEqpWeapon().size() > 0) {
                System.out.println("Which weapon do you want to take down?");
                for(int x = 0; x < hero.getEqpWeapon().size(); x++) {
                    System.out.println("(" + x + ") "+ hero.getEqpWeapon().get(x).getName());
                }
                int choice3 = utils.getIntInput(-1, hero.getEqpWeapon().size()-1);
                hero.takeDownWeapon(choice3);
                System.out.println("Do you want to take down some weapons in advance?");
                System.out.println("(0) Yes");
                System.out.println("(1) No");
                choice2 = utils.getIntInput(-1, 1);
            }

            System.out.println("Which weapon do you want to equip with?");

            if(hero.weapons.size() > 0){
                for(int x=0; x<hero.weapons.size(); x++){
                    System.out.println("(" + x + ") " + hero.weapons.get(x));
                }
                int subChoice = utils.getIntInput(-1, hero.weapons.size()-1);
                hero.equipWeapon(subChoice);
            }
            else{
                System.out.println("No weapons to equip!");
            }
        }
        else if(choice == 1){
            System.out.println("Which armor do you want to equip with?");
            ArrayList<Armor> armor = hero.getArmor();
            if(armor.size() > 0){
                for(int x=0; x<armor.size(); x++){
                    System.out.println("(" + x + ") " + armor.get(x));
                }
                int choice2 = utils.getIntInput(-1, armor.size()-1);
                hero.equipArmor(choice2);
            }
            else{
                System.out.println("No armor to equip!");
            }
        }

    }

    //use a spell
    public void useSpell(Hero hero, MonsterParty monsters){
        Random rand = new Random();
        Monster target = monsters.getIndex(hero.getTarget());
        if(rand.nextInt(100)+1 <= target.calcDodge()){
            System.out.println("The Monster Dodged!");
        }
        else{
            ArrayList<Spell> spells = hero.getSpells();
            if(spells.size() > 0){
                for(int x=0;x<spells.size();x++){
                    System.out.println("(" + x + ") " + spells.get(x));
                }
                int choice = utils.getIntInput(0, spells.size()-1);
                Spell spell = spells.get(choice);
                if(hero.applySpell(choice)){
                    int dmg = spell.getDamage();
                    target.takeDamage(dmg);
                    System.out.println("");
                    System.out.println(hero.getName() + " has done " + dmg + " to " + target.getName());
                    System.out.println("");
                    target.spellDebuff(spell);
                }
            }
            else{
                System.out.println("No spells to use!");
            }
        }
    }
}