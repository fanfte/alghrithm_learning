package com.fanfte.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.DirectoryStream;
import java.util.*;
import java.util.function.*;

/**
 * Created by dell on 2018/7/30
 **/
public class Test {

    static   Map<String, Function<Integer, Fruit>> fruitMap = new HashMap<>();

    static {
        fruitMap.put("apple", Apple::new);
        fruitMap.put("orange", Orange::new);
    }

    public static void main(String[] args) throws Exception {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple("green", 130));
        list.add(new Apple("yellow", 160));
        list.add(new Apple("red", 180));
        list.add(new Apple("blue", 190));

        System.out.println(filterApples(list, Apple::isGreenApple).size());

        System.out.println(filterApples(list, (Apple a) -> "green".equals(a.getColor())).size());

        printApple(list, new ApplePrettyFormatter());


        // lambda examples
        System.out.println("---------------------------");
        Runnable r = () -> System.out.println("hello world");

        process(r);
        process(() -> System.out.println("hello world3"));

        String s = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        System.out.println(s);

        // some functional interfaces
        System.out.println("some functional interfaces");

        // Predicate<T>
        java.util.function.Predicate<String> stringFilter =
                (String str) -> !str.isEmpty();
        List<String> l = new ArrayList<>();
        l.add("aa");
        l.add("bb");
        l.add("ccc");
        List<String> filter = filter(l, stringFilter);
        System.out.println(filter.size());

        // Consumer<T>
        forEach(l, (String ss) -> System.out.println(ss));

        // Function<T>
        List<Integer> map = map(l, (String s2) -> s2.length());
        System.out.println(map.size());

        // IntPredicate
        IntPredicate evenNumbers = (int i) -> i % 2 ==0;
        System.out.println(evenNumbers.test(1000));

        // 方法引用
        Function<Integer, Apple> s1 = Apple::new;
        Apple a1 = s1.apply(110);

        Supplier<Apple> s2 = Apple::new;
        Apple a2 = s2.get();

        BiFunction<String, Integer, Apple> bf = Apple::new;
        Apple a3 = bf.apply("yellow", 122);

        // 创建各种Fruit的Map
        Fruit apple = giveMeFruit("apple", 130);
        System.out.println(apple.getWeight());

        // 第一种实现
        list.sort(new AppleComparator());

        // 匿名内部类

        list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        // lambda表达式
        list.sort((Apple aa1, Apple aa2) -> ((Integer)aa1.getWeight()).compareTo(aa2.getWeight()));

        // lambda表达式参数类型推断
        list.sort((ele1, ele2) -> ((Integer)ele1.getWeight()).compareTo(ele2.getWeight()));

        // Comparator的静态辅助方法comparing()
        Comparator<Apple> comparing = Comparator.comparing((Apple mApple) -> mApple.getWeight());
        list.sort(Comparator.comparing((e) -> e.getWeight()));

        // 使用方法引用
        list.sort(Comparator.comparing(Apple::getWeight));

        System.out.println("_______________");
        forEach(list, (sc) -> System.out.println(sc.getWeight()));

        // 复合lambda
        list.sort(Comparator.comparing(Apple::getWeight).reversed());
        forEach(list, (cc) -> System.out.println(cc.getWeight()));
        System.out.println("---------------");

        // 比较器链
        list.sort(Comparator.comparing(Apple::getWeight)
                            .reversed()
                            .thenComparing(Apple::getColor));
        forEach(list, (cc) -> System.out.println(cc.getWeight()));

        System.out.println("---------------");

        // 谓词复合


        // 函数复合
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int res = h.apply(2);
        System.out.println(res);
        Function<Integer, Integer> k = g.compose(f);
        System.out.println(k.apply(1));

    }

    public static void printList(List<Apple> list) {
    }



    public static Fruit giveMeFruit(String fruit, Integer weight) {
        return fruitMap.get(fruit.toLowerCase()).apply(weight);
    }

    public static  <T> List<T> filter(List<T> list, java.util.function.Predicate<T> p) {
        List<T> l = new ArrayList<>();
        for(T s : list) {
            boolean test = p.test(s);
            if(test) {
                l.add(s);
            }
        }
        return l;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for(T t : list) {
            c.accept(t);
        }
    }

    public static void process(Runnable r) {
        r.run();
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    static void printApple(List<Apple> inventory, AppleFormatter f) {
        for(Apple a : inventory) {
            String accept = f.accept(a);
            System.out.println(accept);
        }
    }

    public static String processFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        return br.readLine();
    }

    public static String processFile(BufferedReaderProcessor p) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("d://data.txt"));
        return p.process(br);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
}
