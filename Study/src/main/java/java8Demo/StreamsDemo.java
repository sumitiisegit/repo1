package java8Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsDemo {

    public static void main(String[] args) {
        List<Integer> values=new ArrayList<>();
        for(int i=0; i<20; i++)
        {
            values.add(i);
        }
        //values.forEach(k->System.out.print(" "+k));
        //values.stream().forEach(k->System.out.print(" "+k));
        values.parallelStream().forEach(k->System.out.print(" "+k));



    }
}

