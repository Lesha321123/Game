import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Player player = new Player();
        Enemy enemy = new Enemy();

        welcome(player, enemy);

        while (enemy.getHealth() > 0 || player.getHealth() > 0){
            fightPlayerVsEnemy(player,enemy);
            if (enemy.getHealth() <= 0){
                if (enemy.getHealth() <= 0) {
                    printGreen("Враг мертв!");
                    break;
                }
                break;
            }

            fightEnemyVsPlaer(player,enemy);

            if (player.getHealth() <= 0){
                if (player.getHealth() <= 0){
                    printRed("Ты мертв!");
                    break;
                }
                break;
            }
        }







    }


    public static String enterString() {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        return text;
    }

    public static void welcome(Player player, Enemy enemy){
        printGreen("Твое имя: " + player.getName());
        printGreen("Твоя сила: " + player.getStrength());
        printGreen("Твое здоровье: " + player.getHealth());
        System.out.println();
        printRed("Имя врага: " + enemy.getName());
        printRed("Сила врага: " + enemy.getStrength());
        printRed("Его здоровье: " + enemy.getHealth());
        System.out.println();
    }

    public static int diceRoll(int dice){
        double roll = Math.random() * dice;
        return (int) roll;
    }

    public static void fightPlayerVsEnemy(Player player, Enemy enemy){
        int damage = (player.getStrength() * diceRoll(6));
        printGreen("Ты наносишь урон врагу: " + damage);
        enemy.setHealth(enemy.getHealth() - damage);
        printRed("Здоровье врага: " + enemy.getHealth());
    }

    public static void fightEnemyVsPlaer(Player player, Enemy enemy){
        int damage = (enemy.getStrength() * diceRoll(6));
        printRed("Враг наносит тебе урон: " +  damage);
        player.setHealth(player.getHealth() - damage);
        printGreen("Твое здоровье: " + player.getHealth());
    }

    public static void printRed(String text){
        System.out.println("\u001B[31m" + text + "\u001B[0m");
    }

    public static void printGreen(String text){
        System.out.println("\u001B[32m" + text + "\u001B[0m");
    }



}

