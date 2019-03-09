package Player;


import Game.Level;
import static Game.Game.blueText;
import  static Game.Game.print;


public abstract class Player {


    public String name = "Игрок";
    public int strength;
    public int health;
    public String race = "раса";



    public void descriptionCharacter(){
        print(blueText("Твое имя: ") + (getName()));
        print(blueText("Твоя раса: ") + (getRace()));
        print(blueText("Твоя сила: ") + (Integer.toString(getStrength())));
        print(blueText("Твое здоровье: ") + (Integer.toString(getHealth())));
        System.out.println();
    }

    public static int rollDice(int limit){
        blueText(("Бросаем кубик"));
        int result = (int) (( Math.random() * limit) + 1);
        blueText(("Выпало: ") + "\u001B[34m" + result + "\u001B[0m");
        return result;
    }

    public static int go(int limit, Level level){
        int step = rollDice(limit);
        print(blueText(("Вы прошли на ") + step + (" клеток")));
        if (step > level.getEnemyLocation()){
            print(blueText("Вы встретили врага"));
        } else {
            print(blueText("Ничего не происходит"));
        }
        return step;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
