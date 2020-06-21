package com.sample.app.ds.search;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinarySearch<T extends Integer> {

    public int search(List<Integer> list, Integer item)
    {
        int position = -1;
        int first = 0, last = list.size()-1, mid=last/2;

        while(first<=last)
        {
            if (list.get(mid) < item)
            {
             first = mid+1;
            }
            else
                if (list.get(mid) > item)
                {
                    last= mid-1;
                }
                else if (list.get(mid)==item)
                {
                    position=mid;
                    System.out.println("Item:"+item +" found at position:"+position);
                    break;
                }

                mid=(last+first)/2;
        }
        if(position == -1)
            System.out.println("Item:"+item+" not found in list:"+list);

        return position;
    }

    public static void main(String a[])
    {
        List<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5,7,8,9));

        BinarySearch bs = new BinarySearch();

        bs.search(list,6);
        bs.search(list,1);
        bs.search(list,5);
        bs.search(list,10);
    }

}
