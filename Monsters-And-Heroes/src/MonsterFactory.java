//a factory to create monsters
public class MonsterFactory {
    public MonsterFactory(){

    }
    //create a monster
    public Monster createMonster(int type, String info, int targetLvl){
        Monster newMonster;
        switch (type){
            case 1:
                newMonster = new Dragon();
                break;
            case 2:
                newMonster = new Exoskeleton();
                break;
            case 3:
                newMonster = new Spirit();
                break;
            default: //default to a dragon
                newMonster = new Dragon();
                break;
        }
        //set attributes
        newMonster.setAttributes(info);
        //match target level
        newMonster.matchLevel(targetLvl);
        return  newMonster;
    }
}