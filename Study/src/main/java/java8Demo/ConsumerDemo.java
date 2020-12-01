package java8Demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
class ConsumerImpl implements Consumer<Integer>{

    @Override
    public void accept(Integer i) {
        System.out.println("ConsumerImpl i:"+i);

    }
}*/
public class ConsumerDemo {


    public static void main(String[] args) {


        List<Integer> values = Arrays.asList(1, 3, 5, 6, 7, 34);
        //System.out.println("\n Java8 For each loop:");
        //values.forEach(k->System.out.print(k));  // -> lambda implementaiton of Consumer interface

        // using class above
//        Consumer<Integer> consumer = new ConsumerImpl();
//        values.forEach(consumer);

        // Annonymous class
        Consumer<Integer> consumer = new Consumer<Integer>() {
            public void accept(Integer i) {
                System.out.println("i:" + i);
            }
        };
        values.forEach(consumer);


        Consumer<Integer> consumer1 = (Integer i) -> {
            System.out.println("ci:" + i);
        };
        values.forEach(consumer1);

        Consumer<Integer> consumer2 = (i) -> {
            System.out.println("c2i:" + i);
        };
        values.forEach(consumer2);


        Consumer<Integer> consumer3 = i ->
                System.out.println("c3i:" + i);

        values.forEach(consumer3);

        values.forEach(i->System.out.println("ccc:"+i));

        // method references
        values.forEach(System.out::println);

    }
}

