import java.util.Map;
import java.util.HashMap;

public class App{

    public static void main(String[] args) {

        Map<String,Integer> hash = new HashMap<>();
        Map<String,Integer> hash2 = new HashMap<>();
        hash.put("A", 1);
        hash.put("B", 2);
        hash.put(null, 2);
        hash2.putAll(hash);
        System.out.println(hash2);
        System.out.println(hash);
    }

   
}