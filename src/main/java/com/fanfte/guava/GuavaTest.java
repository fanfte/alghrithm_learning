package com.fanfte.guava;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.*;

import java.util.*;

/**
 * Created by tianen on 2018/9/5
 *
 * @author fanfte
 * @date 2018/9/5
 **/
public class GuavaTest {

    public static void main(String[] args) {
//        Optional<Integer> integer = Optional.of(5);
//        System.out.println(integer.isPresent());
//
//        System.out.println(integer.get());
//
//        Optional<Object> absent = Optional.absent();
////        System.out.println(absent.get());
//        System.out.println(absent.isPresent());
//
//        Integer or = integer.or(6);
//
////        Preconditions.checkArgument();
//
//        System.out.println(Objects.equal(null, null));
//
//        Set<String> set = new HashSet<>();
//        set.add("a");
//        ImmutableSet<String> iSet = ImmutableSet.of("a", "b", "c");
//        ImmutableMap<String, Integer> iMap = ImmutableMap.of("a", 1, "b", 2);
//
//        ImmutableSortedSet<Character> iSortedSet = ImmutableSortedSet.of('a', '0', 'c', 'a', 'w', 'd');
//        System.out.println(iSortedSet);

//        testMultiMap();

//        System.out.println(System.currentTimeMillis());

        testBiMap();

    }

    public static void testWordCount() {
        String strWorld="wer|dfd|dd|dfd|dda|de|dr";
        String[] words = strWorld.split("\\|");
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
        }
        HashMultiset<String> objects = HashMultiset.create();
        objects.addAll(list);
        for (String key : objects.elementSet()) {
            System.out.println(key + " count:" + objects.count(key));
        }
        Set<Multiset.Entry<String>> entries = objects.entrySet();
        for (Multiset.Entry<String> entry : entries) {
            System.out.println("entry: key" + entry.getElement() + " count :" + entry.getCount());
        }

        Iterator<String> iterator = objects.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println(objects.size());
    }

    public static void testMultiMap() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("Fruit", "Apple");
        multimap.put("Fruit", "Banana");
        multimap.put("Fruit", "Banana");
        multimap.put("Fruit", "Grape");
        multimap.put("Fruit", "Orange");

        multimap.put("Vegetables", "Carrot");
        multimap.put("Vegetables", "Carrot2");

        Collection<String> fruit = multimap.get("Fruit");
        System.out.println(fruit);
        ImmutableSet<String> fruit1 = ImmutableSet.copyOf(multimap.get("Fruit"));
        System.out.println(fruit1);

        for (String s : multimap.values()) {
            System.out.println(s);
        }
        System.out.println(multimap.size());
        System.out.println(multimap.keys());


        System.out.println("---------------------");
        Multimap<String, String> hashMultimap = HashMultimap.create();
        hashMultimap.put("student", "John");
        hashMultimap.put("student", "Jack");
        hashMultimap.put("student", "Jack");
        System.out.println(hashMultimap.get("student"));

        Lists.newArrayList();
        Maps.newHashMap();


    }

    public static void testBiMap() {
        HashBiMap<Integer, String> hashBiMap = HashBiMap.create();
        hashBiMap.put(1, "a1.logs");
        hashBiMap.put(2, "a2.logs");
        hashBiMap.put(3, "a3.logs");

        System.out.println("bimap " + hashBiMap);

        BiMap<String, Integer> inverse = hashBiMap.inverse();
        System.out.println("inverse " + inverse);
        inverse.put("a4.logs", 4);
        System.out.println(hashBiMap);
    }

}
