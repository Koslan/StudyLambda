package collectionExamples;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample
{
    public void doSomething(){
        Publisher publisher = new Publisher();

        Subscriber one = new Subscriber("one");
        Subscriber two = new Subscriber("two");
        Subscriber three = new Subscriber("three");
        Subscriber four = new Subscriber("four");
        Subscriber five = new Subscriber("five");

        publisher.addSubscriber(one);
        publisher.addSubscriber(two);
        publisher.addSubscriber(three);
        publisher.addSubscriber(four);
        publisher.addSubscriber(five);

        publisher.notifySubs("Eleven");
        publisher.notifySubs("Twelve");
        publisher.notifySubs("Thirteen");
        publisher.notifySubs("Fourteen");
    }

}

class Publisher {
    private Set setOfSubs = new CopyOnWriteArraySet();

    public void addSubscriber(Subscriber sub) {
        setOfSubs.add(sub);
    }

    public void notifySubs(String score) {
        Iterator itr = setOfSubs.iterator();
        while(itr.hasNext()) {
            Subscriber sub = (Subscriber) itr.next();
            sub.receive(score);
        }
    }
}

class Subscriber {
    private String name;
    public Subscriber(String name) {
        this.name = name;
    }

    public void receive(String score) {
        System.out.printf("[%-5s]  Event received: %s %n", name, score);
    }
}