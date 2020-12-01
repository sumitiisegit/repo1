package com.sample.app.ds.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSort<T extends Integer> {


    public void sort(int[] input) {
        int size = input.length - 1;
        int startIndex = 0;

        mergeSort(input, startIndex, size);

        System.out.println("final sorted input:");
        printArray(input);
    }

    private void mergeSort(int[] input, int start, int end) {

        System.out.println("mergeSort start:" + start + " end:" + end);
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
            merge(input, start, mid, end);
        }
    }

    private void merge(int[] input, int start, int mid, int end) {

        System.out.println("merge start:" + start + " mid:" + mid + " end:" + end);
        System.out.println("Input at start:");
        printArray(input);

        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] lArray = new int[n1];
        int[] rArray = new int[n2];

        for (int l = 0; l < n1; ++l)
            lArray[l] = input[start + l];
        for (int m = 0; m < n2; m++)
            rArray[m] = input[mid + 1 + m];

        System.out.println("lArray:");
        printArray(lArray);

        System.out.println("rArray:");
        printArray(rArray);
        int i = 0, j = 0, k = start;

        while(i < n1 && j < n2) {
            if (lArray[i] <= rArray[j]) {
                input[k] = lArray[i];
                i++;
            } else {
                input[k] = rArray[j];
                j++;
            }
            k++;
        }

        System.out.println("Input in between:");
        printArray(input);

        while (i < n1) {
            input[k] = lArray[i];
            i++;
            k++;
        }

        System.out.println("Input after copying i:");
        printArray(input);

        while (j < n2) {
            input[k] = rArray[j];
            j++;
            k++;
        }
        System.out.println("Input:");
        printArray(input);
    }

    private void printArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++)
            System.out.print(inputArray[i] + " ");
        System.out.println();
    }


    public static void main(String a[]) {
        int[] arr = new int[]{4, 55, 1, 7, 10, 5, 70, 9, 11, 96, 3};
        MergeSort ms = new MergeSort();
        ms.sort(arr);
    }
}
