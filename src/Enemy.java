public class Enemy {

    private String name;
    private int strength;
    private int health;

    Enemy (){
        this.name = name;
        this.strength = strength;
        this.health = health;

        System.out.println("Мой враг: " + name);
        System.out.println("Его сила: " + strength);
        System.out.println("Его здоровье: " + health);
        System.out.println();
    }
}
