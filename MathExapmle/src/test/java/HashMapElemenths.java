import java.util.HashMap;
import java.util.Map;

public class HashMapElemenths {



    public static void main(String[] args) {
        HashMapElements();
    }

    public static void HashMapElements(){
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("Катя", 1);
        hashMap.put("Лиля", 2);
        hashMap.put("Лёня", 3);

        for(Map.Entry element : hashMap.entrySet() ){
            System.out.println(element.getKey() + ": " + element.getValue());

        }
    }
}
