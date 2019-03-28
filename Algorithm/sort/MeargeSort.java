package cn;

import java.util.Arrays;

/**
 * @Author:XRG
 * @Date:2019/3/22 11:21
 * @Desctiption:
 */
public class MeargeSort {
    public static void main(String[] args) {
        int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        mergeSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }

    public static void mergeSort(int[] num, int start, int end) {
        if(start < end) {
            int mid = (start + end)/2;
            mergeSort(num, start, mid);
            mergeSort(num, mid + 1, end);
            merge(num, start, mid, end);
        }
    }

    public static void merge(int[] num, int s, int m, int e) {
        int i, j, k;
        int[] temp = new int[num.length];
        for(i = s, j = m + 1, k = s; i <= m && j <= e; k++) {
            if(num[i] < num[j]) {
                temp[k] = num[i++];
            } else {
                temp[k] = num[j++];
            }
        }
        if(i <= m) {
            for(int l = 0; l <= m - i; l++) {
                temp[k + l] = num[i + l];
            }
        }
        if(j <= e) {
            for(int l = 0; l <= e - j; l++) {
                temp[k + l] = num[j + l];
            }
        }
        for(i = s; i <= e; i++) {
            num[i] = temp[i];
        }
    }
}
