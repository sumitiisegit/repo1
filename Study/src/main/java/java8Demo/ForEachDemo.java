package java8Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachDemo {

    public static void main(String[] args) {
        List<Integer> values=Arrays.asList(1,3,5,6,7,34);
        //External loop
        System.out.println("legacy method:");
        for (int i=0; i <values.size(); i++){
            System.out.print(values.get(i));
        }

        //External loop
        System.out.println("\n enhanced for loop:");
        for (int j:values){
            System.out.print(j);
        }

        // internal for loop to collections. faster
        System.out.println("\n Java8 For each loop:");
        values.forEach(k->System.out.print(k));  // -> lambda implementaiton of Consumer interface

    }
}

