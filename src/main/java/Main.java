import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

import Excercise1.MultimapExcercise;
import collectionExamples.ConcurrentHashMapExample;
import collectionExamples.ConcurrentLinkedQueueExample;
import collectionExamples.CopyOnWriteArrayListExample;
import collectionExamples.CopyOnWriteArraySetExample;
import collectionExamples.CopyOnWriteArraySetExample2;
import sun.reflect.generics.tree.Tree;

public class Main
{
    public static void main(String[] args)
        throws IOException, URISyntaxException, IllegalAccessException, NoSuchFieldException
    {
        MultimapExcercise.printMap();
    }

    private static void testCopyOnWriteArrayListExample(boolean isCopyOnWriteArrayList){
        new CopyOnWriteArrayListExample(isCopyOnWriteArrayList);
        System.exit(0);
    }

    private static void testCopyOnWriteArraySetExample() {
        CopyOnWriteArraySetExample set = new CopyOnWriteArraySetExample();
        set.doSomething();
    }

    private static void testCopyOnWriteArraySetExample2() {
        new CopyOnWriteArraySetExample2();
    }

    private static void testConcurrentHashMapExample(){
        new ConcurrentHashMapExample();
    }

    private static void testConcurrentLinkedQueueExample() {
        new ConcurrentLinkedQueueExample();
    }
}
