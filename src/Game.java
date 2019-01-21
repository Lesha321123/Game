import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Player player = new Player();
        Enemy enemy = new Enemy();

        print("Введите свое имя");
        player.setName(enterString());
        print("Введите имя врага");
        enemy.setName(enterString());
        welcome(player, enemy);

        fight(player,enemy);
        fight(player,enemy);





    }


    public static String enterString() {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        return text;
    }

    public static void welcome(Player player, Enemy enemy){
        System.out.println("Мое имя: " + player.getName());
        System.out.println("Моя сила: " + player.getStrength());
        System.out.println("Мое здоровье: " + player.getHealth());
        System.out.println();
        System.out.println("Имя врага: " + enemy.getName());
        System.out.println("Сила врага: " + enemy.getStrength());
        System.out.println("Его здоровье: " + enemy.getHealth());
        System.out.println();
    }

    public static int diceRoll(int dice){
        double roll = Math.random() * dice;
        return (int) roll;
    }

    public static void fight(Player player, Enemy enemy){
        int damage = (player.getStrength() * diceRoll(20));
        print("урон: " + damage);
        enemy.setHealth(enemy.getHealth() - damage);
        print("Здоровье врага: " + enemy.getHealth());
    }

    public static void print(String text){
        System.out.println(text);
    }



}

