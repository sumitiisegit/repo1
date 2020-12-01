package com.sample.app.ds.series;

public class Series1 {

    // (1) + (2*3) + (4*5*6) + ..n

    public int series(int n) {

        int sum = 0, cur = 1, inner = 1;

        for (int i = 1; i <= n; i++) {
            inner = 1;
            for (int j = 1; j <= i; j++, cur++) {
                inner = inner * cur;
            }
            sum += inner;
        }
        return sum;
    }

    public static void main(String a[]) {
        Series1 series1 = new Series1();
        System.out.println(series1.series(1));

        System.out.println(series1.series(2));
        System.out.println(series1.series(3));

        System.out.println(series1.series(4));
        System.out.println(series1.series(5));
    }

}


