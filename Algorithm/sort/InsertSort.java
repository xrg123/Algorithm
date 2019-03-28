package cn;

import java.util.Arrays;

/**
 * @Author:XRG
 * @Date:2019/3/23 11:29
 * @Desctiption:
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int j;
        for(int i = 1; i < num.length; i++) {
            if(num[i] < num[i - 1]) {
                int temp = num[i];
                for(j = i - 1; j >= 0 && num[j] > temp; j--) {
                    num[j + 1] = num[j];
                }
                num[j + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(num));
    }
}
