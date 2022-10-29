//interface to help facilitate a monster center
public interface MonsterCreator {
    //create a monster with info and a level matched
    Monster createMonster(String charInfo, int matchLevel);
}