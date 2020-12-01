package com.sample.app.ds.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class BubbleSort<T extends Integer> {

    public void sort(List<Integer> list, Character order)
    {
        for (int i=0; i <list.size()-1; i++)
        {

            for(int j=0;j<list.size()-i-1; j++)
            {
                int valJ=list.get(j);
                int  valJp1= list.get(j+1);
                if (valJ < valJp1)
                {
                    int temp = list.get(j);
                    list.set(j,valJp1);
                    list.set(j+1,valJ);
                    //break;
                }
            }
        }
    }
public static void main(String a[])
{
    List<Integer> list = new LinkedList<>(Arrays.asList(4,55,0,4,10,5,7,9,11,9,3));

    BubbleSort bs = new BubbleSort();
    bs.sort(list,'A');
    System.out.println("Sorted list:"+list);
}
}
