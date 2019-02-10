package Game;


public class Level {

    private int enemyLocation;

    public Level(int enemyLocation){
        this.enemyLocation = enemyLocation;
        System.out.println("Враг находится на " + enemyLocation + " клетке");
    }

    public int getEnemyLocation() {
        return enemyLocation;
    }

    public void setEnemyLocation(int enemyLocation) {
        this.enemyLocation = enemyLocation;
    }
}
