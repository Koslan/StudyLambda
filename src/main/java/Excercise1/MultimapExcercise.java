package Excercise1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.util.Pair;

public class MultimapExcercise
{
    public static HashMap printMap()
        throws IOException, URISyntaxException, IllegalAccessException, NoSuchFieldException
    {
        //HashMap<Integer, Set<String>> map = firstWay();
        HashMap<Integer, Set<String>> map = fillNewJava();

        for (int key : map.keySet())
        {
            System.out.print("Key: " + key );
            System.out.print("  InitialCapacity: " + getInitialCapacityFromSet(map));
            System.out.print("   Value: " + getValue(map.get(key)));
            System.out.println();
        }

        return map;
    }

    public static HashMap fillNewJava() throws IOException, URISyntaxException
    {
        List<Model> list = new BufferedReader(new FileReader(getInitFile())).lines().map(s -> new Model(s)).collect(
            Collectors.toList());

        Map<Integer, Set<String>> map = list
            .stream()
            .collect(Collectors.groupingBy(Model::getKey,
                                           Collectors.mapping(Model::getValue, Collectors.toSet())));
        return new HashMap<>(map);
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
        value = String.format("%5s",value);
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
        File file = new File(path + "\\text.txt");
        return file;
    }

}
