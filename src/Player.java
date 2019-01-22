public class Player {


    private String name = "Игрок";
    private int strength = 2;
    private int health = 80;

    Player (){
    }

    public int rollDice(int limit){
        System.out.println("Бросаем кубик");
        int result = (int) ( Math.random() * limit);
        System.out.println("Выпало: " + "\u001B[34m" + result + "\u001B[0m");
        return result;
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
}
