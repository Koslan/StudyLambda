package collectionExamples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample2
{
    List<User> list;

    CopyOnWriteArraySet<User> cowSet;

    public CopyOnWriteArraySetExample2()
    {
        list = new ArrayList<User>();
        list.add(new User ("Jon"));
        list.add(new User ("Din"));
        list.add(new User ("Sem"));

        cowSet = new CopyOnWriteArraySet<User>(list);

        System.out.println("Cycle with changes");

        Iterator<User> itr = cowSet.iterator();
        int cnt = 0;
        while (itr.hasNext()) {
            User user  = itr.next();
            System.out.println(" " + user.name);
            if (++cnt == 2) {
                cowSet.add(new User("Tim"));
                user.name += " Barton";
            }
        }

        System.out.println("cycle without change");
        itr = cowSet.iterator();
        while (itr.hasNext()) {
            User user = itr.next();
            System.out.println(" " + user.name);
        }

        System.out.println("\n **\n Итератор набора данных CopyOnWriteArraySet не вызвал исключения \n ConcurrentModificationException при одновременном переборе и изменении значений");

    }

    class User
    {
        private String name;

        public User(String name)
        {
            this.name = name;
        }
    }
}


