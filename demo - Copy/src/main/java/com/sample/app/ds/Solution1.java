package com.sample.app.ds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution1 {

    // Complete the commonChild function below.
    int commonChild(String s1, String s2) {
        if (s1.length() != s2.length())
            return 0;
       /* String common = new String();
        String common2 = new String();

        for (int i = 0; i < s1.length(); i++) {
            String c = "" + s1.charAt(i);
            if (s2.contains(c)) {
                System.out.println("Common start:"+common);

                if (checkIfContainsInOrder(s2, common + c))
                    common += c;
                else if (checkIfContainsInOrder(s2, c + common))
                    common = c + common;
                System.out.println("Common end:"+common);
            }
        }


        for (int i = 0; i < s2.length(); i++) {
            String c = "" + s2.charAt(i);
            if (s1.contains(c)) {
                System.out.println("Common start:"+common2);

                if (checkIfContainsInOrder(s1, common2 + c))
                    common2 += c;
                else if (checkIfContainsInOrder(s1, c + common2))
                    common2 = c + common;
                System.out.println("Common end:"+common2);
            }
        }

        System.out.println("common:" + common);
        System.out.println("common2:" + common2);
        return common.length()>common2.length()?common.length():common2.length();
   */
        return commonSequence(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
    }

    private int commonSequence(char[] a1, char[] a2, int l1, int l2) {
        int LCS[][] = new int[l1 + 1][l2 + 1];
        int count = 0;

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                 if (a1[i] == a2[j]) {
                    LCS[i + 1][j + 1] = LCS[i][j] + 1;
                    //count = Integer.max(count, LCS[i][j]);
                    //count = count > LCS[i][j] ? count : LCS[i][j];
                } else
                    LCS[i + 1][j + 1] = LCS[i + 1][j] > LCS[i][j + 1] ? LCS[i + 1][j] : LCS[i][j + 1];


            }
        }
        return LCS[l1][l2];
        // return count+1;
    }

    private boolean checkIfContainsInOrder(String s1, String s2) {
        System.out.println("in checkIfContains input: s1:" + s1 + " s2:" + s2);

        if (s2 == null || s2.length() == 0) {
            System.out.println("in checkIfContains input: return false at start s1:" + s1 + " s2:" + s2);

            return false;
        }
        String s1Temp = s1;
        for (int i = 0; i < s2.length(); i++) {
            String tempChar = "" + s2.charAt(i);
            if (s1Temp.contains(tempChar)) {
                s1Temp = s1Temp.substring(s1Temp.indexOf(tempChar) + 1);
            } else {
                System.out.println("in checkIfContains false: s1:" + s1 + " s2:" + s2);
                return false;
            }

        }
        System.out.println("in checkIfContains true: s1:" + s1 + " s2:" + s2);
        return true;
    }

    private int checkCount(String string, String c) {
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == c.charAt(0))
                count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        Solution1 sol = new Solution1();
        System.out.println(sol.commonChild("ABDC", "ABCD"));
        System.out.println(sol.commonChild("HARRY", "SALLY"));
        System.out.println(sol.commonChild("SHINCHAN", "NOHARAAA"));
    }
}
