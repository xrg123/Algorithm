package cn;

import java.util.Arrays;

/**
 * @Author:XRG
 * @Date:2019/3/23 11:22
 * @Desctiption:
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        for(int i = 0; i < num.length -1; i++) {
            int min = i;
            for(int j = i + 1; j < num.length; j++) {
                if(num[min] > num[j]) {
                    min = j;
                }
            }
            if(min != i) {
                int temp = num[min];
                num[min] = num[i];
                num[i] = temp;
            }
        }
        System.out.println(Arrays.toString(num));
    }
}
