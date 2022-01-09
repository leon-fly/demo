package com.leon.demo.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author : LeonWang
 * @Descpriction
 * @Date:created 1/8/22
 */
public class StreamDemo {
    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 10, -1, -5, -9);
        streamDemo.testListStream(list);

        streamDemo.testMapStream();
    }

    public void testListStream(List<Integer> list) {
        System.out.println("原始数据：" + list);
        //过滤结果
        List<Integer> filterResult = list.stream().filter(i -> i > 0).collect(Collectors.toList());
        System.out.println(filterResult);

        boolean matchResult = list.stream().anyMatch(i -> i % 2 == 0);
        System.out.println("是否有2的整数倍的数据：" + matchResult);

        boolean matchResult2 = list.stream().allMatch(i -> i > -100);
        System.out.println("是否全部大于-100 : " + matchResult2);

        boolean matchResult3 = list.stream().noneMatch(i -> i > 100);
        System.out.println("是否全部不大于100 ： " + matchResult3);


        //map 对原数据进行修改
        List<Integer> mapList = list.stream().map(new NumberReset()).collect(Collectors.toList()); // 方式1：匿名函数
        System.out.println("方式1，对小于0的数据设置为0 ：" + mapList);

        List<Integer> mapList2 = list.stream().map(x -> x > 0 ? x : 0).collect(Collectors.toList()); // 方式2
        System.out.println("方式2, 对小于0的数据设置为0 ：" + mapList2);

        // peek操作:中间操作
        System.out.println("peek test : " + list.stream().filter(i -> i > 0).peek(x -> System.out.println("peek : " + x)).collect(Collectors.toList()));

        // reduce : 对每个元素与上次执行结果进行运行最后返回一个最终累算结果
        System.out.println("reduce test， 累加: " + list.stream().reduce(0, (x, y) -> x + y));

        // find any
        list.stream().findAny().ifPresent(x -> System.out.println("find any 测试，找到元素:" + x));
    }

    public void testMapStream() {
        //将list转为map
        Map<String, Person> map = Stream.of(
                new Person("001", "leon", 18), new Person("002", "zhang", 18))
                .collect(Collectors.toMap(Person::getId, Function.identity(), (x, y) -> y));
        System.out.println("map1 : " + map);

        //将list转为map, 当有重复key时，需要指定合并方法, 否则可能报错
        Map<String, Person> map2 = Stream.of(
                new Person("001", "leon", 18), new Person("001", "zhang", 18))
                .collect(Collectors.toMap(Person::getId, Function.identity(), (x, y) -> y));
        System.out.println("map2 : " + map2);

        //讲list转为map, id作为key，set作为value，相同的id对应的值放到同一个set中
        Map<String, Set<Person>> map3 = Stream.of(
                new Person("002", "leon", 18), new Person("002", "zhang", 18),
                new Person("001", "leon", 18))
                .collect(Collectors.toMap(Person::getId,
                        p -> Collections.singleton(p),
                        (x, y) -> {
                            Set<Person> set = new HashSet<>(x);
                            set.addAll(y);
                            return set;
                        }));
        System.out.println("map3 : " + map3);


        //讲list转为map, id作为key，set作为value，相同的id对应的值放到同一个set中, 并放入treemap中
        Map<String, Set<Person>> map4 = Stream.of(
                new Person("002", "leon", 18), new Person("002", "zhang", 18),
                new Person("001", "leon", 18))
                .collect(Collectors.toMap(Person::getId,
                        p -> Collections.singleton(p),
                        (x, y) -> {
                            Set<Person> set = new HashSet<>(x);
                            set.addAll(y);
                            return set;
                        },
                        HashMap::new));
        System.out.println("map4 : " + map4);
    }

    public class NumberReset implements Function<Integer, Integer> {

        @Override
        public Integer apply(Integer integer) {
            return integer < 0 ? 0 : integer;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Person {
        private String id;
        private String name;
        private int age;
    }

}
