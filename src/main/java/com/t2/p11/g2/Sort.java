package com.t2.p11.g2;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] ints = {5, 2, 4, 6, 1, 3, 2, 6};
        System.out.println(Arrays.toString(ints));
        mergeSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    private static void mergeSort(int[] ints, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(ints, left, mid);
            mergeSort(ints, mid + 1, right);
            merge(ints, left, mid, right);
        }
    }

    private static void merge(int[] ints, int left, int mid, int right) {
        int n = right - left + 1;
        int[] result = new int[n];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid || j <= right) {
            if (i > mid)
                result[k++] = ints[j++];
            else if (j > right)
                result [k++] = ints[i++];
            else if (ints[i] < ints[j])
                result[k++] = ints[i++];
            else
                result[k++] = ints[j++];
        }
        for (j = 0; j < n; j++)
            ints[left + j] = result[j];
    }
}
