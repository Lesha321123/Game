package Player;


import Game.Game;
import Game.Level;

import static Game.Game.blue;
import  static Game.Game.print;


public abstract class Player {


    public String name = "Игрок";
    public int strength = 0;
    public int health = 0;
    public String race = "раса";

    Player (){
    }
    public Player(String race, int strength, int health){
        this.race = race;
        this.strength = strength;
        this.health = health;
    }

    public void welcome(){
        print(blue("Твое имя: ") + (getName()));
        print(blue("Твоя раса: ") + (getRace()));
        print(blue("Твоя сила: ") + (Integer.toString(getStrength())));
        print(blue("Твое здоровье: ") + (Integer.toString(getHealth())));
        System.out.println();
    }

    public static int rollDice(int limit){
        blue(("Бросаем кубик"));
        int result = (int) (( Math.random() * limit) + 1);
        blue(("Выпало: ") + "\u001B[34m" + result + "\u001B[0m");
        return result;
    }

    public static int go(int limit, Level level){
        int step = rollDice(limit);
        print(blue(("Вы прошли на ") + step + (" клеток")));
        if (step > level.getEnemyLocation()){
            print(blue("Вы встретили врага"));
        } else {
            print(blue("Ничего не происходит"));
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
