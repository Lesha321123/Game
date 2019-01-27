import java.util.Scanner;

public class Game {
    public static void main(String[] args)  {

        // Создание персонажа
        Scanner in = new Scanner(System.in);
        System.out.println("Выбери расу");
        System.out.println("1. Человек");
        System.out.println("2. Гном");
        System.out.println("3. Эльф");
        Player player = null;
        int choice = in.nextInt();
        switch (choice){
            case 1:
                player = new Player("Человек",4,80);
                System.out.println("Выбрано: человек");
                break;
            case 2:
                player = new Player("Гном",7,120);
                System.out.println("Выбрано: гном");
                break;
            case 3:
                player = new Player("Эльф",5,100);
                System.out.println("Выбрано: эльф");
                break;
            default:
                System.out.println("Значение должно быть от 1 до 3");
                break;
        }
        System.out.println("Выбери имя персонажа");
        player.setName(enterText());
        System.out.println("Имя персонажа: " + player.getName());
        player.welcome();
        
        // Создание врага
        Enemy enemy = new Enemy();
        // Движение
         player.go();
         // Автобой
         fight(player, enemy);











    }



    public static void createCharacter(Player player){

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

