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

        print(blueText("Выбери расу"));
        print(blueText("Человек: 1"));
        print(blueText("Гном:    2"));
        print(blueText("Эльф:    3"));
        Player player = null;
        while (player == null) {
            int choice = 0;
            try {
                choice = in.nextInt();
            }

            catch (Exception e)
            {
                print(redText("Нужно ввести число от 1 до 3"));

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
                        print(redText("Значение должно быть от 1 до 3"));
                        continue;
                }

        }

        print(blueText("Введи имя персонажа"));
        player.setName(enterText());
        player.descriptionCharacter();

        // Создание мира
        Level level = new Level(setRandom(10));
        // Движение
        player.go(10, level);
        // Создание врага
        Enemy enemy = new Enemy();

         //Автобой
         fight(player, enemy);
    }




    public static int setRandom(int limit){
        double roll = Math.random() * limit;
        return (int) roll;
    }

    public static void playerBeatsEnemy(Player player, Enemy enemy){
        int damage = (player.getStrength() * setRandom(6));
        print(blueText("Ты наносишь урон врагу: ") + greenText(Integer.toString(damage)));
        enemy.setHealth(enemy.getHealth() - damage);
        print(blueText("Здоровье врага: ") + redText(Integer.toString(enemy.getHealth())));
    }

    public static void enemyBeatsPlayer(Player player, Enemy enemy){
        int damage = (enemy.getStrength() * setRandom(6));
        print(blueText("Враг наносит тебе урон: ") + redText(Integer.toString(damage)));
        player.setHealth(player.getHealth() - damage);
        print(blueText("Твое здоровье: ") + greenText(Integer.toString(player.getHealth())));
    }

    public static void fight(Player player, Enemy enemy){
        System.out.println(blueText("Твое здоровье: ")  + greenText(Integer.toString(player.getHealth())));
        System.out.println(blueText("Здоровье врага: ")  + redText(Integer.toString(enemy.getHealth())));
        while (enemy.getHealth() > 0 || player.getHealth() > 0){
            playerBeatsEnemy(player,enemy);
            if (enemy.getHealth() <= 0){
                if (enemy.getHealth() <= 0) {
                    print(greenText("Враг мертв!"));
                    break;
                }
                break;
            }

            enemyBeatsPlayer(player,enemy);

            if (player.getHealth() <= 0){
                if (player.getHealth() <= 0){
                    print(redText("Ты мертв!"));
                    break;
                }
                break;
            }
        }
    }

    public static String redText(String text){
        String textColor = "\u001B[31m" + text + "\u001B[0m";
        return textColor;
    }

    public static String greenText(String text){
        String textColor = "\u001B[32m" + text + "\u001B[0m";
        return textColor;
    }

    public static String blueText(String text){
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

