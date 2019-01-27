
public class Player {


    private String name = "Игрок";
    private int strength = 0;
    private int health = 0;
    private String race = "раса";

    Player (){
    }
    Player(String race, int strength, int health){
        this.race = race;
        this.strength = strength;
        this.health = health;
    }

    public void welcome(){
        System.out.println((Game.blue("Твое имя: ") + Game.green(getName())));
        System.out.println(Game.blue("Твоя раса: ") + Game.green(getRace()));
        System.out.println(Game.blue("Твоя сила: ") + Game.green(Integer.toString(getStrength())));
        System.out.println(Game.blue("Твое здоровье: ") + Game.green(Integer.toString(getHealth())));
        System.out.println();
    }

    public static int rollDice(int limit){
        System.out.println("Бросаем кубик");
        int result = (int) (( Math.random() * limit) + 1);
        System.out.println("Выпало: " + "\u001B[34m" + result + "\u001B[0m");
        return result;
    }

    public static void go(){
        System.out.println("Вы прошли на " + rollDice(5) + " клеток");
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
