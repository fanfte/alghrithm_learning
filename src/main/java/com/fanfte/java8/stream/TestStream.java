package com.fanfte.java8.stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by dell on 2018/8/1
 **/
public class TestStream {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        // stream使用例子
        List<String> collect = menu.stream().filter(d -> {
            System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(collect);

        // 流只能被消费一次
        List<String> strings = Arrays.asList("Java8", "In", "Action");
        Stream<String> stream = strings.stream();
        stream.forEach(System.out::println);
        // 抛出IllegalStateException: stream has already been operated upon or closed
//        stream.forEach(System.out::println);

        // streams测验
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect1 = integers.stream()
                .map(n -> n * n)
                .collect(toList());
        System.out.println(collect1);

        // 数对
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> collect2 = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                                  .filter(j -> (i + j) % 3 == 0)
                                  .map(j -> new int[]{i, j})
                        )
                .collect(toList());
        System.out.println(collect2);

        System.out.println("use stream--------");

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        List<Transaction> test1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(test1);

        List<String> test2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println("test2 " + test2);

        List<Trader> test3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .collect(toList());
        System.out.println(test3);

        System.out.println("test4------------------");

        String test4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b);

        System.out.println(test4);

        boolean b = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(b);

        transactions.stream()
                    .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);

        System.out.println("------------------------");
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(max.get());

        System.out.println("------------------------");
        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(min.get());

        System.out.println("------------------");

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        OptionalInt max1 = intStream.max();
        System.out.println(max1.getAsInt());
//        Stream<Integer> boxed = intStream.boxed();

        IntStream evenStream = IntStream.range(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evenStream.count());

        System.out.println("---------------------------------");
        Stream<int[]> gougu = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b1 -> Math.sqrt(a * a + b1 * b1) % 1 == 0)
                        .mapToObj(b1 -> new int[]{a, b1, (int) Math.sqrt(a * a + b1 * b1)})
                );

        gougu.limit(7)
             .forEach(tg -> System.out.println(tg[0] + " " + tg[1] + " " + tg[2]));



    }
}
