package Excercise1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import javafx.util.Pair;

public class MultimapExcercise
{
    public static HashMap printMap()
        throws IOException, URISyntaxException, IllegalAccessException, NoSuchFieldException
    {
        //HashMap<Integer, Set<String>> map = firstWay();
        HashMap<Integer, Set<String>> map = fillLambda();

        for (int key : map.keySet())
        {
            System.out.print("Key: " + key + "  Value: ");
            String value = "";
            //value = getValue(map.get(key));
            value += " InitialCapacity: ";
            value += getInitialCapacityFromSet(map);
            System.out.println(value);
        }

        return map;
    }

    private static HashMap<Integer, Set<String>> firstWay() throws IOException, URISyntaxException
    {
        HashMap map = new HashMap<Integer, Set<String>>();
        BufferedReader br = new BufferedReader(new FileReader(getInitFile()));
        String line = "";

        while ((line = br.readLine()) != null)
        {
            String[] result = line.split(",");
            Integer key = Integer.parseInt(result[0]);

            if (map.containsKey(key))
            {
                Set set = (Set) map.get(key);
                set.add(result[1]);
            }
            else
            {
                map.put(Integer.parseInt(result[0]), new HashSet<String>(Arrays.asList(result[1])));
            }
        }
        return map;
    }



    public static HashMap fillMethodReference() throws IOException, URISyntaxException
    {
        HashMap<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();

        BufferedReader br = new BufferedReader(new FileReader(getInitFile()));
        br.lines().forEach(MultimapExcercise::putInMap(br.readLine()), map);

        return map;
    }


    public static HashMap fillLambda() throws IOException, URISyntaxException
    {
        HashMap<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();

        BufferedReader br = new BufferedReader(new FileReader(getInitFile()));
        BiConsumer<HashMap<Integer, Set<String>> fillMap = (string, map) -> putInMap(string, map);

        return map;
    }

    public static HashMap putInMap(String string, HashMap<Integer, Set<String>> map){
        HashSet<String> set = (HashSet) map.get(getKey(string));
        set.add(getValue(string));
        map.put(getKey(string), set);
        return map;
    }

    public static int getKey(String line){
        String[] result = line.split(",");
        return Integer.parseInt(result[0]);
    }

    public static String getValue(String line){
        String[] result = line.split(",");
        return result[1];
    }

    public static HashMap<Integer, Set<String>> some(String line, HashMap<Integer, Set<String>> map)
    {
        String[] result = line.split(",");
        Integer key = Integer.parseInt(result[0]);
        String value = result[1];

        if (map.containsKey(key))
        {
            Set set = map.get(key);
            set.add(result[1]);
            map.put(key, set);
        }
        else
        {
            Set set = new HashSet();
            set.add(value);
        }
        return map;
    }

    private static String getValue(Set<String> key)
    {
        boolean split = true;
        String value = "";
        for (String string : key)
        {
            if (split)
            {
                value = string;
                split = false;
            }
            else
            {
                value += "," + string;
            }

        }
        return value;
    }

    private static int getInitialCapacityFromSet(HashMap<Integer, Set<String>> map)
        throws NoSuchFieldException, IllegalAccessException
    {
        HashMap m = map;
        Field tableField = null;
        tableField = map.getClass().getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(m);

        return table == null ? 0 : table.length;
    }

    private static File getInitFile() throws URISyntaxException
    {
        String path =
            Paths.get(MultimapExcercise.class.getProtectionDomain().getCodeSource().getLocation().toURI()).toString();
        File file = new File(path + "\\text.csv");
        return file;
    }

}
