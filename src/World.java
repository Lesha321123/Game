import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class World {

    Map<String,Integer> map = new HashMap<>();


    public void createWorld(){

        for(int i = 0; i < 10; i++){
            map.put("level" + i, Game.random(10) + i * 10);
        }

        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String,Integer> pair = iterator.next();
            String level = pair.getKey();
            int number = pair.getValue();
            System.out.println(level + ": " + number);
        }
    }
}
