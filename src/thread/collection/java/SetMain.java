package thread.collection.java;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> set = new CopyOnWriteArraySet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println("set = " + set);

        ConcurrentSkipListSet<Object> skipSet = new ConcurrentSkipListSet<>();
        skipSet.add(3);
        skipSet.add(1);
        skipSet.add(2);
        System.out.println("skipSet = " + skipSet);
    }
}
