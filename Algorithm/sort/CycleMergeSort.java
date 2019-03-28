package cn;

import java.util.Arrays;

/**
 * @Author:XRG
 * @Date:2019/3/22 14:46
 * @Desctiption:
 */
public class CycleMergeSort {
    public static void main(String[] args) {
        int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int width = 1;
        while(width < num.length) {
            mergePass(num, width);
            width *= 2;
        }
        System.out.println(Arrays.toString(num));
    }

    public static void mergePass(int[] num, int width) {
        int start = 0;
        while(start + 2 * width -1 < num.length) {
            merge(num, start, start + width -1, start + 2 * width -1);
            start = start + 2 * width;
        }
        if(start + width -1 < num.length) {
            merge(num, start, start + width -1, num.length - 1);
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
