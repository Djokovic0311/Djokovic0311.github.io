//a group of monsters in rpg games
public class MonsterParty {
    private Monster[] monsters;
    public MonsterParty(){

    }
    //generate a monster party
    public MonsterParty(int num){
        monsters = new Monster[num];
    }

    //print all the alive monsters
    @Override
    public String toString(){
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("\n");
        toPrint.append("Alibe Monsters: \n");
        for(Monster monster : monsters) {
            if(monster.getHp() > 0) {
                toPrint.append(monster).append("\n");
                toPrint.append("\n");
            }
        }
        return toPrint.toString();
    }

    //return true if every monster is dead
    public boolean allDead(){
        int count = 0;
        for(Monster monster : monsters) {
            if(monster.isDead()) {
                count++;
            }
        }
        return count == monsters.length;
    }

    //number of monster still alive
    public int numAlive(){
        int count =0;
        for (Monster monster : monsters) {
            if(!(monster.isDead())) {
                count++;
            }
        }
        return count;
    }

    //return alive monster indexes
    public int[] aliveIndexes(){
        int[] alive = new int[numAlive()];
        int count = 0;
        for(int x = 0; x<monsters.length; x++){
            if(!(monsters[x].isDead())){
                alive[count] = x;
                count++;
            }
        }
        return alive;
    }

    //get the length
    public int getLength(){
        return monsters.length;
    }

    //get a monster at an index
    public Monster getIndex(int index){
        return monsters[index];
    }
    //set a monster at an index
    public void setIndex(int index, Monster mon){
        monsters[index] = mon;
    }


}