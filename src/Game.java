import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Player player = new Player();
        Enemy enemy = new Enemy();

        enterString(player.name);


    }


    public static void enterString(String text) {
        Scanner in = new Scanner(System.in);
        text = in.nextLine();
    }

}

