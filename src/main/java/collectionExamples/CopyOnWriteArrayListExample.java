package collectionExamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample
{
    List<String> list;


    public CopyOnWriteArrayListExample(boolean isCopyOnWriteArrayList)
    {
        List<String> list1 = new ArrayList<String>();
        list1.add("first");
        list1.add("second");
        list1.add("third");
        list1.add("forth");
        list1.add("fifth");
        list1.add("sixth");
        list1.add("seventh");
        list1.add("eight");

        if(isCopyOnWriteArrayList){
            list = new CopyOnWriteArrayList<String>(list1);
        }
        else
        {
            list = new ArrayList<String>(list1);
        }

        System.out.println("cycle");
        printCollection(true);
        System.out.println("cycle with change");
        printCollection(false);
    }



    private void printCollection(boolean writeOperation)
    {
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.printf("  %s %n", element);
            if(writeOperation) {
                if(element.equals("second") || element.equals("second")) {
                    list.add("new string");
                    list.remove(element);
                }
            }
        }

    }

}
