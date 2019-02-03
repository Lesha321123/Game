package Player;


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
        System.out.println((("Твое имя: ") + (getName())));
        System.out.println(("Твоя раса: ") + (getRace()));
        System.out.println(("Твоя сила: ") + (Integer.toString(getStrength())));
        System.out.println(("Твое здоровье: ") + (Integer.toString(getHealth())));
        System.out.println();
    }

    public static int rollDice(int limit){
        System.out.println(("Бросаем кубик"));
        int result = (int) (( Math.random() * limit) + 1);
        System.out.println(("Выпало: ") + "\u001B[34m" + result + "\u001B[0m");
        return result;
    }

    public static int go(int limit){
        int step = rollDice(limit);
        System.out.println(("Вы прошли на ") + step + (" клеток"));
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
