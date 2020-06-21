package prog;

import java.util.ArrayList;
import java.util.List;

public class Fibo {
    public static void main(String s[])
    {
        Fibo f = new Fibo();
        java.util.List<Integer> a = new ArrayList();

        a= f.fibSeries(2, 15);
        System.out.println(a);

        a= f.fibSeries(1, 15);
        System.out.println(a);

        a= f.fibSeries(0, 15);
        System.out.println(a);

        a= f.fibSeries(5, 15);
        System.out.println(a);

    }

    public java.util.List<Integer> fibSeries(Integer start, Integer end){
        List<Integer> series = new ArrayList<>();


        int first =1, second=1, next= 2;

        if(start ==2) {
            series.add(next);
        }else if (start==1 || start==0)
        {
            series.add(first);
            series.add(second);
            series.add(next);
        }
        while(true)
        {
            first = second;
            second = next;
            next = first + second;
if (next>end )
    break;
         if ( start >next) continue;

            series.add(next);
        }

        return series;
    }
}
