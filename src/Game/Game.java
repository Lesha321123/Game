package Game;

import Enemy.Enemy;
import Player.Player;
import Player.Human;
import Player.Dwarf;
import Player.Elf;

import java.util.*;


public class Game {
    public static void main(String[] args)   {

        // Создание персонажа
        Scanner in = new Scanner(System.in);

        print(blue("Выбери расу"));
        print(blue("Человек: 1"));
        print(blue("Гном:    2"));
        print(blue("Эльф:    3"));
        Player player = null;
        while (player == null) {
            int choice = 0;
            try {
                choice = in.nextInt();
            }

            catch (Exception e)
            {
                print(red("Нужно ввести число от 1 до 3"));

            }
                switch (choice) {
                    case 1:
                        player = new Human("Человек", 4, 80);
                        print("Выбрано: человек");
                        break;
                    case 2:
                        player = new Dwarf("Гном", 7, 120);
                        print("Выбрано: гном");
                        break;
                    case 3:
                        player = new Elf("Эльф", 5, 100);
                        print("Выбрано: эльф");
                        break;
                    default:
                        print(red("Значение должно быть от 1 до 3"));
                        continue;
                }

        }

        print(blue("Введи имя персонажа"));
        player.setName(enterText());
        player.welcome();

        // Создание мира
        Level level = new Level(random(10));
        // Движение
        player.go(10, level);
        // Создание врага
        Enemy enemy = new Enemy();

         //Автобой
         fight(player, enemy);











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
        System.out.println(blue("Твое здоровье: ")  + green(Integer.toString(player.getHealth())));
        System.out.println(blue("Здоровье врага: ")  + red(Integer.toString(enemy.getHealth())));
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

    public static String enterText(){
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        return text;
    }

    public static int enterNumber(){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        return number;
    }







}

