package collectionExamples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample
{
    Map<String, String> map;

    public ConcurrentHashMapExample(){
        System.out.println("ConcurrentHashMap");
        createMap(true);
        addValue(true);

        System.out.println("\n\nHashMap");
        createMap(false);
        addValue(false);
    }

    private void addValue(boolean concurrent)
    {
        System.out.println(" before iterator : " + map);
        Iterator<String> iter = map.keySet().iterator();

        System.out.print(" cycle : ");
        while(iter.hasNext()){
            String key = iter.next();
            if (key.equals("3")) {
                map.put(key + "new", "222");
            } else {
                System.out.println(" " + key + "=" + map.get(key));
            }
            System.out.println(" after iterator : " + map);
        }
    }

    private void createMap(boolean concurrent)
    {
        if (concurrent) {
            map = new ConcurrentHashMap<String, String>();
        } else {
            map = new HashMap<String, String>();
        }
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");
        map.put("6", "1");
    }

}
