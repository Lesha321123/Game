import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Player player = new Player();
        Enemy enemy = new Enemy();

        welcome(player, enemy);
        player.rollDice(4);

        fight(player, enemy);











    }




    public static void welcome(Player player, Enemy enemy){
        print(blue("Твое имя: ") + green(player.getName()));
        print(blue("Твоя сила: ") + green(Integer.toString(player.getStrength())));
        print(blue("Твое здоровье: ") + green(Integer.toString(player.getHealth())));
        System.out.println();
        print(blue("Имя врага: ") + red(enemy.getName()));
        print(blue("Сила врага: ") + red(Integer.toString(enemy.getStrength())));
        print(blue("Его здоровье: ") + red(Integer.toString(enemy.getHealth())));
        System.out.println();
    }

    public static int random(int limit){
        double roll = Math.random() * limit;
        return (int) roll;
    }

    public static void playerBeatsEnemy(Player player, Enemy enemy){
        int damage = (player.getStrength() * random(6));
        print(blue("Ты наносишь урон врагу: ") + green(Integer.toString(damage)));
        enemy.setHealth(enemy.getHealth() - damage);
        print(blue("Здоровье врага: ") + red(Integer.toString(enemy.getHealth())));
    }

    public static void enemyBeatsPlayer(Player player, Enemy enemy){
        int damage = (enemy.getStrength() * random(6));
        print(blue("Враг наносит тебе урон: ") + red(Integer.toString(damage)));
        player.setHealth(player.getHealth() - damage);
        print(blue("Твое здоровье: ") + green(Integer.toString(player.getHealth())));
    }

    public static void fight(Player player, Enemy enemy){
        while (enemy.getHealth() > 0 || player.getHealth() > 0){
            playerBeatsEnemy(player,enemy);
            if (enemy.getHealth() <= 0){
                if (enemy.getHealth() <= 0) {
                    print(green("Враг мертв!"));
                    break;
                }
                break;
            }

            enemyBeatsPlayer(player,enemy);

            if (player.getHealth() <= 0){
                if (player.getHealth() <= 0){
                    print(red("Ты мертв!"));
                    break;
                }
                break;
            }
        }
    }

    public static String red(String text){
        String textColor = "\u001B[31m" + text + "\u001B[0m";
        return textColor;
    }

    public static String green(String text){
        String textColor = "\u001B[32m" + text + "\u001B[0m";
        return textColor;
    }

    public static String blue(String text){
        String textColor = "\u001B[34m" + text + "\u001B[0m";
        return textColor;
    }

    public static void print(String text){
        System.out.println(text);
    }







}

