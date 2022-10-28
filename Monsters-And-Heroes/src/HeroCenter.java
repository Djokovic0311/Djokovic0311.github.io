//center for hero generation
public class HeroCenter {
    //default constructor
    public HeroCenter(){

    }
    //create a hero
    public Hero createHero(int type){
        Hero newHero;
        switch(type){
            case 2:
                newHero = new Sorcerer();
                break;
            case 3:
                newHero = new Paladin();
                break;
            default:
                newHero = new Warrior();
                break;
        }
        return newHero;
    }
}